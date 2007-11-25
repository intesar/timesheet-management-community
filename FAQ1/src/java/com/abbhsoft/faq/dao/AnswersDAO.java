package com.abbhsoft.faq.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.abbhsoft.faq.model.Answers;

/**
 * A data access object (DAO) providing persistence and search support for
 * Answers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.abbhsoft.faq.model.Answers
 * @author MyEclipse Persistence Tools
 */

public class AnswersDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AnswersDAO.class);
	// property constants
	public static final String ANSWER = "answer";
	public static final String AUTHOR = "author";
	public static final String IS_APPROPRIATE = "isAppropriate";
	public static final String IS_APPROPRIATE_BY = "isAppropriateBy";

	public void save(Answers transientInstance) {
		log.debug("saving Answers instance");
		try {
			getSession().beginTransaction();
			getSession().save(transientInstance);
                        getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Answers persistentInstance) {
		log.debug("deleting Answers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Answers findById(java.lang.Integer id) {
		log.debug("getting Answers instance with id: " + id);
		try {
			Answers instance = (Answers) getSession().get(
					"com.abbhsoft.faq.model.Answers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Answers instance) {
		log.debug("finding Answers instance by example");
		try {
			List results = getSession().createCriteria(
					"com.abbhsoft.faq.model.Answers").add(
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
		log.debug("finding Answers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Answers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByIsAppropriate(Object isAppropriate) {
		return findByProperty(IS_APPROPRIATE, isAppropriate);
	}

	public List findByIsAppropriateBy(Object isAppropriateBy) {
		return findByProperty(IS_APPROPRIATE_BY, isAppropriateBy);
	}

	public List findAll() {
		log.debug("finding all Answers instances");
		try {
			String queryString = "from Answers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Answers merge(Answers detachedInstance) {
		log.debug("merging Answers instance");
		try {
			Answers result = (Answers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Answers instance) {
		log.debug("attaching dirty Answers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Answers instance) {
		log.debug("attaching clean Answers instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}