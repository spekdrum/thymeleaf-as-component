package org.spekdrum.thymeleafac.tlresolver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.spekdrum.thymeleafac.model.TlTemplate;
import org.spekdrum.thymeleafac.respository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Spring JPA Database template resolver for Thymeleaf.
 */
@Component
public class TlDatabaseTemplateResolver extends TemplateResolver {

	private static final String PATTERN = "*";
	private static final String CHARACTER_ENCODING = "UTF-8";
	private static final String TEMPLATE_MODE = "XHTML";

	private final TemplateRepository templateRepository;

	@Autowired
	public TlDatabaseTemplateResolver(TemplateRepository templateRepository) {
		this.templateRepository = templateRepository;
		setResourceResolver(new DbResourceResolver());
		setResolvablePatterns(Stream.of(PATTERN).collect(Collectors.toSet()));
        setCharacterEncoding(CHARACTER_ENCODING);
		setTemplateMode(TEMPLATE_MODE);
		setOrder(1);
    }

	@Override
	protected String computeResourceName(TemplateProcessingParameters templateProcessingParameters) {
		return templateProcessingParameters.getTemplateName();
	}
	
	private class DbResourceResolver implements IResourceResolver {

		@Override
		public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters, String resourceName) {

            TlTemplate tlTemplate = templateRepository.findOne(resourceName);
            if (tlTemplate != null) {
                return new ByteArrayInputStream(tlTemplate.getContent().getBytes());
            }

            return null;
		}
		
		@Override
		public String getName() {
			return "dbResourceResolver";
		}
	}
}
