package com.groupe3.fakeslack.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "channels")

public class Channel {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_channel", joinColumns = @JoinColumn(name = "channel_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private List<Message> messages;


    public Channel() {
    }

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Channel(String name) {
        this.name = name;
    }

    public Channel(Channel channel) {
        this.id = channel.id;
        this.name = channel.name;
        this.users = channel.users;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Channel{" + "id=" + id + ", name='" + name + '\'' + ", users=" + users + '}';
    }

}
