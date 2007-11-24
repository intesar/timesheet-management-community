package com.abbhsoft.faq.model;

import java.util.Date;

/**
 * Answers entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Answers implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questions questions;
	private String answer;
	private String author;
	private Date date;
	private Short isAppropriate;
	private String isAppropriateBy;

	// Constructors

	/** default constructor */
	public Answers() {
	}

	/** minimal constructor */
	public Answers(Integer id, Questions questions, String answer,
			String author, Date date) {
		this.id = id;
		this.questions = questions;
		this.answer = answer;
		this.author = author;
		this.date = date;
	}

	/** full constructor */
	public Answers(Integer id, Questions questions, String answer,
			String author, Date date, Short isAppropriate,
			String isAppropriateBy) {
		this.id = id;
		this.questions = questions;
		this.answer = answer;
		this.author = author;
		this.date = date;
		this.isAppropriate = isAppropriate;
		this.isAppropriateBy = isAppropriateBy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Short getIsAppropriate() {
		return this.isAppropriate;
	}

	public void setIsAppropriate(Short isAppropriate) {
		this.isAppropriate = isAppropriate;
	}

	public String getIsAppropriateBy() {
		return this.isAppropriateBy;
	}

	public void setIsAppropriateBy(String isAppropriateBy) {
		this.isAppropriateBy = isAppropriateBy;
	}

}