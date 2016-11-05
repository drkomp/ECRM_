package com.easycrm.users;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by drkomp on 08.09.2016.
 */
@Entity
@Table(name = "managers")
public class Manager extends User {
    {userType = "Manager";}
}
