package com.poseidon;

import com.poseidon.logout.CustomLogoutHandler;
import com.poseidon.logout.LogoutRequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/createSimpleUser","/createUser").permitAll();
		http.authorizeRequests().antMatchers("/*").authenticated();
		http.authorizeRequests().antMatchers("/css/**","/jquery/**","/bootstrap/**","/jquery/images/**","/webjars/**").permitAll();
		http.formLogin().loginPage("/loginPage").defaultSuccessUrl("/homePage").failureUrl("/login-Error")
		.permitAll().and().logout().addLogoutHandler(new CustomLogoutHandler()).logoutRequestMatcher(new LogoutRequestMatcher()).invalidateHttpSession(true);
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource);
	}
}