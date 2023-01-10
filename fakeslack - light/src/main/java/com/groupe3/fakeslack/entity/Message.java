package com.groupe3.fakeslack.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")

public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private LocalDateTime dateOfCreation = LocalDateTime.now();

    private LocalDateTime dateOfModification;

    public Message() {
    }

    public Message(int id, String text, Channel channel, User user, LocalDateTime dateOfCreation, LocalDateTime dateOfModification) {
        this.id = id;
        this.text = text;
        this.channel = channel;
        this.user = user;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Message(String text, Channel channel, User user, LocalDateTime dateOfCreation, LocalDateTime dateOfModification) {
        this.text = text;
        this.channel = channel;
        this.user = user;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Message(Message message) {
        this.id = message.id;
        this.text = message.text;
        this.channel = message.channel;
        this.user = message.user;
        this.dateOfCreation = message.dateOfCreation;
        this.dateOfModification = message.dateOfModification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", text='" + text + '\'' + ", channel=" + channel + ", user=" + user + ", dateOfCreation=" + dateOfCreation + ", dateOfModification=" + dateOfModification + '}';
    }
}
