/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.srm.service.impl;

import com.abbhsoft.srm.dao.UniversityDao;
import com.abbhsoft.srm.model.Campus;
import com.abbhsoft.srm.model.Event;
import com.abbhsoft.srm.model.Student;
import com.abbhsoft.srm.model.University;
import com.abbhsoft.srm.service.UniversityService;

/**
 *
 * @author mdshannan
 */
public class UniversityServiceImpl implements UniversityService {

    public void save(University u) {
        this.universityDao.create(u);
    }
    
     public void update(University university) {
        this.universityDao.update(university);
    }
     
    public University getUniversityByIdWithDetails(Long id) {
        University university = this.universityDao.read(id);
        System.out.println ( "Campus Size : " + university.getCampusCollection().size());
        System.out.println ( "Event Size : " + university.getEventCollection().size());
        System.out.println ( "Group Size : " + university.getGroup1Collection().size());
        System.out.println ( "Student Size : " + university.getStudentCollection().size());
        return university;
    }
     
    public void addEvent ( Long UniversityId, Event event ) {
        
    }
    
    public void addCampus ( Long universityId, Campus campus ) {
        
    }
    
    public void addStudent ( Long universityId, Student student ) {
        
    }
    private UniversityDao universityDao;
    
    public void setUniversityDao ( UniversityDao universityDao ) {
        this.universityDao = universityDao;
                
    }

   

    

}
