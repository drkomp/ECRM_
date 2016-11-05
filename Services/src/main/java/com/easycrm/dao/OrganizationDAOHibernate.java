package com.easycrm.dao;

import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.abstractdao.OrganizationDAO;
import com.easycrm.contragents.Organization;

/**
 * Created by drkomp on 05.11.2016.
 */
public class OrganizationDAOHibernate
    extends GenericHibernateDao<Organization>
    implements OrganizationDAO {
}
