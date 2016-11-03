package com.easycrm.hibernate;

import com.easycrm.contragents.*;
import com.easycrm.users.*;
import com.easycrm.dao.*;


public class Factory {
    private static GenericDao<Phone> phoneDao = null;
    private static GenericDao<Address> addressDao = null;
    private static GenericDao<Client> clientDao = null;
    private static GenericDao<Organization> orgDao = null;
    private static GenericDao<User> userDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public  GenericDao<User> getuserDao(){
        if (userDao == null){
            userDao = new GenericDao<User>();
        }
        return userDao;
    }

    public  GenericDao<Phone> getPhoneDao(){
        if (phoneDao == null){
            phoneDao = new GenericDao<Phone>();
        }
        return phoneDao;
    }

    public  GenericDao<Address> getaddressDao(){
        if (addressDao == null){
            addressDao = new GenericDao<Address>();
        }
        return addressDao;
    }

    public  GenericDao<Client> getclientDao(){
        if (clientDao == null){
            clientDao = new GenericDao<Client>();
        }
        return clientDao;
    }

    public  GenericDao<Organization> getOrganizationDao(){
        if (orgDao == null){
            orgDao = new GenericDao<Organization>();
        }
        return orgDao;
    }

}
