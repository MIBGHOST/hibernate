package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.utils.HibernateUtils;
import org.hibernate.SessionFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

//    public static void main(String[] args){
//        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//        SessionFactory sessionFactory1 = HibernateUtils.getSessionFactory();
//        SessionFactory sessionFactory2 = HibernateUtils.getSessionFactory();
//        System.out.println(sessionFactory + ", " + sessionFactory1 + ", " + sessionFactory2);
//    }
}
