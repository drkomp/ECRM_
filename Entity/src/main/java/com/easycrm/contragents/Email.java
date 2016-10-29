package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 01.10.2016.
 */
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "type_")
    private String type;
    @Column(name = "email")
    private String eMail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;


    public Email() {
    }

    public Email(String type, String eMail, Contragent contragent) {
        this.type = type;
        this.eMail = eMail;
        this.contragent = contragent;
        contragent.getEmails().add(this);
    }

    public long getId() {
        return id;
    }

    public Email setId(long id) {this.id = id; return this;}

    public String getType() {
        return type;
    }

    public Email setType(String type) {this.type = type; return this;}

    public String geteMail() {
        return eMail;
    }

    public Email seteMail(String eMail) {this.eMail = eMail; return this;}

    public Contragent getContragent() {
        return contragent;
    }

    public Email setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getEmails().add(this);
        return this;
    }
}
