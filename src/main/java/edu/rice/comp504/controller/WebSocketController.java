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

        /*please note that this only updates the Session-id map and not changes anything else
            this is because whenever a browser opens, websocket onConnect gets called, we wants to save the session
            but not login or register user. Once the user tries to login, then the onMessage is called and that is
            where we handle the entire login flow. i.e. attaching an unique id to user and connect it with the
            session already present
        */

        ChatAppController.getInstance().addUser(user);


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
     * Parsing json request or message from front end
     * @param user  The session user sending the message.
     * @param message The message to be sent.
     */
    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        //broadcast the message to all clients

        //parses message and
        String type = "";

        switch(type){

            case "log_in":
                /*pass username password and session to CAC, check for valid password and check if session exists,
                    also returns user_name of a unique identifier to the view
                 */
                ChatAppController.getInstance().logIn(user, message);
                break;

            case "create_chat_room":
                //create chat room
                ChatAppController.getInstance().createChatRoom(user, message);
                break;
            case "join_chat_room":
                //join an already existing chat room
                ChatAppController.getInstance().joinChatRoom(user, message);
                break;
            case "leave_Chat_room":
                ChatAppController.getInstance().leaveChatRoom(user, message);
                break;
            case "get_eligible_chat_room_list":
                ChatAppController.getInstance().getEligibleChatRooms(user, message);
                break;


        }


    }
}
