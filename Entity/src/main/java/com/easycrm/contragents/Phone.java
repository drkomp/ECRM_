package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 01.10.2016.
 */
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;

    public Phone() {}

    public Phone(String type, String phone, Contragent contragent) {
        this.type = type;
        this.phone = phone;
        this.contragent = contragent;
        contragent.getPhones().add(this);
    }

    public long getId() {
        return id;
    }

    public Phone setId(long id) {this.id = id; return this;}

    public String getType() {
        return type;
    }

    public Phone setType(String type) {this.type = type; return this;}

    public String getPhone() {
        return phone;
    }

    public Phone setPhone(String phone) {this.phone = phone; return this;}

    public Contragent getContragent() {
        return contragent;
    }

    public Phone setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getPhones().add(this);
        return this;}
}
