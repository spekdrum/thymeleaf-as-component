package org.spekdrum.thymeleafac.config;

import org.spekdrum.thymeleafac.tlresolver.TlDatabaseTemplateResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Configuration
public class SpringTemplateEngineConfig {

	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine(TlDatabaseTemplateResolver dbTemplateResolver) {
		//customize TlDatabaseTemplateResolver settings here
		dbTemplateResolver.setTemplateMode("XHTML");

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(dbTemplateResolver);
		return templateEngine;
	}

}
