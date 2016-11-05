package com.easycrm.dao;


import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.abstractdao.PhoneDAO;
import com.easycrm.contragents.Phone;

/**
 * Created by drkomp on 05.11.2016.
 */
public class PhoneDAOHibernate
        extends GenericHibernateDao<Phone>
        implements PhoneDAO {


}
