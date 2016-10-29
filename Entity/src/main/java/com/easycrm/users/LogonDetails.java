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

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getLogonDate() {
        return logonDate;
    }

    public void setLogonDate(Date logonDate) {
        this.logonDate = logonDate;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }
}
