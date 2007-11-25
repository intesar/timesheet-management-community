/*
 * FaqRemoteServiceImpl.java
 *
 * Created on Nov 24, 2007, 5:49:54 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.faq.remote.services.impl;

import com.abbhsoft.faq.remote.services.FaqRemoteService;
import java.util.List;
import com.abbhsoft.faq.dao.*;
import com.abbhsoft.faq.model.*;
import java.util.Date;


/**
 *
 * @author ABDUL RAHMAN
 */
public class FaqRemoteServiceImpl implements FaqRemoteService {

    public String addCategory(String name) {
        Category c = new Category();
        CategoryDAO cdao = new CategoryDAO();
        c.setName(name);
        try {
            cdao.save(c);
        } catch (Exception e) {
            System.out.println(e);
            return FAILURE;
        }

        return SUCCESS;
    }

    public String addTopic(String category, String topic) {

        Topic t = new Topic();
        TopicDAO tdao = new TopicDAO();

        CategoryDAO cdao = new CategoryDAO();


        t.setCategory(cdao.findById(category));
        t.setName(topic);

        try {
            tdao.save(t);
        } catch (Exception e) {
            return FAILURE;
        }
        return SUCCESS;
    }

    public String addQuestion(String topic, String question, String answer) {

        QuestionsDAO qdao = new QuestionsDAO();
        AnswersDAO adao = new AnswersDAO();
        TopicDAO tdao = new TopicDAO();


        Topic t = tdao.findById(topic);

        Questions q = new Questions();
        q.setQuestion(question);
        q.setTopic(t);
        q.setAuthor("admin");
        Date d = new Date();
        q.setDate(d);

        Answers a = new Answers();
        a.setAnswer(answer);
        a.setQuestions(q);
        a.setAuthor("admin");
        a.setDate(d);

        try {

            qdao.save(q);
            adao.save(a);
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
        return SUCCESS;
    }

    public List search(String key) {
        List list;
        try {
            QuestionsDAO qdao = new QuestionsDAO();
            return qdao.findByQuestion(key);
        } catch (Exception e) {
            list = null;
            return list;
        }
    }

    public String addAnswer(String question, String answer) {

        QuestionsDAO qdao = new QuestionsDAO();
        AnswersDAO adao = new AnswersDAO();

        Questions q = qdao.findById(question);

        Answers a = new Answers();

        a.setQuestions(q);
        a.setAnswer(answer);

        try {
            adao.save(a);
        } catch (Exception e) {
            return FAILURE;
        }
        return SUCCESS;
    }

    public String markAnswerUnappropriate(Integer id) {

        AnswersDAO adao = new AnswersDAO();
        Answers a;

        try {
            a = adao.findById(id);
            a.setIsAppropriate(Short.parseShort("0"));
            adao.merge(a);
        } catch (Exception e) {
            return FAILURE;
        }
        return SUCCESS;
    }

    public List getAllCategories() {
        List list;
        CategoryDAO cdao = new CategoryDAO();
        try {
            list = cdao.findAll();
            return list;
        } catch (Exception e) {
            list = null;
            return list;
        }
    }

    public List getAllDeveloper() {
        List list;
        DeveloperDAO ddao = new DeveloperDAO();
        try {
            list = ddao.findAll();
            return list;
        } catch (Exception e) {
            list = null;
            return list;
        }
    }
}