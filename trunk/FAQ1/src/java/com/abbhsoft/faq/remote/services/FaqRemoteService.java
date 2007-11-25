/*
 * FaqRemoteService.java
 * 
 * Created on Nov 24, 2007, 5:48:41 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.faq.remote.services;

import java.util.List;

/**
 *
 * @author ABDUL RAHMAN
 */
public interface FaqRemoteService {
String SUCCESS = "Operation Success ";
String FAILURE = "Operation Failed";
public String addCategory(String name);
public String addTopic(String category, String topic);
public String addQuestion(String topic,String question,String answer);
public List search(String key);
public String addAnswer(String question,String answer);
public String markAnswerUnappropriate(Long id);
public List getAllCategories();
public List getAllDeveloper();

}
