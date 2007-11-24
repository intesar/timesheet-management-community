package com.abbhsoft.faq.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.abbhsoft.faq.model.Developer;

/**
 * A data access object (DAO) providing persistence and search support for
 * Developer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.abbhsoft.faq.model.Developer
 * @author MyEclipse Persistence Tools
 */

public class DeveloperDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(DeveloperDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String CONTRIBUTION = "contribution";

	public void save(Developer transientInstance) {
		log.debug("saving Developer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Developer persistentInstance) {
		log.debug("deleting Developer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Developer findById(java.lang.Integer id) {
		log.debug("getting Developer instance with id: " + id);
		try {
			Developer instance = (Developer) getSession().get(
					"com.abbhsoft.faq.model.Developer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Developer instance) {
		log.debug("finding Developer instance by example");
		try {
			List results = getSession().createCriteria(
					"com.abbhsoft.faq.model.Developer").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Developer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Developer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByContribution(Object contribution) {
		return findByProperty(CONTRIBUTION, contribution);
	}

	public List findAll() {
		log.debug("finding all Developer instances");
		try {
			String queryString = "from Developer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Developer merge(Developer detachedInstance) {
		log.debug("merging Developer instance");
		try {
			Developer result = (Developer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Developer instance) {
		log.debug("attaching dirty Developer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Developer instance) {
		log.debug("attaching clean Developer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}