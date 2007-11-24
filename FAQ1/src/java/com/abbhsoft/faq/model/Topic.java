package com.abbhsoft.faq.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private String name;
	private Category category;
	private Set questionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	/** full constructor */
	public Topic(String name, Category category, Set questionses) {
		this.name = name;
		this.category = category;
		this.questionses = questionses;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set getQuestionses() {
		return this.questionses;
	}

	public void setQuestionses(Set questionses) {
		this.questionses = questionses;
	}

}