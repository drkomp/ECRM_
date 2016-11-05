package com.easycrm.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 25.08.2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(generator = "increment")
   @GenericGenerator(name = "increment", strategy = "increment")
    protected int id;
   @Column(unique = true, name = "nickname")
    protected String nickName;
   @Column(name = "password")
    protected String password;
   @Column(name = "is_baned")
    protected boolean isBaned;
   @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    protected LogonDetails logonDetails;

   @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
   @JoinColumn(name = "employee_id", nullable = false)
    protected Employee employee;

   @Column(name = "user_type")
    protected String userType;

    {
        userType = "User";
    }

    public User() {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBaned() {
        return isBaned;
    }

    public User setBaned(boolean baned) {
        isBaned = baned;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nicName) {
        this.nickName = nicName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public LogonDetails getLogonDetails() {
        return logonDetails;
    }

    public User setLogonDetails(LogonDetails logonDetails) {
        this.logonDetails = logonDetails;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public User setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }
}
