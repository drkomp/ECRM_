package com.easycrm.dao;

import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.abstractdao.MasterDAO;
import com.easycrm.users.Master;

/**
 * Created by drkomp on 05.11.2016.
 */
public class MasterDAOHibernate
    extends GenericHibernateDao<Master>
    implements MasterDAO {
}
