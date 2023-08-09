package com.buffettinc.hrms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * This class sets up the necessary configuration for the web application, such as defining the login page, logout page,
 * where to redirect the user after logging in, and which pages to require authentication and which to permit to all users.
 *
 * @author IST 412 Group 5
 * @since 2023-07-21
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()
                    .requestMatchers("/dashboard").authenticated()
                    .requestMatchers("/employees").authenticated()
                    .requestMatchers("/messages").authenticated()
                    .requestMatchers("/notifications").authenticated()
                    .requestMatchers("/payroll").authenticated()
                    .requestMatchers("/paystubs").authenticated()
                    .requestMatchers("/pto").authenticated()
                    .requestMatchers("/tasks").authenticated()
                    .requestMatchers("/timesheets").authenticated()
                    .requestMatchers("/shiftentry").authenticated()
                    .requestMatchers("/training").authenticated()
                    .requestMatchers("/index").permitAll()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/dashboard", true)
                .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                .and()
                    .httpBasic(Customizer.withDefaults())
                    .csrf().disable();
        return http.build();

    }
}
