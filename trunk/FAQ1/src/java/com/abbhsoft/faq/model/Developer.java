package com.abbhsoft.faq.model;

/**
 * Developer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Developer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String contribution;

	// Constructors

	/** default constructor */
	public Developer() {
	}

	/** minimal constructor */
	public Developer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Developer(Integer id, String name, String email, String phone,
			String contribution) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.contribution = contribution;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContribution() {
		return this.contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

}