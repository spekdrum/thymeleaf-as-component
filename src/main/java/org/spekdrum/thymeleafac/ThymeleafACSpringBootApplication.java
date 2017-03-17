package org.spekdrum.thymeleafac;

import javax.annotation.PostConstruct;

import org.spekdrum.thymeleafac.model.TlTemplate;
import org.spekdrum.thymeleafac.respository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafACSpringBootApplication {

	@Autowired
	TemplateRepository templateRepository;
	
	@PostConstruct
	public void initializeSampleData() {
		templateRepository.save(
				new TlTemplate("test-template", "<h1 th:inline=\"text\">Hello [[${name}]]</h1>"));
	}

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafACSpringBootApplication.class, args);
    }
}
