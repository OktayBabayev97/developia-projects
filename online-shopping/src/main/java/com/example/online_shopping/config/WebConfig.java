package com.example.online_shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Bean
public HandlerExceptionResolver customHandlerExceptionResolver() {
	return new CustomHandlerExceptionResolver();
}
}
