/*
 * UserDAOImpl.java
 *
 * Created on Jul 1, 2007, 4:19:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.dao.impl;

import com.abbh.authenticator.dao.UserDAO;
import com.abbh.authenticator.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mohammed Hamed
 */
public class UserDAOImpl implements UserDAO{
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SecureAuthPU");
    
    
    
    public UserDAOImpl() {
    }
    
    public void save(Users user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
            throw new RuntimeException();
        } finally {
            em.close();
        }
        
    }
    
    
    
}
