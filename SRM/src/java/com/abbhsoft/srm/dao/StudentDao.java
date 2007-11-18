/*
 * StudentDao.java
 * 
 * Created on Nov 17, 2007, 9:42:24 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.dao;

import com.abbhsoft.srm.base.GenericDao;
import com.abbhsoft.srm.model.Student;
import java.util.List;

/**
 *
 * @author Sadd
 */
public interface StudentDao extends GenericDao<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastName(String lastName);

    public List<Student> findByMi(String mI);

    public List<Student> findByEmail(String email);

    public List<Student> findBySecondaryEmail(String secondaryEmail);

    public List<Student> findByfindByMobilePhone(String mobilePhone);

    public List<Student> findByHomePhone(String homePhone);

    public List<Student> findByFax(String fax);

    public List<Student> findByOtherPhone(String otherPhone);

    public List<Student> findByAddress(String address);

    public List<Student> findByEducation(String education);

    public List<Student> findByVisaStatus(String visaStatus);

    public List<Student> findByGender(String gender);

    public List<Student> findByAge(String age);

    public List<Student> findByNationality(String nationality);

    public List<Student> findByRefferedBy(String refferedBy);

    public List<Student> findByExpectedStartDate(String expectedStartDate);

    // needs 10 params with same value 
    // otherwise throws exception
    public List<Student> findBySingleString(String args1,String args2,String args3,String args4,
            String args5,String args6,String args7);//,String args9,String args10);
    // needs 4 params with couple of them having the same value 
    // otherwise throws exception
    public List<Student> findByFirstNameLastNameOrCityState(String args1,String args2,String args3,String args4);
    // needs 5 params with  same value (phone nos or age)
    // otherwise throws exception
    public List<Student> findByPhoneNumber(String args1,String args2,String args3,String args4, String args5);
}
