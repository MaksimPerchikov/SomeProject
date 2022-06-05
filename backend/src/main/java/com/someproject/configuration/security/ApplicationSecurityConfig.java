package com.someproject.configuration.security;

import com.someproject.configuration.security.encoderPass.PasswordConfig;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.someproject.configuration.security.ApplicationUserRole.*;
import static org.springframework.security.core.userdetails.User.builder;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/addProduct").hasAnyRole(ADMIN.name(), COOK.name())
                .antMatchers("/api/findAllProd").hasAnyRole(ADMIN.name(), COOK.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();*/

        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/hello").permitAll()
            .antMatchers("/api/addProduct").hasAnyRole(ADMIN.name(), COOK.name())
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/api/hello")
            .passwordParameter("password")
            .usernameParameter("username")
            .and()
            .rememberMe()
            .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
            .key("somethingmykey")
            .rememberMeParameter("remember-me")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID", "remember-me")
            .logoutSuccessUrl("/login");

    }

    @Bean

    @Override
    protected UserDetailsService userDetailsService() {
       UserDetails admin = User.builder()
                .username("adm")
                .password(passwordEncoder.encode("123"))
                .roles(ADMIN.name())
               .build();

       UserDetails cook = User.builder()
               .username("cook")
               .password(passwordEncoder.encode("456"))
               .roles(COOK.name())
               .build();
       UserDetails customer = User.builder()
               .username("customer")
               .password(passwordEncoder.encode("789"))
               .roles(CUSTOMER.name())
               .build();

        return new InMemoryUserDetailsManager(admin,cook,customer);
    }
}
