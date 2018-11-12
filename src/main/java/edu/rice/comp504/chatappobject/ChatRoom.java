package edu.rice.comp504.chatappobject;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ChatRoom extends Observable implements Observer{
    private String name;
    private User owner;
    private LinkedList<User> users;
    private Restrictions restrictions;

    public ChatRoom(String name,User owner, Restrictions restrictions) {
        this.name=name;
        this.owner=owner;
        this.restrictions=restrictions;
        this.users=new LinkedList<>();
        this.users.add(owner);

    }


    public LinkedList<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public void update(Observable o, Object arg) {
        //IChatAppCmd cmd = (IChatAppCmd) o;
        //cmd.execute(this);
    }

}
