package com.araxsys.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			
			
			// All the things.
			httpSecurity.authorizeRequests().antMatchers("/").permitAll()
			
			//------Must be logged in to view------
			.antMatchers("/lock").authenticated()
			
			//------Must have specified role to access------
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			
			.and().formLogin();
		}
		
		
		@Autowired
		private DataSource dataSource;
		 

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth
				.jdbcAuthentication()
					.dataSource(dataSource)
					.usersByUsernameQuery(
							"select USERNAME,PASSWORD, enabled from users where USERNAME=?")
					.authoritiesByUsernameQuery(
						"select USERNAME, ROLE from user_roles where USERNAME=?");
		}
}


