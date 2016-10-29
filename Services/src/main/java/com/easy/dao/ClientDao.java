package com.easy.dao;

import com.easy.HibernateUtil;
import com.easycrm.contragents.Client;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by drkomp on 19.10.2016.
 */
public class ClientDao extends GenericDao<Client> {
    public Client getDetailClientById(Class<Client> clazz, long id) throws SQLException {
        Client result = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.enableFetchProfile("client-whith-detail");
            session.beginTransaction();
            result = clazz.cast(session.get(clazz, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
