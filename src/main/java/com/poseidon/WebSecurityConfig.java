package com.poseidon;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import com.poseidon.logout.*;

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
		http.formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login-Error")
		.permitAll().and().logout().addLogoutHandler(new CustomLogoutHandler()).logoutRequestMatcher(new LogoutRequestMatcher()).invalidateHttpSession(true);
		http.authorizeRequests().antMatchers("/cadastroMedico").hasRole("ADMIN").anyRequest().authenticated();
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource);
	}
}