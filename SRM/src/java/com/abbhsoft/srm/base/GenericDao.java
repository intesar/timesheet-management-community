package com.abbhsoft.srm.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The GenericDao interface with CRUD methods. Finders are added with interface inheritance and AOP
 * introductions for concrete implementations.
 * 
 * Extended interfaces may declare methods starting with find..., list..., iterate... or scroll...
 * They will execute a preconfigured query that is looked up based on the rest of the method name.
 * 
 * @param T 
 * @param PK 
 * @author pmellqvist
 * @see http://www-128.ibm.com/developerworks/java/library/j-genericdao.html
 * 
 */
public interface GenericDao<T, PK extends Serializable> {

   PK create(T newInstance);

   T read(PK id);

   void update(T transientObject);

   void delete(T persistentObject);

   List<T> findByCreateUser ( Long userId );

   List<T> findByCreateDate ( Date createDate);

   List<T> findByLastModiiedUser ( Long userId );

   List<T> findByLastModifiedDate ( Date lastModifiedDate ); 
   
   List<T> findByLastModifiedDates (Date startDate, Date endDate);

   List<T> findAll ();

}