package com.easycrm.contragents;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by drkomp on 01.10.2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contragent")
public abstract class Contragent {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    protected long id;
    @Column(name = "name")
    protected String name;
    @Column (name = "phoneticName")
    protected String phoneticName;
    @Column (name = "notes")
    protected String notes;


    @OneToOne (fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    protected Contragent addressed ; //Who addressed this client to me

    @OneToMany (fetch = FetchType.LAZY,  cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<Phone> phones = new LinkedHashSet<Phone>() ; //like 'mobile' - '0987654321'

    @OneToMany (fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<Address> adresses = new LinkedHashSet<>();        //like 'home' - 'Uborevicha st. 15 office 2'

    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<Email> emails = new LinkedHashSet<>(); //like 'private' 'fedor.kusch@gmail.com'

    @OneToMany (fetch = FetchType.LAZY,  cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<Chat> chats = new LinkedHashSet<>(); //like 'skype' - 'fedor.kusch'

    @OneToMany (fetch = FetchType.LAZY,  cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<WebSite> webSites= new LinkedHashSet<>();

    @OneToMany (fetch = FetchType.LAZY,   cascade = {CascadeType.ALL})
    @JoinColumn(name = "contragent_id")
    protected Set<ContragentEvent> contragentEvents= new LinkedHashSet<>(); //like 'birthday' - '12.01.2001'

    public Contragent() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Contragent setName(String name) {this.name = name; return this;}

    public String getPhoneticName() {
        return phoneticName;
    }

    public Contragent setPhoneticName(String phoneticName) {this.phoneticName = phoneticName; return this;}

    public String getNotes() {
        return notes;
    }

    public Contragent setNotes(String notes) {this.notes = notes; return this; }

    public Contragent getAddressed() {
        return addressed;
    }

    public Contragent setAddressed(Contragent addressed) {this.addressed = addressed; return this;}

    public Set<Phone> getPhones() {
        return phones;
    }

    public Contragent setPhones(Set<Phone> phones) {this.phones = phones; return this;}

    public Set<Address> getAdresses() {
        return adresses;
    }

    public Contragent setAdresses(Set<Address> adresses) {this.adresses = adresses; return this;}

    public Set<Email> getEmails() {
        return emails;
    }

    public Contragent setEmails(Set<Email> emails) {this.emails = emails; return this;}

    public Set<Chat> getChats() {
        return chats;
    }

    public Contragent setChats(Set<Chat> chats) {this.chats = chats; return this;}

    public Set<WebSite> getWebSites() {
        return webSites;
    }

    public Contragent setWebSites(Set<WebSite> webSites) {this.webSites = webSites; return this;}

    public Set<ContragentEvent> getContragentEvents() {
        return contragentEvents;
    }

    public Contragent setContragentEvents(Set<ContragentEvent> contragentEvents) {this.contragentEvents = contragentEvents; return this;}

}
