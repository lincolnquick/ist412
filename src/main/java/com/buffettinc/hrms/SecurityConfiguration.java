package com.buffettinc.hrms;
import com.buffettinc.hrms.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


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

//        http
//
//                .authorizeRequests(authorize -> authorize
//
//                                .requestMatchers("/index").permitAll() // Unlocks index page
//                                .requestMatchers("/login").permitAll()  // Unlocks login page
//                                .requestMatchers("/register").permitAll() // Unlocks register page
//                                .requestMatchers("/register_process").permitAll() // Unlocks register process page
//                                .requestMatchers("/register_success").permitAll() // Unlocks register success page
//                                .requestMatchers("/logout").permitAll()
//                                .anyRequest().authenticated() // Locks all other pages, requiring login
//
//                        //.anyRequest().permitAll() // Unlocks all pages, not required login
//                )
//                .formLogin(formLogin -> formLogin
//                        .defaultSuccessUrl("/dashboard", true) // sets default page after successful login
//                        .loginProcessingUrl("/register_process").permitAll()
//                        .loginProcessingUrl("/register_success").permitAll()
//                        .loginPage("/login").permitAll()
//
//                )
//                .logout( logout -> logout
//                        .logoutUrl("/logout").permitAll()
//                        .logoutSuccessUrl("/index").permitAll()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .csrf().disable();
//         return http.build();
    }




}
