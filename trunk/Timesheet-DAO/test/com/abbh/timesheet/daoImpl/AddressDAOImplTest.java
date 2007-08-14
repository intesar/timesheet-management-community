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
 */
public class AddressDAOImplTest extends AbstractTransactionalDataSourceSpringContextTests {

    public AddressDAOImplTest() {
       // instance = (AddressDAO) SpringSupport.getBean("addressDAOImpl");
    }

//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
    private AddressDAO addressDAO = null;

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    protected String[] getConfigLocations() {
        return new String[]{"classpath:context/applicationContext-DAO.xml"};
    }

    protected void onSetUp() throws Exception {
//        jdbcTemplate.execute("insert into address (id, city, street, type) values (1003, 'CHICAGO', 'MAIN STREET', 'HOME')");
//        jdbcTemplate.execute("insert into address (id, city, street, type) values (1001, 'CHICAGO', 'DEVON STREET', 'OFFICE')");
//        jdbcTemplate.execute("insert into address (id, city, street, type) values (1002, 'CHICAGO', 'TALMAN AVE', 'OTHER')");       
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
        String zipcode = "ZIPCODE";


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
        String state = "STATE";


        Collection result = addressDAO.findByState(state);
        assertTrue(result.size() > 0);
    } /* Test of findByState method, of class AddressDAOImpl. */

    @Test
    public void findByType() {
        System.out.println("findByType");
        String type = "HOME";


        Collection result = addressDAO.findByType(type);
        assertTrue(result.size() > 0);
    } /* Test of findByType method, of class AddressDAOImpl. */

    @Test
    public void testFindByCountry() {
        System.out.println("findByCountry");
        String country = "COUNTRY";


        Collection result = addressDAO.findByCountry(country);
        assertTrue(result.size() > 0);
    } /* Test of findByCountry method, of class AddressDAOImpl. */
}
