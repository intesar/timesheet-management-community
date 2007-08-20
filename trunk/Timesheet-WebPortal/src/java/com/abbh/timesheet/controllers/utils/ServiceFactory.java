/*
 * ServiceFactory.java
 *
 * Created on Aug 19, 2007, 7:30:35 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.controllers.utils;

import com.abbh.timesheet.service.CompanyService;
import com.abbhsoft.framework.valueListHandler.ValueListHandler;

/**
 *
 * @author shannan
 */
public class ServiceFactory {

    public static void main(String[] args) {
        System.out.println("search");
        
        CompanyService instance = (CompanyService) com.abbh.timesheet.service.ServiceFactory.instance.getBean("companyServiceImpl");

        String key = "chicago";


        ValueListHandler result = instance.search(key);
        result.createList(1);
        System.out.println(result.getCurrentResultList().size());
        System.out.println(result.getCurrentResultList());
    }
}
