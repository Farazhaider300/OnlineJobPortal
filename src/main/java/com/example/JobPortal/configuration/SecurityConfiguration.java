package com.example.JobPortal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableWebSecurity*/
/*@Configuration*/
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
    /*@Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Override
    public void configure(AuthenticationManagerBuilder aMgrBuilder) throws Exception
    {

        //aMgrBuilder.inMemoryAuthentication().withUser("admin").password("pwd_").roles("ADMIN");
        //aMgrBuilder.inMemoryAuthentication().withUser("faraz").password("_pwd").roles("USER");


        aMgrBuilder.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .and().authorizeRequests()
                .antMatchers("/home/findjob/**").hasAnyAuthority("Job_Seeker","Job_Poster")
                .antMatchers("/admin/**").hasAuthority("Admin")
                .and()
                .formLogin()
                .permitAll();

    }*/


}
