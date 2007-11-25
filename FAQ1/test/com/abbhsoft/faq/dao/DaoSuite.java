/*
 * DaoSuite.java
 * JUnit 4.x based test
 *
 * Created on November 24, 2007, 5:50 PM
 */

package com.abbhsoft.faq.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Mohammed
 */
@RunWith(Suite.class)
//@Suite.SuiteClasses({DeveloperDAOTest.class, IBaseHibernateDAOTest.class, AnswersDAOTest.class, BaseHibernateDAOTest.class, CategoryDAOTest.class, TopicDAOTest.class, QuestionsDAOTest.class})
public class DaoSuite {
    
    public DaoSuite() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
