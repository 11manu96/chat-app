package edu.rice.comp504.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.eclipse.jetty.websocket.api.Session;

import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;
import static j2html.TagCreator.*;

/**
 * The chat app controller communicates with all the clients on the web socket.
 */
public class ChatAppController extends Observable {
    static Map<Session,String> userNameMap = new ConcurrentHashMap<>();
    //static Map<String, User> userObjMap = new ConcurrentHashMap<>();
    static int nextUserId = 1;

    /**
     * Chat App entry point.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/public");

        webSocket("/chatapp", WebSocketController.class);
        init();

        Gson gson = new Gson();
        post("/login", (request, response) -> {
            String body = request.body();
            return gson.toJson(createUser(body));
        });

        post("/createChatRoom", (request, response) -> {
            String body = request.body();
            return gson.toJson(createChatRoom(body));
        });

        post("/joinChatRoom", (request, response) -> {
            String body = request.body();
            return gson.toJson(joinChatRoom(body));
        });

        post("/sendMsg", (request, response) -> {
            String body = request.body();
            //TODO
            return gson.toJson("");
        });

        post("/leaveChatRoom", (request, response) -> {
           String body = request.body();
           //TODO
           return gson.toJson("");
        });

        get("/CAC", (request, response) -> {
            //TODO return the ChatRoomController itself
           return gson.toJson("");
        });
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
    public static Object broadcastMessage(String body){
        //TODO parse and return the info.
        return "";
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
