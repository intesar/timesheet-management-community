/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.Query;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.web.formBeans.QueryFormBean;

/**
 *
 * @author mdshannan
 */
public class QueryConverter {

    public static Query toModel(QueryFormBean bean) {
        Query q = new Query();
        q.setMsg(bean.getMessage());
        if (bean.getStudent() != null && bean.getStudent() > 0) {
            Student s = new Student();
            s.setId(bean.getStudent());
            q.setStudent(s);
        }
        return q;
    }

    public static QueryFormBean toFormBean(Query Model) {
        return null;
    }
}
