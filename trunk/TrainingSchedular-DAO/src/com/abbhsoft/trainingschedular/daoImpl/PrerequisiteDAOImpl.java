/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.trainingschedular.daoImpl;

import com.abbhsoft.trainingschedular.dao.PrerequisiteDAO;
import com.abbhsoft.trainingschedular.model.PreRequisite;
import java.math.BigDecimal;

/**
 *
 * @author mdshannan
 */
public class PrerequisiteDAOImpl extends GenericAbstractDAO <PreRequisite,BigDecimal> implements PrerequisiteDAO{

    public PrerequisiteDAOImpl()
    {
            super(PreRequisite.class);
    }
}
