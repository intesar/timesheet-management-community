/*
 * CompanyDAOTest.java
 * JUnit based test
 *
 * Created on August 18, 2007, 9:29 PM
 */

package com.abbh.timesheet.dao;

import com.abbhsoft.framework.valueListHandler.ValueListHandler;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author shannan
 */
public class CompanyDAOTest extends AbstractTransactionalDataSourceSpringContextTests  {
    
    public CompanyDAOTest (String testName) {
        super (testName);
    }

    private CompanyDAO companyDAO;

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
    
     @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        
        jdbcTemplate.execute("insert into users ( id, email ) values ( 1, 'test')");
        jdbcTemplate.execute("insert into company (id, name, type, city, owner ) values ( 1, 'name1', 'type1', 'chicago', 'test')");
        jdbcTemplate.execute("insert into company (id, name, type, city, owner ) values ( 2, 'name1', 'type1', 'chicago', 'test')");
        jdbcTemplate.execute("insert into company (id, name, type, city, owner ) values ( 3, 'name1', 'type1', 'chicago', 'test')");
        jdbcTemplate.execute("insert into company (id, name, type, city, owner ) values ( 4, 'name1', 'type1', 'chicago', 'test')");
        
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"company", "users" });
    }

    public void testSearch() {
        System.out.println("search");
        String key = "chicago";        
        ValueListHandler result = companyDAO.search(key);
        result.createList(1);
        assertNotNull(result.getCurrentResultList());
        System.out.println ( result.getCurrentResultList().size() );
        assertTrue(result.getCurrentResultList().size() == 4 );
        
    } /* Test of search method, of class CompanyDAO. */
    
}
