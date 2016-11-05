package com.easycrm.dao;

import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.abstractdao.UserDAO;
import com.easycrm.users.User;

/**
 * Created by drkomp on 05.11.2016.
 */
public class UserDAOHibernate
    extends GenericHibernateDao<User>
    implements UserDAO {
}
