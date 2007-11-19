/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.web.formBeans.StudentFormBean;

/**
 *
 * @author mdshannan
 */
public class StudentConverter {

    public static Student toModel(StudentFormBean bean) {
        Student model = new Student();
        model.setAge(bean.getAge());
        model.setEducation(bean.getEducation());
        model.setEmail(bean.getEmail());
        //model.setExpectedStartDate(bean.get);
        model.setFax(bean.getFax());
        model.setFirstName(bean.getFirstName());
        model.setGender(bean.getGender());
        model.setHomePhone(bean.getHomePhone());
        model.setLastName(bean.getLastName());
        model.setMi(bean.getMi());
        model.setMobilePhone(bean.getMobilePhone());
        model.setNationality(bean.getNationality());
        model.setOtherPhone(bean.getOtherPhone());
        model.setRefferedBy(bean.getReferredBy());
        model.setSecondaryEmail(bean.getSecondaryEmail());
        model.setVisaStatus(bean.getVisaStatus());
        if (bean.getUniversity() != null && bean.getUniversity() > 0) {
            University u = new University();
            u.setId(bean.getUniversity());
            model.setUniversity(u);
        }
        return model;
    }

    public static StudentFormBean toFormBean(Student Model) {
        return null;
    }
}
