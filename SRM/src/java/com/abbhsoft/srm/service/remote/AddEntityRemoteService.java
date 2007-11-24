/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.service.remote;

import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.service.EmailGroupService;
import com.abbhsoft.srm.service.EventService;
import com.abbhsoft.srm.service.ServiceFactory;
import com.abbhsoft.srm.service.StudentService;
import com.abbhsoft.srm.service.UniversityService;
import com.abbhsoft.srm.service.EMailService;
import java.util.List;

/**
 *
 * @author mdshannan
 */
public class AddEntityRemoteService {

    /*
     *  takes university name and adds to the database
     *  throws runtime exception if university already exists
     * 
     */
    public String addUniversity(String name) {
        String msg = "Operation Successful!";
        UniversityService service = (UniversityService) ServiceFactory.getInstance().getBean("universityServiceImpl");
        University u = new University();
        u.setName(name);
        try {
            service.save(u);
        } catch (RuntimeException re) {
            msg = "Error Creating University!";
            throw re;
        } finally {
            return msg;
        }
    }

    /*
     *  creates a new event
     *  date cannot be null
     * 
     */
    public String addEvent(String type, String description, String date, String priority) {
        String msg = "Operation Successful!";
        EventService service = (EventService) ServiceFactory.getInstance().getBean("eventServiceImpl");
        Event e = new Event();
        if (type == null || type.length() < 1) {
            return "Type is Required!";
        }
        e.setType(type);
        e.setDescript(description);
        e.setPriority(priority);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yy");
        try {
            java.util.Date dt = sdf.parse(date);
            e.setDate(dt);
            service.save(e);
        } catch (java.text.ParseException p) {
            msg = " Invalid Date!";
            throw p;
        } catch (RuntimeException re) {
            msg = "Error Creating Event!";
            throw re;
        } finally {
            return msg;
        }
    }

    /*
     *  creates a new group
     *  groupEmail cannot be null
     * 
     */
    public String addEmailGroup(String emailGroup, String owner, String subscribe, String unsubscribe) {
        String msg = "Operation Successful!";
        EmailGroupService service = (EmailGroupService) ServiceFactory.getInstance().getBean("emailGroupServiceImpl");
        EmailGroup e = new EmailGroup();
        e.setOwner(owner);
        e.setGroupEmail(emailGroup);
        e.setSubscribeEmail(subscribe);
        e.setUnsubscribeEmail(unsubscribe);
        try {
            service.save(e);
        } catch (RuntimeException re) {
            msg = "Error Creating Email Group!";
            throw re;
        } finally {
            return msg;
        }
    }

    /*
     *  creates a new student
     * 
     */
    public String addStudent(String firstname, String lastname,
            String email, String mobile, String visaStatus,
            String refferedBy) {
        String msg = "Operation Successful!";
        try {
            Student s = new Student();
            s.setFirstName(firstname);
            s.setLastName(lastname);
            s.setEmail(email);
            s.setMobilePhone(mobile);
            s.setVisaStatus(visaStatus);
            s.setRefferedBy(refferedBy);
            StudentService service = (StudentService) ServiceFactory.getInstance().getBean("studentServiceImpl");
            service.save(s);
        } catch (RuntimeException re) {
            msg = "Error Creating Student!";
            throw re;
        } finally {
            return msg;
        }
    }

    public void sendEmailToAllStudents() {
        EMailService service = (EMailService) ServiceFactory.getInstance().getBean("eMailServiceImpl");
        StudentService studentService = (StudentService) ServiceFactory.getInstance().getBean("studentServiceImpl");
        List<Student> students = studentService.getAll();
        List<String> email = studentService.getAllStudentEmails();
        System.out.println (" $$$$$$$  : " + email);
        String[] emails = new String[email.size()];
        int count = 0;
        for (String s : email) {
            emails[count++] = s;
        }
        String[] s = {"mohdshannan@yahoo.com"};
        service.SendMail(emails);
    }

//    public static void main(String[] args) {
//
//        AddEntityRemoteService a = new AddEntityRemoteService();
//        a.sendEmail();
//    }
}
// public String addStudent(String firstname,  String lastname,
//            String email,  String mobile, String visaStatus,
//             String refferedBy       ) {
//        String msg = "Operation Successful!";
//        try {
//            Student s = new Student();
//            s.setFirstName(firstname);
//            s.setMi(mi);
//            s.setLastName(lastname);
//            s.setEmail(email);
//            s.setSecondaryEmail(secondaryEmail);
//            s.setMobilePhone(mobile);
//            s.setHomePhone(homePhone);
//            s.setFax(fax);
//            s.setOtherPhone(otherPhone);
//            s.setEducation(education);
//            s.setVisaStatus(visaStatus);
//            s.setGender(gender);
//            s.setAge(age);
//            s.setNationality(nationality);
//            s.setRefferedBy(refferedBy);
//            if (expectedStartDate != null && expectedStartDate.length() > 0) {
//                try {
//                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yy");
//                    java.util.Date dt = sdf.parse(expectedStartDate);
//                    s.setExpectedStartDate(dt);
//                } catch (java.text.ParseException p) {
//                    msg += " (Warning : Invalid Expected Start Date)";
//                }
//            }
//            s.setTag(tag);
//            if ((city != null && city.length() > 0) ||
//                    (street != null && street.length() > 0)) {
//                Address a = new Address();
//                a.setStreet(street);
//                a.setCity(city);
//                a.setState(state);
//                a.setZipcode(zipcode);
//                a.setCountry(country);
//                s.setAddress(a);
//            }
//            StudentService service = (StudentService) ServiceFactory.getInstance().getBean("studentServiceImpl");
//            service.save(s);
//        } catch (RuntimeException re) {
//            msg = "Error Creating Student!";
//            throw re;
//        } finally {
//            return msg;
//        }
//    }

