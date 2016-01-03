package com.poseidon.logout;

import java.io.IOException;

import javax.servlet.http.*;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

	private Logger logger = Logger.getLogger(CustomLogoutHandler.class);
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		authentication= null;
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			logger.info("Erro ao tentar redirecionar para a pagina de login",e);
		}
	}

}
