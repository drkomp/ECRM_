package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 01.10.2016.
 */
@Entity
@Table(name="web_sites")
public class WebSite {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "type_")
    private String type;
    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;

    public WebSite() {
    }

    public WebSite(String type, String url, Contragent contragent) {
        this.type = type;
        this.url = url;
        this.contragent = contragent;
        contragent.getWebSites().add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public WebSite setType(String type) {this.type = type; return this;}

    public String getUrl() {
        return url;
    }

    public WebSite setUrl(String url) {this.url = url;return this;}

    public Contragent getContragent() {
        return contragent;
    }

    public WebSite setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getWebSites().add(this);
        return this;
    }
}