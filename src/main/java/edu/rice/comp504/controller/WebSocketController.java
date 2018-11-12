package edu.rice.comp504.controller;

import edu.rice.comp504.model.chatappobjects.User;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Create a web socket for the server.
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
     * Send request from view.
     * @param user The session user sending the message.
     * @param message The request to be executed.
     */
    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        // parse request type
        String type = message;

        // call appropriate method in ChatAppController
        switch (type) {
            case "log_in":
                // create or retrieve user in hash map
                ChatAppController.getInstance().logIn(user, message);
                break;
            case "get_eligible_chat_rooms":
                // get list of chat rooms that user is in or can join
                // this can be combined with login
                ChatAppController.getInstance().getEligibleChatRooms(user, message);
                break;
            case "join_chat_room":
                // join an existing chat room
                ChatAppController.getInstance().joinChatRoom(user, message);
                break;
            case "get_chat_room":
                // get users in chat room and message history when entering chat room
                ChatAppController.getInstance().getChatRoom(user, message);
                break;
            case "exit_chat_room":
                // exit one or all chat rooms
                ChatAppController.getInstance().leaveChatRoom(user, message);
                break;
            case "create_chat_room":
                // create chat room
                ChatAppController.getInstance().createChatRoom(user, message);
                break;
            case "send_message":
                // send message to user in chat room
                ChatAppController.getInstance().sendMessage(message);
                break;
            default:
                break;
        }
    }
}
