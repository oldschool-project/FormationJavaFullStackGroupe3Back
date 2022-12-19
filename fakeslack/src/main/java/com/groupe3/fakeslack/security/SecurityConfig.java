package com.groupe3.fakeslack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

        System.out.println("Toto is coming");

        auth.inMemoryAuthentication().withUser("user")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password")).roles("USER");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/channel", "/message").access("hasRole('USER')")
                .antMatchers("/user", "/**").hasRole("ADMIN")

                .and()

                .httpBasic()

                .and()

                .logout(logout -> logout.logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID"));

        return http.build();
    }
}

