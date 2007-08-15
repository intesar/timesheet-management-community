/*
 * AddressDAOImplTest.java
 * JUnit 4.x based test
 *
 * Created on August 12, 2007, 6:24 PM
 */

package com.abbh.timesheet.daoImpl;

import com.abbh.timesheet.dao.AddressDAO;
import java.util.Collection;
import org.junit.Test;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import static org.junit.Assert.*;

/**
 *
 * @author shannan
 * 
 *  Creating Spring JUnit Test are simple, follow these steps
 *  1. extends AbstractTransactionalDataSourceSpringContextTests
 *  2. create instance variables and setters for all required daos
 *  3. copy the "getConfigLocations() " method from below
 *  4. write "onSetupInTransaction()" and "onTearDownAfterTransaction"
 *  5. write all required test cases * 
 * 
 */

public class AddressDAOImplTest extends AbstractTransactionalDataSourceSpringContextTests {

    public AddressDAOImplTest() {
    }


    private AddressDAO addressDAO = null;

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        jdbcTemplate.execute("insert into address (id, city, street, type, zipcode, country,state) values (1003, 'CHICAGO', 'MAIN STREET', 'HOME', '00000', 'USA', 'IL')");
        jdbcTemplate.execute("insert into address (id, city, street, type, zipcode, country,state) values (1001, 'CHICAGO', 'DEVON STREET', 'OFFICE', '00000', 'USA', 'IL')");
        jdbcTemplate.execute("insert into address (id, city, street, type, zipcode, country,state) values (1002, 'CHICAGO', 'TALMAN AVE', 'OTHER', '00000', 'USA', 'IL')");
    }

    @Override
    protected void onTearDownAfterTransaction() throws Exception {

        super.onTearDownAfterTransaction();
        deleteFromTables(new String[]{"address"});
    }

    @Test
    public void testFindByStreet() {

        System.out.println("findByStreet");
        String street = "MAIN STREET";

        Collection result = addressDAO.findByStreet(street);
        assertTrue(result.size() > 0);
        System.out.println(result.size());
    } /* Test of findByStreet method, of class AddressDAOImpl. */

    @Test
    public void testFindByZipcode() {
        System.out.println("findByZipcode");
        String zipcode = "00000";


        Collection result = addressDAO.findByZipcode(zipcode);
        assertTrue(result.size() > 0);
    } /* Test of findByZipcode method, of class AddressDAOImpl. */

    @Test
    public void testFindByCity() {
        System.out.println("findByCity");
        String city = "CHICAGO";


        Collection result = addressDAO.findByCity(city);
        assertTrue(result.size() > 0);
    } /* Test of findByCity method, of class AddressDAOImpl. */

    @Test
    public void testFindByState() {
        System.out.println("findByState");
        String state = "IL";


        Collection result = addressDAO.findByState(state);
        assertTrue(result.size() > 0);
    } /* Test of findByState method, of class AddressDAOImpl. */

    @Test
    public void testFindByType() {
        System.out.println("findByType");
        String type = "HOME";


        Collection result = addressDAO.findByType(type);
        assertTrue(result.size() > 0);
    } /* Test of findByType method, of class AddressDAOImpl. */

    @Test
    public void testFindByCountry() {
        System.out.println("findByCountry");
        String country = "USA";


        Collection result = addressDAO.findByCountry(country);
        assertTrue(result.size() > 0);
    } /* Test of findByCountry method, of class AddressDAOImpl. */
}
