package com.poseidon.controller;

import com.poseidon.builder.AuthoritiesBuilder;
import com.poseidon.builder.ContaViewBuilder;
import com.poseidon.builder.UsersBuilder;
import com.poseidon.dao.AuthoritiesRepository;

import com.poseidon.dao.UserRepository;
import com.poseidon.model.*;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


@Test
public class ContaControllerTest {


    private ContaController contaController;

    private UserRepository userRepository;

    private AuthoritiesRepository authoritiesRepository;

    @BeforeTest
    public void setUp(){

        contaController= new ContaController();
        userRepository= mock(UserRepository.class);
        authoritiesRepository= mock(AuthoritiesRepository.class);

        contaController.userRepository=userRepository;
        contaController.authoritiesRepository=authoritiesRepository;

    }

    @Test
    public void shouldBuildContaPageForCadastro(){

        List<Users> usersList = new UsersBuilder()
                .withPassword("pass").withUsername("Kakaroto").add()
                .withPassword("Bulma").withUsername("Vegetta").add()
                .buildAsList();

        when(userRepository.findAll()).thenReturn(usersList);

        Authorities  authoritiesKakaroto = new AuthoritiesBuilder().withAuthority("ROLE_ADMIN").withUsername("kakaroto").build();
        when(authoritiesRepository.findByUsername(usersList.get(1).getUsername())).thenReturn(authoritiesKakaroto);

        Authorities authoritiesVeggeta = new AuthoritiesBuilder().withAuthority("ROLE_USER").withUsername("Veggeta").build();
        when(authoritiesRepository.findByUsername(usersList.get(0).getUsername())).thenReturn(authoritiesVeggeta);

        String isCadastroConta = "true";
        String isEditarConta = "false";
        String isDeleteConta = "false";
        String isExibirConta = "false";

       ModelAndView response = contaController.returnpage(new ModelAndView(), new CRUDView());

        assertNotNull(response);
        assertNotNull(response.getModelMap().get("contas"));
        Assert.assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldBuildContaPageForEditar(){

        List<Users> usersList = new UsersBuilder()
                .withPassword("pass").withUsername("Kakaroto").add()
                .withPassword("Bulma").withUsername("Vegetta").add()
                .buildAsList();

        when(userRepository.findAll()).thenReturn(usersList);

        Authorities  authoritiesKakaroto = new AuthoritiesBuilder().withAuthority("ROLE_ADMIN").withUsername("kakaroto").build();
        when(authoritiesRepository.findByUsername(usersList.get(1).getUsername())).thenReturn(authoritiesKakaroto);

        Authorities authoritiesVeggeta = new AuthoritiesBuilder().withAuthority("ROLE_USER").withUsername("Veggeta").build();
        when(authoritiesRepository.findByUsername(usersList.get(0).getUsername())).thenReturn(authoritiesVeggeta);

        String isCadastroConta = "false";
        String isEditarConta = "true";
        String isDeleteConta = "false";
        String isExibirConta = "false";

        ModelAndView response = contaController.returnpage(new ModelAndView(), new CRUDView());

        assertNotNull(response);
        assertNotNull(response.getModelMap().get("contas"));
        assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldBuildContaPageForDelete(){

        List<Users> usersList = new UsersBuilder()
                .withPassword("pass").withUsername("Kakaroto").add()
                .withPassword("Bulma").withUsername("Vegetta").add()
                .buildAsList();

        when(userRepository.findAll()).thenReturn(usersList);

        Authorities  authoritiesKakaroto = new AuthoritiesBuilder().withAuthority("ROLE_ADMIN").withUsername("kakaroto").build();
        when(authoritiesRepository.findByUsername(usersList.get(1).getUsername())).thenReturn(authoritiesKakaroto);

        Authorities authoritiesVeggeta = new AuthoritiesBuilder().withAuthority("ROLE_USER").withUsername("Veggeta").build();
        when(authoritiesRepository.findByUsername(usersList.get(0).getUsername())).thenReturn(authoritiesVeggeta);

        String isCadastroConta = "false";
        String isEditarConta = "false";
        String isDeleteConta = "true";
        String isExibirConta = "false";

        ModelAndView response = contaController.returnpage(new ModelAndView(), new CRUDView());

        assertNotNull(response);
        assertNotNull(response.getModelMap().get("contas"));
        assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldBuildContaPageForExibir(){

        List<Users> usersList = new UsersBuilder()
                .withPassword("pass").withUsername("Kakaroto").add()
                .withPassword("Bulma").withUsername("Vegetta").add()
                .buildAsList();

        when(userRepository.findAll()).thenReturn(usersList);

        Authorities  authoritiesKakaroto = new AuthoritiesBuilder().withAuthority("ROLE_ADMIN").withUsername("kakaroto").build();
        when(authoritiesRepository.findByUsername(usersList.get(1).getUsername())).thenReturn(authoritiesKakaroto);

        Authorities authoritiesVeggeta = new AuthoritiesBuilder().withAuthority("ROLE_USER").withUsername("Veggeta").build();
        when(authoritiesRepository.findByUsername(usersList.get(0).getUsername())).thenReturn(authoritiesVeggeta);

        String isCadastroConta = "false";
        String isEditarConta = "false";
        String isDeleteConta = "false";
        String isExibirConta = "true";

        ModelAndView response = contaController.returnpage(new ModelAndView(), new CRUDView());

        assertNotNull(response);
        assertNotNull(response.getModelMap().get("contas"));
        assertNotNull(response.getModelMap().get("crudview"));
    }

    @Test
    public void shouldCadatrarConta(){
        Users  users = new UsersBuilder().withPassword("Bulma").withUsername("Veggeta").build();
        ContaView conta = new ContaViewBuilder().convertUsersThroughContaView(users).withAuthority("ROLE_ADMIN").build();

        ModelAndView response = contaController.cadastrarConta(conta, "ROLE_ADMIN", new ModelAndView());
        assertNotNull(response);
        assertNull(response.getViewName());

    }

    @Test
    public void shouldDeleteConta(){
        Users  users = new UsersBuilder().withPassword("Bulma").withUsername("Veggeta").build();
        ContaView conta = new ContaViewBuilder().convertUsersThroughContaView(users).withAuthority("ROLE_ADMIN").build();

        Authorities authorities = new AuthoritiesBuilder().withUsername("Veggeta").withAuthority("ROLE_ADMIN").build();
        when(authoritiesRepository.findByUsername(conta.getUsername())).thenReturn(authorities);

        when(userRepository.findByUsername(conta.getUsername())).thenReturn(users);

        ModelAndView response = contaController.deletarConta(conta,new ModelAndView());
        assertNotNull(response);
        assertNull(response.getViewName());

    }

    @Test
    public void shouldEditarConta(){
        Users  users = new UsersBuilder().withPassword("Bulma").withUsername("Veggeta").build();
        ContaView conta = new ContaViewBuilder().convertUsersThroughContaView(users).withAuthority("ROLE_ADMIN").build();

        Authorities authorities = new AuthoritiesBuilder().withUsername("Veggeta").withAuthority("ROLE_ADMIN").build();
        when(authoritiesRepository.findByUsername(conta.getUsername())).thenReturn(authorities);

        when(userRepository.findByUsername(conta.getUsername())).thenReturn(users);

        ModelAndView response = contaController.editarConta(new ModelAndView(),conta);
        assertNotNull(response);
        assertNull(response.getViewName());

    }

}
