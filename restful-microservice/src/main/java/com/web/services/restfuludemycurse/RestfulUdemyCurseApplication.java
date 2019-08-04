package com.web.services.restfuludemycurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulUdemyCurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulUdemyCurseApplication.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver localResolver() {

		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();

		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;

	}

	/*Instead of this bean, we can use a property spring.messages.basename=messages inside application.properties
	@Bean
	public ResourceBundleMessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");

		return messageSource;
	}*/
}

