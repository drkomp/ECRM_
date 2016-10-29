package com.easycrm.contragents;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drkomp on 01.10.2016.
 */
@Entity
@Table(name= "chats")
public class Chat {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "type_")
    private String type;
    @Column(name = "chat" )
    private String chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "contragent_id", nullable = false)
    private Contragent contragent;


    public Chat() {
    }

    public Chat(String type, String chat, Contragent contragent) {
        this.type = type;
        this.chat = chat;
        this.contragent = contragent;
        contragent.getChats().add(this);
    }

    public long getId() {
        return id;
    }

    public Chat setId(long id) {this.id = id; return this;}

    public String getType() {
        return type;
    }

    public Chat setType(String type) {this.type = type; return this;}

    public String getChat() {
        return chat;
    }

    public Chat setChat(String chat) {this.chat = chat; return this;}

    public Contragent getContragent() {return contragent;}

    public Chat setContragent(Contragent contragent) {
        this.contragent = contragent;
        contragent.getChats().add(this);
        return this;}
}
