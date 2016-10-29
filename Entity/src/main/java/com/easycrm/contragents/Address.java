package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by drkomp on 01.10.2016.
 */
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "type_", nullable = false)
    @NotNull
    private String type;
    @Column(name = "index_")
    private String index;
    private String city;
    private String address;
    private String neighborhood;
    private String route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;


    public Address() { }

    public Address(String type, String index, String city, String address, String neighborhood, String route, Contragent contragent) {
        this.type = type;
        this.index = index;
        this.city = city;
        this.address = address;
        this.neighborhood = neighborhood;
        this.route = route;
        this.contragent = contragent;
        contragent.getAdresses().add(this);
    }

    public String getType() {
        return type;
    }

    public Address setType(String type) {this.type = type; return this;}

    public String getIndex() {
        return index;
    }

    public Address setIndex(String index) {this.index = index; return this;}

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {this.city = city; return this; }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) { this.address = address; return this;   }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Address setNeighborhood(String neighborhood) { this.neighborhood = neighborhood;  return this; }

    public String getRoute() {
        return route;
    }

    public Address setRoute(String route) { this.route = route; return this; }

    public long getId() {
        return id;
    }

    public Address setId(long id) {this.id = id; return this;}

    public Contragent getContragent() {
        return contragent;
    }

    public Address setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getAdresses().add(this);
        return this;}
}
