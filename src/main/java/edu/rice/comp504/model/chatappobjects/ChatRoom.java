package edu.rice.comp504.model.chatappobjects;

import java.util.Observable;
import java.util.Observer;

/**
 * The ChatRoom represents a chat room in the ChatApp. It observes the ChatAppController and
 * is observed by the users in the chat room.
 */
public class ChatRoom extends Observable implements Observer {
    private String name;
    private User owner;
    private String restrictSchool;
    private String restrictLocation;
    private int restrictAge;

    /**
     * Constructor.
     * @param name chat room name
     * @param owner chat room owner user
     * @param restrictLocation chat room location restriction
     * @param restrictSchool chat room school restriction
     * @param restrictAge chat room age restriction
     */
    public ChatRoom(String name, User owner, String restrictLocation, String restrictSchool, int restrictAge) {
        this.name = name;
        this.owner = owner;
        this.restrictAge = restrictAge;
        this.restrictLocation = restrictLocation;
        this.restrictSchool = restrictSchool;
    }

    /**
     * Get chat room name.
     * @return chat room name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set chat room name.
     * @param name chat room name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get chat room owner.
     * @return chat room owner user
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * Set chat room owner.
     * @param owner chat room owner user
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Get chat room age restriction.
     * @return chat room age restriction
     */
    public int getRestrictAge() {
        return restrictAge;
    }

    /**
     * Set chat room age restriction.
     * @param restrictAge chat room age restriction
     */
    public void setRestrictAge(int restrictAge) {
        this.restrictAge = restrictAge;
    }

    /**
     * Get chat room location restriction.
     * @return chat room location restriction
     */
    public String getRestrictLocation() {
        return restrictLocation;
    }

    /**
     * Set chat room location restriction.
     * @param restrictLocation chat room location restriction
     */
    public void setRestrictLocation(String restrictLocation) {
        this.restrictLocation = restrictLocation;
    }

    /**
     * Get chat room school restriction.
     * @return chat room school restriction
     */
    public String getRestrictSchool() {
        return restrictSchool;
    }

    /**
     * Set chat room school restriction.
     * @param restrictSchool chat room school restriction
     */
    public void setRestrictSchool(String restrictSchool) {
        this.restrictSchool = restrictSchool;
    }

    /**
     * Receive message from ChatAppController and notify users in room
     * @param o ChatAppController
     * @param arg send message command
     */
    public void update(Observable o, Object arg) {

    }

}
