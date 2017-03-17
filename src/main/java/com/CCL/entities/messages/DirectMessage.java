package com.CCL.entities.messages;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Mike on 3/16/2017.
 */
@Entity
@Table(name = "directmessages")
public class DirectMessage {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receipient;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Date timeStamp;

    public DirectMessage() {
    }

    public DirectMessage(String sender, String receipient, String text, Date timeStamp) {
        this.sender = sender;
        this.receipient = receipient;
        this.text = text;
        this.timeStamp = timeStamp;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
