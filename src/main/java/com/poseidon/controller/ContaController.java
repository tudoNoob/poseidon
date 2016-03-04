package com.poseidon.controller;

import com.google.common.collect.Lists;
import com.poseidon.annotation.NotNullArgs;
import com.poseidon.annotation.ViewName;
import com.poseidon.builder.ContaViewBuilder;
import com.poseidon.dao.AuthoritiesRepository;
import com.poseidon.dao.UserRepository;
import com.poseidon.enums.CRUDViewEnum;
import com.poseidon.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class ContaController extends ControllerBase {

    public static final String ROLE_PREFIX = "ROLE_";

    public static final String CONTAS_CLASS_NAME = "contas";
    public static final String CONTA_VIEW_NAME = "Conta";
    public static final String REDIRECT_ADMIN_CONTA = "redirect:/admin/conta";

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    UserRepository userRepository;

    private Logger logger = Logger.getLogger("ContaController");


    @RequestMapping(value = "/cadastrarConta")
    @ViewName(name = REDIRECT_ADMIN_CONTA)
    @NotNullArgs
    public ModelAndView cadastrarConta(@ModelAttribute ContaView contaView,
                                       @ModelAttribute String role,
                                       ModelAndView modelAndView,
                                       RedirectAttributes redirectAttributes) {
        Users user = Users.createUser(contaView);

        userRepository.save(user);

        authoritiesRepository.save(new Authorities(user.getUsername(),
                new StringBuilder()
                        .append(ROLE_PREFIX)
                        .append(contaView.getRole())
                        .toString()));

        this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_SAVE);

        return modelAndView;
    }

    private void exibirConta(ModelAndView modelAndView) {
        Iterable<Users> contaList = userRepository.findAll();
        List<ContaView> contasView = Lists.newArrayList();
        for (Users user : contaList) {
            if ((user != null) && (user.getUsername() != null) && (!user.getUsername().isEmpty())) {
                Authorities authority = authoritiesRepository.findByUsername(user.getUsername());
                contasView.add(new ContaViewBuilder()
                        .convertUsersThroughContaView(user)
                        .withAuthority(authority.getAuthority()).build());
            }
        }
        modelAndView.getModelMap().addAttribute(CONTAS_CLASS_NAME, contasView);
    }

    @RequestMapping(value = "/deletarConta")
    @ViewName(name = REDIRECT_ADMIN_CONTA)
    @NotNullArgs
    public ModelAndView deletarConta(@ModelAttribute ContaView contaView,
                                     ModelAndView modelAndView,
                                     RedirectAttributes redirectAttributes) {
        Users user = userRepository.findByUsername(contaView.getUsername());
        Authorities authorities = authoritiesRepository.findByUsername(contaView.getUsername());
        try {
            userRepository.delete(user);
            authoritiesRepository.delete(authorities);
        } catch (RuntimeException exception) {
            logger.info("Deletando com sucesso.");
        }

        this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_DELETE);

        return modelAndView;
    }

    @RequestMapping("/editarConta")
    @ViewName(name = REDIRECT_ADMIN_CONTA)
    @NotNullArgs
    public ModelAndView editarConta(ModelAndView modelAndView,
                                    @ModelAttribute ContaView contaView,
                                    RedirectAttributes redirectAttributes) {
        Users user = userRepository.findByUsername(contaView.getUsername());
        if (user == null) {
            return modelAndView;
        }
        saveUser(contaView, user);
        saveAuthority(contaView, user);
        this.buildRedirectFlashAttributes(redirectAttributes, CRUDViewEnum.IS_UPDATE);
        return modelAndView;
    }

    private void saveUser(@ModelAttribute ContaView contaView, Users user) {
        user.setUsername(contaView.getUsername());
        user.setPassword(contaView.getPassword());
        userRepository.save(user);
    }

    private void saveAuthority(@ModelAttribute ContaView contaView, Users user) {
        Authorities authority = authoritiesRepository.findByUsername(user.getUsername());
        authority.setUsername(user.getUsername());
        authority.setAuthority(ROLE_PREFIX +contaView.getRole());
        authoritiesRepository.save(authority);
    }

    @RequestMapping("/conta")
    @ViewName(name = CONTA_VIEW_NAME)
    public ModelAndView returnpage(ModelAndView modelAndView, @ModelAttribute CRUDView crudView) {
        modelAndView.getModelMap().addAttribute(CRUDVIEW_CLASS_NAME, crudView);
        exibirConta(modelAndView);
        return modelAndView;
    }

}
