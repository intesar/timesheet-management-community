/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service;

import com.abbhsoft.srm.model.University;

/**
 *
 * @author mdshannan
 */
public interface UniversityService {

    public void update(University university);
    void save(University u);
    University getUniversityByIdWithDetails( Long id );
}