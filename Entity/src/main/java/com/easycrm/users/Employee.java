package com.easycrm.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by drkomp on 24.10.2016.
 */
@Entity
@Table(name = "employee")
public class Employee {
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

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Employee setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Employee setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Employee setUsers(Set<User> users) {
        this.users = users;
        return this;
    }
}
