package com.Giz;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class WebConfig implements WebMvcConfigurer{

//    @Bean
    public ObjectMapper configureJson() {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
                .build();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeJson()
    {
        return builder -> {

            builder.indentOutput(true);
            builder.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        };
    }
    
    @Bean
    public LocaleResolver localeResolver() {
    	SessionLocaleResolver slr = new SessionLocaleResolver(); 
    	slr.setDefaultLocale(Locale.FRENCH);
    	
    	return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
    	LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    	lci.setParamName("lang");
    	
    	return lci;
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	
        
}