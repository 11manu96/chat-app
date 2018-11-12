package edu.rice.comp504.controller;

import edu.rice.comp504.model.chatappobjects.User;

import org.eclipse.jetty.websocket.api.Session;

import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * The chat app controller communicates with all the clients on the web socket. It is an
 * observable observed by the chat rooms.
 */
public class ChatAppController extends Observable {
    static Map<Session, String> sessionUsernameHashmap = new ConcurrentHashMap<>();
    static Map<String, User> usernameUserHashmap = new ConcurrentHashMap<>();
    private static ChatAppController chatAppController;

    /**
     * Constructor.
     */
    private ChatAppController() {

    }

    /**
     * Get singleton instance of ChatAppController.
     * @return ChatAppController singleton
     */
    public static ChatAppController getInstance() {
        if (chatAppController == null) {
            chatAppController = new ChatAppController();
        }
        return chatAppController;
    }

    /**
     * ChatApp entry point.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/public");

        webSocket("/chatapp", WebSocketController.class);
        init();
    }

    /**
     * Creates a new user if user not created or retrieves an existing user.
     * @param user user session
     * @param request request body
     */
    public void logIn(Session user, String request) {}

    /**
     * Get all chatrooms user is in or can join.
     * @param user user session
     * @param request request body
     */
    public void getEligibleChatRooms(Session user, String request) {}

    /**
     * Create a chat room.
     * @param user user session
     * @param request request body
     */
    public void createChatRoom(Session user, String request) {}

    /**
     * Join a chat room.
     * @param user user session
     * @param request request body
     */
    public void joinChatRoom(Session user, String request) {}

    /**
     * Get users in chat room and chat history.
     * @param user user session
     * @param request request body
     */
    public void getChatRoom(Session user, String request) {}

    /**
     * Exit one or all chat rooms.
     * @param user user session
     * @param request request body
     */
    public void leaveChatRoom(Session user, String request) {}

    /**
     * Send a message command to all the chat room observers.
     * It should handle both one-to-one msg and one-to-many msg
     * @param request request body
     */
    public void sendMessage(String request) {
        // notifyObservers();
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
