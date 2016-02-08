package com.poseidon.logout;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

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
