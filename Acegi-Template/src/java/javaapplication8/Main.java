/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication8;

import com.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author intesar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                    "classpath:applicationContext.xml"
                });
         Hello h = (Hello) context.getBean("hello");
         h.sayHello() ;
        while ( true ) {
            //System.out.println ( " Hello ");
        }
    }

}
