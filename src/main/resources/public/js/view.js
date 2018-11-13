'use strict';

const webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/chatapp");

/**
 * Entry point into chat room
 */
window.onload = function() {
    $("#btn-login").click(createUser);

    $("#btn-enter").click(enterRoom);
    $("#btn-exit").click(exitRoom);
    $("#btn-exit-all").click(exitAll);

    $("#btn-join").click(joinRoom);

    $("#btn-create").click(createRoom);

    $("#btn-send").click(sendMessage);

    webSocket.onmessage = function(message) {
        updateChatApp(message);
    };
};

/**
 * Create user profile and load rooms lists for user
 */
function createUser() {

}

/**
 * Load chat room users and messages
 */
function enterRoom() {

}

/**
 * Remove user from chat room
 */
function exitRoom() {

}

/**
 * Remove user from all chat rooms
 */
function exitAll() {

}

/**
 * Add user to chat room
 */
function joinRoom() {

}

/**
 * Create chat room
 */
function createRoom() {

}

/**
 * Send a message in chat room
 */
function sendMessage() {

}

/**
 * Update the chat room with a message
 * @param msg The response or message from server
 */
function updateChatApp(msg) {
    // server will either send a message or response to a request
    // parse message and take appropriate action
    // if message then display in chat dialog
    // or if response then update appropriate page elements
}
