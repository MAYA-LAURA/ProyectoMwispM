package com.mx.mwisp.mwsipfinal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auths) throws Exception{
		auths.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
//		http.authorizeRequests().antMatchers("/Admin/listaProductosAdmin","/Admin/formProducto").access("hasRole('ROLE_USER')");
//		
//		http.authorizeRequests().and().formLogin()
//		.loginPage("/login").loginProcessingUrl("/logincheck")
//		.usernameParameter("username").passwordParameter("password")
//		.defaultSuccessUrl("/loginsuccess").permitAll()
//		.and()
//	.logout()
//		.permitAll();
		
		http.authorizeRequests()
	.antMatchers("/Admin/**").authenticated()
	.anyRequest().permitAll()
	.and()
	.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
	.usernameParameter("username").passwordParameter("password")
	.defaultSuccessUrl("/loginsuccess").permitAll()
	.and()
	.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
	.permitAll();
	
	}

}
