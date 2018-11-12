package edu.rice.comp504.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.rice.comp504.chatappobject.ChatRoom;
import edu.rice.comp504.chatappobject.User;
import org.eclipse.jetty.websocket.api.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;
import static j2html.TagCreator.*;

/**
 * The chat app controller communicates with all the clients on the web socket.
 */
public class ChatAppController {
    static Map<Session, String> sessionUsernameHashmap = new ConcurrentHashMap<>();
    static Map<User, String> usernameHashmap = new ConcurrentHashMap<>();
    static ChatAppController chatAppController;

    private void ChatAppController(){

    }
    /**
     * Chat App entry point.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/public");

        webSocket("/chatapp", WebSocketController.class);
        init();


    }

    /**
     * This function is called by CAC to create the user.
     * @param body post request contains the user name and password
     * @return User id and status of the post request
     */
    private static Object createUser(String body){
        //TODO return the created user and also update the hashmaps.
        return "";
    }

    /**
     * This function is called by CAC to create the chat room.
     * @param body post requst contains the user name and password
     * @return chat room id
     */
    private static Object createChatRoom(String body){
        //TODO return the created chat room and also update the hashmaps.
        return "";
    }

    /**
     * This function is called by CAC to join the select chat room.
     * @param body chat room info
     */
    private static Object joinChatRoom(String body){
        //TODO return the chat room the user selected.
        return "";
    }

    /**
     * This message sends commands to all the observers in the chat rooms.
     * It should handle both one-to-one msg and one-to-multi msg
     * @param body user send msg to user in chat room
     */
    public static Object sendMessage(String body){
        //TODO parse and return the info.
        return "";
    }


    public static void logIn(Session session, String request){}

    public static void createChatRoom(Session session, String request){}

    public static void joinChatRoom(Session session, String request){}

    public static void leaveChatRoom(Session session, String request){}

    public static void getEligibleChatRooms(Session session, String request){}



    public static ChatAppController getInstance(){

        if(chatAppController == null){
            chatAppController = new ChatAppController();
        }

        return chatAppController;
    }

    /**
     * Get the heroku assigned port number.
     * @return The heroku assigned port number
     */
    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set.
    }
}
