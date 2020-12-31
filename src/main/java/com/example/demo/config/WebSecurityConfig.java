package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig
  extends WebSecurityConfigurerAdapter {
 
  @Bean
  public UserDetailsService uds() {
	 InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
 
    var u = User.withUsername("john")
                .password("12345")
                .authorities("ADMIN")
                .build();
 
    inMemoryUserDetailsManager.createUser(u);
 
    return inMemoryUserDetailsManager;
  }
 
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
 
  @Bean
  public AuthenticationManager authenticationManagerBean()
    throws Exception {
    return super.authenticationManagerBean();
  }
 
}
