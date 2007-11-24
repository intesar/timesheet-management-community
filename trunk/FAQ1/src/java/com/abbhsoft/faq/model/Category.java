package com.abbhsoft.faq.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String name;
	private Set topics = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String name) {
		this.name = name;
	}

	/** full constructor */
	public Category(String name, Set topics) {
		this.name = name;
		this.topics = topics;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

}