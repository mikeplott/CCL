package com.CCL.entities.messages;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Mike on 3/16/2017.
 */
@Entity
@Table(name = "chatmessages")
public class ChatMessage {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receipient;

    @Column(nullable = false)
    private String text;

    public ChatMessage() {
    }

    public ChatMessage(String sender, String receipient, String text) {
        this.sender = sender;
        this.receipient = receipient;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceipient() {
        return receipient;
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
