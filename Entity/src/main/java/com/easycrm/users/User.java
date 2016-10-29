package com.easycrm.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 25.08.2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public abstract class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    protected int id;
    protected String nicName;
    protected String password;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    protected LogonDetails logonDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "employee_id", nullable = false)
    protected Eployee eployee;

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LogonDetails getLogonDetails() {
        return logonDetails;
    }

    public void setLogonDetails(LogonDetails logonDetails) {
        this.logonDetails = logonDetails;
    }

    public Eployee getEployee() {
        return eployee;
    }

    public void setEployee(Eployee eployee) {
        this.eployee = eployee;
    }
}
