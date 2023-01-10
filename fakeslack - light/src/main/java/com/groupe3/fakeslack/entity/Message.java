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

    private LocalDateTime dateOfCreation = LocalDateTime.now();

    private LocalDateTime dateOfModification;

    public Message() {
    }

    public Message(int id, String text, LocalDateTime dateOfCreation, LocalDateTime dateOfModification) {
        this.id = id;
        this.text = text;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Message(String text, LocalDateTime dateOfCreation, LocalDateTime dateOfModification) {
        this.text = text;
        this.dateOfCreation = dateOfCreation;
        this.dateOfModification = dateOfModification;
    }

    public Message(Message message) {
        this.id = message.id;
        this.text = message.text;
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
        return "Message{" + "id=" + id + ", text='" + text + '\'' + ", dateOfCreation=" + dateOfCreation + ", dateOfModification=" + dateOfModification + '}';
    }
}
