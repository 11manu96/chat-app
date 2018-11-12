package edu.rice.comp504.controller;

import edu.rice.comp504.model.chatappobjects.User;
import org.eclipse.jetty.websocket.api.Session;

import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * The chat app controller communicates with all the clients on the web socket.
 */
public class ChatAppController extends Observable {
    static Map<Session, String> sessionUsernameHashmap = new ConcurrentHashMap<>();
    static Map<String, User> usernameHashmap = new ConcurrentHashMap<>();
    static ChatAppController chatAppController;

    private ChatAppController() {

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
     * This message sends commands to all the observers in the chat rooms.
     * It should handle both one-to-one msg and one-to-multi msg
     * @param body user send msg to user in chat room
     */
    public static Object sendMessage(String body){
        //TODO parse and return the info.
        return "";
    }

    /**
     * creates a new user if user not created or logins an already registered user
     * @param user session request if recieved from
     * @param request
     */
    public static void logIn(User user, String request){}

    /**
     * This function is called by WSC to create the chat room.
     * @param user session request if recieved from
     * @param request contains the request parameters
     */
    public static void createChatRoom(User user, String request){}

    /**
     * This function is called by WSC to join the selected chat room.
     * @param user session request if recieved from
     * @param request contains the request parameters
     */
    public static void joinChatRoom(User user, String request){}

    /**
     * funtion invoked by WSC for exiting a particular user from a/all chatroom
     * @param user session request if recieved from
     * @param request contains the request parameters
     */
    public static void leaveChatRoom(User user, String request){}

    /**
     * function envoked by WSC to get all eligible chatrooms for user
     * @param user session request if recieved from
     * @param request contains the request parameters
     */
    public static void getEligibleChatRooms(User user, String request){}



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
