package com.easycrm.contragents;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by drkomp on 25.08.2016.
 */
@Entity
@Table(name = "clients")
public class Client extends Contragent {

    private String namePrefix;
    private String surname;
    private String patronymic;
    private String nameSuffix;
    private String nickName;
    private String phoneticSurname;

    //oganization can have link to many clients, and one client can have link to many organizations
    @ManyToMany(mappedBy = "clients", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Organization> organizations = new LinkedHashSet<>(); //like 'Director' - 'Farlep-Invest'

    public Client() {
        super();
    }

    @Override
    public Client setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public Client setPhoneticName(String phoneticName) {
        super.setPhoneticName(phoneticName);
        return this;
    }

    @Override
    public Client setNotes(String notes) {
        super.setNotes(notes);
        return this;
    }

    @Override
    public Client setAddressed(Contragent addressed) {
        super.setAddressed(addressed);
        return this;
    }

    @Override
    public Client setPhones(Set<Phone> phones) {
        super.setPhones(phones);
        return this;
    }

    @Override
    public Client setAdresses(Set<Address> adresses) {
        super.setAdresses(adresses);
        return this;
    }

    @Override
    public Client setEmails(Set<Email> emails) {
        super.setEmails(emails);
        return this;
    }

    @Override
    public Client setChats(Set<Chat> chats) {
        super.setChats(chats);
        return this;
    }

    @Override
    public Client setWebSites(Set<WebSite> webSites) {
        super.setWebSites(webSites);
        return this;
    }

    @Override
    public Client setContragentEvents(Set<ContragentEvent> contragentEvents) {
        super.setContragentEvents(contragentEvents);
        return this;
    }

    public Client setId(int id) {this.id = id; return this;}

    public String getNamePrefix() {
        return namePrefix;
    }

    public Client setNamePrefix(String namePrefix) {this.namePrefix = namePrefix; return this;}

    public String getSurname() {
        return surname;
    }

    public Client setSurname(String surname) {this.surname = surname; return this;}

    public String getPatronymic() {
        return patronymic;
    }

    public Client setPatronymic(String patronymic) {this.patronymic = patronymic; return this;}

    public String getNameSuffix() {
        return nameSuffix;
    }

    public Client setNameSuffix(String nameSuffix) {this.nameSuffix = nameSuffix; return this;}

    public String getNickName() {
        return nickName;
    }

    public Client setNickName(String nickName) {this.nickName = nickName; return this;}

    public String getPhoneticSurname() {
        return phoneticSurname;
    }

    public Client setPhoneticSurname(String phoneticSurname) {this.phoneticSurname = phoneticSurname; return this;}

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public Client setOrganizations(Set<Organization> organizations) {this.organizations = organizations; return this;}
}
