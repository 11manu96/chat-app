'use strict';

const webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/chatapp");

/**
 * Entry point into chat room
 */
window.onload = function() {
    $("#btn-login").click(createUser);
};

function createUser() {
    $.post("/createUser", { name:$("#name").val(), age:$("#age").val(), location:$("#location").val(), school:$("#school").val()}, function (data, status) {
    }, "json");
    window.location.href='mainpage.html';
}