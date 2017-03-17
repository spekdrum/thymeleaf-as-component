package org.spekdrum.thymeleafac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Abstraction from SpringTemplateEngine.
 */
@Service
public class TlTransformService {

	private final SpringTemplateEngine templateEngine;

	@Autowired
	public TlTransformService(SpringTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	public String applyTemplate(String templateId, Context valuesMap) {
		return templateEngine.process(templateId, valuesMap);
	}

	public void clearTemplateCache() {
		templateEngine.clearTemplateCache();
	}

	public void clearTemplateCache(String template) {
		templateEngine.clearTemplateCacheFor(template);
	}
}
