package edu.rice.comp504.controller;

import com.google.gson.JsonObject;
import edu.rice.comp504.chatappobject.User;
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
    }

    /**
     * Close the user's session.
     * @param user The use whose session is closed.
     */
    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
    }

    /**
     * Parsing json request or message from front end
     * @param user  The session user sending the message.
     * @param message The message to be sent.
     */
    @OnWebSocketMessage
    public void onMessage(Session user, String message) {


        //broadcast the messaxge to all clients

        //parses message and get request or message
        String type = "";

        //get User object from ChatAppController
        User userObj = null;


        switch(type){

            case "log_in":
                /*pass username password and session to CAC, check for valid password and check if user exists,
                    also returns user_name of a unique identifier to the view
                 */
                ChatAppController.getInstance().logIn(userObj, message);
                break;

            case "create_chat_room":
                //create chat room
                ChatAppController.getInstance().createChatRoom(userObj, message);
                break;
            case "join_chat_room":
                //join an already existing chat room
                ChatAppController.getInstance().joinChatRoom(userObj, message);
                break;
            case "leave_Chat_room":
                ChatAppController.getInstance().leaveChatRoom(userObj, message);
                break;

            case "get_eligible_chat_room_list":
                ChatAppController.getInstance().getEligibleChatRooms(userObj, message);
                break;


        }


    }
}
