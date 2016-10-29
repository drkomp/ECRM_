package com.easycrm.contragents;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by drkomp on 31.08.2016.
 */
@Entity
@Table(name = "organizations")
public class Organization extends Contragent {
    private String erdpu;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "client_organization",
                joinColumns = @JoinColumn(name = "organization_id"),
                inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients = new LinkedHashSet<>(); //oganization can have link to many clients, and one client can have link to many organizations

    public Organization() {
        super();
    }

    @Override
    public Organization setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public Organization setPhoneticName(String phoneticName) {
        super.setPhoneticName(phoneticName);
        return this;
    }

    @Override
    public Organization setNotes(String notes) {
        super.setNotes(notes);
        return this;
    }

    @Override
    public Organization setAddressed(Contragent addressed) {
        super.setAddressed(addressed);
        return this;
    }

    @Override
    public Organization setPhones(Set<Phone> phones) {
        super.setPhones(phones);
        return this;
    }

    @Override
    public Organization setAdresses(Set<Address> adresses) {
        super.setAdresses(adresses);
        return this;
    }

    @Override
    public Organization setEmails(Set<Email> emails) {
        super.setEmails(emails);
        return this;
    }

    @Override
    public Organization setChats(Set<Chat> chats) {
        super.setChats(chats);
        return this;
    }

    @Override
    public Organization setWebSites(Set<WebSite> webSites) {
        super.setWebSites(webSites);
        return this;
    }

    @Override
    public Organization setContragentEvents(Set<ContragentEvent> contragentEvents) {
        super.setContragentEvents(contragentEvents);
        return this;
    }

    public String getErdpu() {
        return erdpu;
    }

    public Organization setErdpu(String erdpu) {this.erdpu = erdpu; return this;}

    public Set<Client> getClients() {
        return clients;
    }

    public Organization setClients(Set<Client> clients) {this.clients = clients; return this;}
}
