/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.Address;
import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.web.formBeans.CampusBean;

/**
 *
 * @author mdshannan
 */
public class CampusConverter {

    public static Campus toModel(CampusBean bean) {
        Campus campus = new Campus();
        campus.setName(bean.getCampus());
        if ( bean.getStreet() != null && bean.getStreet().length() > 0 ) {
            Address a = new Address();
            a.setStreet(bean.getStreet());
            a.setCity(bean.getCity());
            a.setState(bean.getState());
            a.setZipcode(bean.getZip());
            a.setCountry(bean.getCountry());
            campus.setAddress(a);
        }
        if ( bean.getUniversity() != null && bean.getUniversity() > 0 ) {
            University u = new University(bean.getUniversity());
            campus.setUniversity(u);
        }
        return campus;
    }

    public static CampusBean toFormBean(Campus Model) {
        return null;
    }
}
