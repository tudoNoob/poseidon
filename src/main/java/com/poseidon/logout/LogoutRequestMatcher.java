package com.poseidon.logout;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class LogoutRequestMatcher implements RequestMatcher {

	@Override
	public boolean matches(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		if(requestURI.equals("/logout")){
			return true;
		}
		return false;
	}

}
