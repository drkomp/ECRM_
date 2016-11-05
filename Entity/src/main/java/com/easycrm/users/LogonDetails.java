package com.easycrm.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by drkomp on 24.10.2016.
 */
@Entity
@Table(name = "users_online")
public class LogonDetails {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;
    @Column(name = "key_")
    private String key;
    private Date logonDate;
    private Date lastActivity;

    public LogonDetails() {
    }

    public LogonDetails(User user, String key, Date logonDate, Date lastActivity) {
        this.user = user;
        this.key = key;
        this.logonDate = logonDate;
        this.lastActivity = lastActivity;
    }

    public long getId() {
        return id;
    }

    public LogonDetails setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LogonDetails setUser(User user) {
        this.user = user;
        return this;

    }

    public String getKey() {
        return key;
    }

    public LogonDetails setKey(String key) {
        this.key = key;
        return this;

    }

    public Date getLogonDate() {
        return logonDate;
    }

    public LogonDetails setLogonDate(Date logonDate) {
        this.logonDate = logonDate;
        return this;

    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public LogonDetails setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
        return this;

    }
}
