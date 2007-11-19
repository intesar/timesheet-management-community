/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.web.converters;

import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.web.formBeans.UniversityBean;

/**
 *
 * @author mdshannan
 */
public class UniversityConverter {
    public static University toUniversityModel(UniversityBean bean) {
        University u = new University();
        u.setName(bean.getName());
        return u;
    }
    
    public static UniversityBean toUniversityModel(University model) {
        return null;
    }

}
