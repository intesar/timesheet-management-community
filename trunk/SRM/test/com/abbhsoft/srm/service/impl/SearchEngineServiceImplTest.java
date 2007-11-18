/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.base.BaseTest;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.service.CampusService;
import com.abbhsoft.srm.service.EmailGroupService;
import com.abbhsoft.srm.service.EventService;
import com.abbhsoft.srm.service.SearchEngineService;
import com.abbhsoft.srm.service.StudentService;
import java.util.List;

/**
 *
 * @author Intesar.Mohammed
 */
public class SearchEngineServiceImplTest extends BaseTest {

    public SearchEngineServiceImplTest(String testName) {
        super(testName);
    }
    private SearchEngineService searchEngineService;
    private StudentService studentService;
    private EventService eventService;
    private CampusService campusService;
    private EmailGroupService emailGroupService;

    public void setSearchEngineService(SearchEngineService searchEngineService) {
        this.searchEngineService = searchEngineService;
    }

    public void setCampusService(CampusService campusService) {
        this.campusService = campusService;
    }

    public void setEmailGroupService(EmailGroupService emailGroupService) {
        this.emailGroupService = emailGroupService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Test of search method, of class SearchEngineServiceImpl.
     */
    public void testSearch() {
        System.out.println("search");
        Student s0 = new Student();
        s0.setLastName("mohammed");
        Student s1 = new Student();
        s1.setLastName("mohammed");
        Student s2 = new Student();
        s2.setLastName("mohammed");

        this.studentService.save(s0);
        this.studentService.save(s1);
        this.studentService.save(s2);
        String text = "mohammed";


        List result = searchEngineService.search(text);
        assertTrue(result.size() >= 3);
    }
}
