package org.spekdrum.thymeleafac.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TlTemplate {

	@Id
	private String id;
	
	private String content;

	public TlTemplate() {
	}

	public TlTemplate(String id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
