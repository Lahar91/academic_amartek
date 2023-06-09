package com.academic.amartek.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {
     // authentication

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
             throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }
 
     // @Bean
     // protected void configure(AuthenticationManagerBuilder auth) throws Exception
     // {
     // auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     // }
 
     // encrypt
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 
     // authorization
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity
                 .csrf().disable()
                 .authorizeRequests((auth) -> {
                     try {
                         auth
                                 .antMatchers("/api/**").permitAll()
                                 .antMatchers("/role/**", "/employee/**, /dashboard/**").hasAuthority("QA")
                                 .anyRequest().authenticated()
                                 .and()
                                 .formLogin()
                                 .loginPage("/user/login")
                                 .usernameParameter("email")
                                 .and()
                                 .httpBasic()
                                 .and()
                                 .logout();
                     } catch (Exception ex) {
                         throw new RuntimeException(ex);
                     }
                 });
         return httpSecurity.build();
     }
}
