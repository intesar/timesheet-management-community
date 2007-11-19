/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.EmailGroup;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.web.formBeans.EventFormBean;

/**
 *
 * @author mdshannan
 */
public class EventConverter {

    public static Event toEventModel(EventFormBean bean) {
        Event e = new Event();
        e.setDate(bean.getDate());
        e.setDescript(bean.getDescript());


        if (bean.getGroup() != null && bean.getGroup() > 0) {
            EmailGroup group1 = new EmailGroup();
            group1.setId(bean.getGroup());
            e.setGroup1(group1);
        }

        e.setPriority(bean.getPriority());


        if (bean.getStudent()  != null && bean.getStudent() > 0) {
            Student student = new Student();
            student.setId(bean.getStudent());
            e.setStudent(student);
        }

        e.setType(bean.getType());


        if (bean.getUniversity()  != null && bean.getUniversity() > 0) {
            University u = new University();
            u.setId(bean.getUniversity());
            e.setUniversity(u);
        }

        return e;
    }

    public static EventFormBean toEventFormBean(Event Model) {
        return null;
    }
}
