package com.abbhsoft.faq.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Questions entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Questions implements java.io.Serializable {

    // Fields

    private String question;
    private Topic topic;
    private String author;
    private Date date;
    private Set answerses = new HashSet(0);
    private String simpleDate;

    public String getSimpleDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);

    }

    public void setSimpleDate(String simpleDate) {
        this.simpleDate = simpleDate;
    }
    // Constructors

    /** default constructor */
    public Questions() {
    }

    /** minimal constructor */
    public Questions(String question, Topic topic, String author, Date date) {
        this.question = question;
        this.topic = topic;
        this.author = author;
        this.date = date;
    }

    /** full constructor */
    public Questions(String question, Topic topic, String author, Date date,
            Set answerses) {
        this.question = question;
        this.topic = topic;
        this.author = author;
        this.date = date;
        this.answerses = answerses;
    }

    // Property accessors

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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

    public Set getAnswerses() {
        return this.answerses;
    }

    public void setAnswerses(Set answerses) {
        this.answerses = answerses;
    }
}