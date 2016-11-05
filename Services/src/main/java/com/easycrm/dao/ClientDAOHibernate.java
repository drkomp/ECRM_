package com.easycrm.dao;

import com.easycrm.abstractdao.ClientDAO;
import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.contragents.Client;

/**
 * Created by drkomp on 05.11.2016.
 */
public class ClientDAOHibernate
        extends GenericHibernateDao<Client>
        implements ClientDAO {
}
