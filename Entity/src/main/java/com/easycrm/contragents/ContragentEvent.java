package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 25.08.2016.
 */
@Entity
@Table(name = "events")
public class ContragentEvent {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "evet_name")
    private String eventName;
    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;

    public ContragentEvent() {}

    public ContragentEvent(String eventName, String date, Contragent contragent) {
        this.eventName = eventName;
        this.date = date;
        this.contragent = contragent;
        contragent.getContragentEvents().add(this);
    }

    public int getId() {
        return id;
    }

    public ContragentEvent setId(int id) {this.id = id; return this;}

    public String getEventName() {
        return eventName;
    }

    public ContragentEvent setEventName(String eventName) {this.eventName = eventName; return this;}

    public String getDate() {
        return date;
    }

    public ContragentEvent setDate(String date) {this.date = date; return this;}

    public Contragent getContragent() {
        return contragent;
    }

    public ContragentEvent setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getContragentEvents().add(this);
        return this;}
}
