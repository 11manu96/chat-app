package edu.rice.comp504.chatappobject;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
    private String username;
    private String school;
    private String location;
    private int age;
    private LinkedList<ChatRoom> chatRooms;

    public User(String username,String school,String location,int age) {
        this.username=username;
        this.school=school;
        this.location=location;
        this.age=age;
        this.chatRooms=new LinkedList<>();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LinkedList<ChatRoom> getChatRooms() {
        return chatRooms;
    }






    @Override
    public void update(Observable o, Object arg) {
        //IChatAppCmd cmd = (IChatAppCmd) o;
        //cmd.execute(this);
    }
}
