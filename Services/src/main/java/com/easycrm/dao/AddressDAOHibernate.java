package com.easycrm.dao;

import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.abstractdao.PhoneDAO;
import com.easycrm.contragents.Address;

/**
 * Created by drkomp on 05.11.2016.
 */
public class AddressDAOHibernate
        extends GenericHibernateDao<Address>
        implements PhoneDAO {

}
