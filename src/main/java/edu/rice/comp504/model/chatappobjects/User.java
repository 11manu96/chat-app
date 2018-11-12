package edu.rice.comp504.model.chatappobjects;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * A User represents a ChatApp user that can exist across sessions. The User
 * observes each chat room it is in.
 */
public class User implements Observer {
    private String username;
    private String school;
    private String location;
    private int age;
    private LinkedList<ChatRoom> chatRooms;

    /**
     * Constructor.
     * @param username user name identifier
     * @param school user school
     * @param location user location
     * @param age user age
     */
    public User(String username, String school, String location, int age) {
        this.username = username;
        this.school = school;
        this.location = location;
        this.age = age;
        this.chatRooms = new LinkedList<>();
    }

    /**
     * Get user name identifier.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Set user name identifier.
     * @param username user name identifier
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get user age.
     * @return user age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Set user age.
     * @param age user age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get user location.
     * @return user location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Set user location.
     * @param location user location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get user school.
     * @return user school
     */
    public String getSchool() {
        return this.school;
    }

    /**
     * Set user school.
     * @param school user school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Get chat rooms user is in.
     * @return chat rooms user is in
     */
    public LinkedList<ChatRoom> getChatRooms() {
        return this.chatRooms;
    }

    /**
     * Add chat room to user chat rooms list.
     * @param chatRoom chat room to join
     */
    public void joinChatRoom(ChatRoom chatRoom) {
        this.chatRooms.add(chatRoom);
    }

    /**
     * Receive message from chat room and broadcast to view.
     * @param o chat room user is in
     * @param arg send message command from chat room
     */
    public void update(Observable o, Object arg) {

    }
}
