package com.easy.dao;

import com.easy.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by drkomp on 03.10.2016.
 */
public class GenericDao<Entity> implements AbstractGDao<Entity> {
//if you need no fetch profile use fetchProfile=""
    @Override
    public Entity getItById(Class<Entity> clazz, long id) throws SQLException {
        Entity result = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        result = clazz.cast(session.get(clazz, id));
        return result;
    }

    @Override
    public void addIt(Entity entity) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.save(entity);
    }

    @Override
    public void updateIt(Entity entity) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.update(entity);
    }

    @Override
    public void persistIt(Entity entity) throws SQLException {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.persist(entity);
    }

    @Override
    public void deleteIt(Entity entity) throws SQLException {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.delete(entity);
    }
}

