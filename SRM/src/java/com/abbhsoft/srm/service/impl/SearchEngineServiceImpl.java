/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.EmailGroupDao;
import com.abbhsoft.srm.dao.EventDao;
import com.abbhsoft.srm.dao.StudentDao;
import com.abbhsoft.srm.dao.UniversityDao;
import com.abbhsoft.srm.service.SearchEngineService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Intesar.Mohammed
 */
public class SearchEngineServiceImpl implements SearchEngineService {

    public List search(String text) {
        List list = new ArrayList();
        String[] tokens = text.split(" ");
        if (tokens.length == 1) {
            try {
                Date date = new SimpleDateFormat("MM/dd/yy").parse(text);
                list.addAll(this.eventDao.findByDate(date));
            } catch (Exception e) {
                try {
                    Long.parseLong(text);
                    list.addAll(this.studentDao.findByPhoneNumber(text, text, text, text, text));
                } catch (Exception e1) {
                    List l = this.studentDao.findBySingleString(text, text, text, text, text, text, text);//, text, text, text);
                    System.out.println ( " list size : " + l  + " " + text);
                    list.addAll(l);
                    list.addAll(this.eventDao.findBySingleString(text, text, text));
                    list.addAll(this.universityDao.findByName(text));
                    list.addAll(this.emailGroupDao.findByEmails(text, text, text, text));
                }
            }

        } else {
            if (tokens.length == 2) {
                try {
                    Date startDate = new SimpleDateFormat("MM/dd/yy").parse(tokens[0]);
                    Date endDate = new SimpleDateFormat("MM/dd/yy").parse(tokens[1]);
                    list.addAll(this.eventDao.findByEventDates(startDate, endDate));
                } catch (Exception e) {
                    list.addAll(this.studentDao.findByFirstNameLastNameOrCityState(tokens[0], tokens[1], tokens[0], tokens[1]));
                }
            }

        }
        return list;
    }
    private StudentDao studentDao;
    private EventDao eventDao;
    private UniversityDao universityDao;
    private EmailGroupDao emailGroupDao;

    public void setEmailGroupDao(EmailGroupDao emailGroupDao) {
        this.emailGroupDao = emailGroupDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setUniversityDao(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }
}
