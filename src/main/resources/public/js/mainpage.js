'use strict';

const webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/chatapp");

/**
 * Entry point into chat room
 */
window.onload = function() {
    $("#btn-enter").click(enter);
    $("#btn-admin").click(admin);
    $("#btn-create").click(create);
    $("#btn-join").click(function() {
        join("slt-existedlist","slt-ownlist");
    });
    $("#btn-exit").click(function() {
        exit("slt-ownlist","slt-existedlist");
    });
    $("#btn-exitall").click(function() {
        exitAll("slt-ownlist","slt-existedlist");
    });


};

function join(from,to) {
    $.post("/joinChatRoom", { chatroomname:$("#slt-existedlist").val() }, function (data, status) {
    }, "json");
    var fromBox = document.getElementById(from);
    var toBox = document.getElementById(to);
    while(fromBox.selectedIndex != -1){
        toBox.appendChild(fromBox.options[fromBox.selectedIndex]);
    }
}

function exit(from,to) {
    $.post("/leaveChatRoom", { chatroomname:$("#slt-ownlist").val() }, function (data, status) {
    }, "json");
    var fromBox = document.getElementById(from);
    var toBox = document.getElementById(to);
    while(fromBox.selectedIndex != -1){
        toBox.appendChild(fromBox.options[fromBox.selectedIndex]);
    }
}

function exitAll(from,to) {
    $.post("/leaveChatRoom", { chatroomname:$("#slt-ownlist").val() }, function (data, status) {
    }, "json");
    var fromBox = document.getElementById(from);
    var toBox = document.getElementById(to);
    while(fromBox.options.length > 0){
        toBox.appendChild(fromBox.options[0]);
    }
}

function enter() {
    window.location.href='chatroom.html';
}

function admin() {
    window.location.href='admin.html';
}

function create() {
    window.location.href='createroom.html';
}
