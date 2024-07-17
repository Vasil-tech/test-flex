package com.flex.neoflex.config;

import com.flex.neoflex.interceptors.GeneralInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {
	@Autowired
	private GeneralInterceptor generalInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(generalInterceptor).addPathPatterns("/reg");
	}
}
