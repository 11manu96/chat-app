package edu.rice.comp504.model.chatappobjects;


import java.util.Observable;
import java.util.Observer;

public class ChatRoom extends Observable implements Observer{
    private String name;
    private User owner;
    private String restrictSchool;
    private String restrictLocation;
    private int restrictAge;

    public ChatRoom(String name,User owner, String restrictLocation, String restrictSchool, int restrictAge) {
        this.name = name;
        this.owner = owner;
        this.restrictAge = restrictAge;
        this.restrictLocation = restrictLocation;
        this.restrictSchool = restrictSchool;


    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getRestrictAge() {
        return restrictAge;
    }

    public void setRestrictAge(int restrictAge) {
        this.restrictAge = restrictAge;
    }

    public String getRestrictLocation() {
        return restrictLocation;
    }

    public void setRestrictLocation(String restrictLocation) {
        this.restrictLocation = restrictLocation;
    }

    public String getRestrictSchool() {
        return restrictSchool;
    }

    public void setRestrictSchool(String restrictSchool) {
        this.restrictSchool = restrictSchool;
    }

    @Override
    public void update(Observable o, Object arg) {
        //IChatAppCmd cmd = (IChatAppCmd) o;
        //cmd.execute(this);
    }

}
