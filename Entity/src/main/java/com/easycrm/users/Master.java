package com.easycrm.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by drkomp on 08.09.2016.
 */
@Entity
@Table(name = "masters")
public class Master extends User {
    {userType = "Master";}

    @Override
    public Master setBaned(boolean baned) {
        super.setBaned(baned);
        return this;
    }

    @Override
    public Master setNickName(String nicName) {
        super.setNickName(nicName);
        return this;
    }

    @Override
    public Master setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public Master setLogonDetails(LogonDetails logonDetails) {
        super.setLogonDetails(logonDetails);
        return this;
    }

    @Override
    public Master setEmployee(Employee employee) {
        super.setEmployee(employee);
        return this;
    }
}
