package com.easycrm.hibernate;

import com.easycrm.abstractdao.GenericHibernateDao;
import com.easycrm.contragents.*;
import com.easycrm.dao.*;
import com.easycrm.users.*;


public class Factory {
    private static GenericHibernateDao<Phone> phoneDao = null;
    private static GenericHibernateDao<Address> addressDao = null;
    private static GenericHibernateDao<Client> clientDao = null;
    private static GenericHibernateDao<Organization> orgDao = null;
    private static GenericHibernateDao<User> userDao = null;
    private static GenericHibernateDao<Master> masterDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public GenericHibernateDao<Master> getMasterDao(){
        if (masterDao == null){
            masterDao = new MasterDAOHibernate();
        }
        return masterDao;
    }
    public GenericHibernateDao<User> getUserDao(){
        if (userDao == null){
            userDao = new UserDAOHibernate();
        }
        return userDao;
    }

    public GenericHibernateDao<Phone> getPhoneDao(){
        if (phoneDao == null){
            phoneDao = new PhoneDAOHibernate();
        }
        return phoneDao;
    }

    public GenericHibernateDao<Address> getAddressDao(){
        if (addressDao == null){
            addressDao = new AddressDAOHibernate();
        }
        return addressDao;
    }

    public GenericHibernateDao<Client> getClientDao(){
        if (clientDao == null){
            clientDao = new ClientDAOHibernate();
        }
        return clientDao;
    }

    public GenericHibernateDao<Organization> getOrganizationDao(){
        if (orgDao == null){
            orgDao = new OrganizationDAOHibernate();
        }
        return orgDao;
    }

}
