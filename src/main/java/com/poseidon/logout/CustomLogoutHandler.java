package com.poseidon.logout;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutHandler implements LogoutHandler {

	private Logger logger = Logger.getLogger(CustomLogoutHandler.class);
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		authentication= null;
		try {
			response.sendRedirect("/loginPage");
		} catch (IOException e) {
			logger.info("Erro ao tentar redirecionar para a pagina de login",e);
		}
	}
}
