package org.spekdrum.thymeleafac.respository;

import org.spekdrum.thymeleafac.model.TlTemplate;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository extends CrudRepository<TlTemplate, String> {

}
