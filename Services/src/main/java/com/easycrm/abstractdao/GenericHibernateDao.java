package com.easycrm.abstractdao;

import com.easycrm.hibernate.HibernateUtil;
import org.hibernate.Criteria;
//import org.hibernate.Session;
import org.hibernate.criterion.Example;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by drkomp on 03.10.2016.
 */
public abstract class GenericHibernateDao<Entity> implements GenericDao<Entity> {

    private Class<Entity> persistentClass;

    public GenericHibernateDao() {
        this.persistentClass = (Class<Entity>) ((java.lang.reflect.ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<Entity> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public Entity getItById( long id) throws SQLException {
        Entity result = null;
        EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
        result = session.find(getPersistentClass(), id);
        return result;
    }

    @Override
    public List<Entity> findItByExample(Entity exampleInstance, String[] excludeProperty) {
        EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @Override
    public List<Entity> findItByField(String fieldName, String fieldValue) {
        EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session.createQuery("select item from "+getPersistentClass().getName()+
                " item where item."+fieldName+"= :filed_type",getPersistentClass())
                .setParameter("filed_type",fieldValue).getResultList();
    }

    @Override
    public Entity mergeIt(Entity entity) throws SQLException {
        EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
            return session.merge(entity);
    }

    @Override
    public void persistIt(Entity entity) throws SQLException {
            EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.persist(entity);
    }

    @Override
    public void removeIt(Entity entity) throws SQLException {
            EntityManager session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.remove(entity);
    }


}

