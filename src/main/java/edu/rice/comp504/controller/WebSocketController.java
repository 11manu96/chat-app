package edu.rice.comp504.controller;

import com.google.gson.JsonObject;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Create a web socket for the server
 */
@WebSocket
public class WebSocketController {

    /**
     * Open user's session.
     * @param user The user whose session is opened.
     */
    @OnWebSocketConnect
    public void onConnect(Session user) {
        //generate username, add to session to userId map
        int userId = ChatAppController.nextUserId++;
        //ChatAppController.userNameMap.put(user, userId);

        //broadcasts user id counter to view
        try {
            JsonObject jo = new JsonObject();
            jo.addProperty("userId", userId);
            user.getRemote().sendString(String.valueOf(jo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the user's session.
     * @param user The use whose session is closed.
     */
    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        //remove user from session to username map


        //remove user from userId to username map


    }

    /**
     * Send a message.
     * @param user  The session user sending the message.
     * @param message The message to be sent.
     */
    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        //broadcast the message to all clients


    }
}
