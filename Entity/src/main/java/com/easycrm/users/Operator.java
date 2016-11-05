package com.easycrm.users;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by drkomp on 18.09.2016.
 */
@Entity
@Table(name = "operators")
public class Operator extends User {
    {userType="Operator";}
}
