package com.easycrm.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by drkomp on 24.10.2016.
 */
@Entity
@Table(name = "eployee")
public class Eployee {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String name;
    private  String surname;
    private String patronymic;
    private String position;
    @OneToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_id")
    protected Set<User> users = new LinkedHashSet<User>() ;
}
