package com.easycrm.users;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by drkomp on 24.10.2016.
 */
@Entity
@Table(name = "admins")
public class Admin extends User {
    {
        userType = "Admin";
    }
}
