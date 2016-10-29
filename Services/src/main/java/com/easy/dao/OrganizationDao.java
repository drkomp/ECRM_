package com.easy.dao;

import com.easy.HibernateUtil;
import com.easycrm.contragents.Organization;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by drkomp on 19.10.2016.
 */
public class OrganizationDao extends GenericDao<Organization> {
    public Organization getDetailOrgById(Class<Organization> clazz, long id) throws SQLException {
        Organization result = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.enableFetchProfile("organization-whith-detail");
            session.beginTransaction();
            result = clazz.cast(session.get(clazz, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
