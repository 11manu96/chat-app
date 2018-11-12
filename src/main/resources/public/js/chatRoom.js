'use strict';
//-----------Test Data------------//
var userList =['name1','name2','name3'];
var context = ['user1->user2','user2->user4'];
//--------------------------------//

/**
 * Entry point into chat room
 */
window.onload = function() {
    // click li event
    getOnlineUser();
    getMessList();
    $("#btn-msg").click(function() {
        sendMessage($("#chat-dialog-con").val());
    });

    webSocket.onmessage = function(message) {
        updateChatRoom(message);
    };
};

// Get users and write it to online user
function getOnlineUser(){
    var nameList="";
    $.get("./json/data.json",function(data,status){
        if(status == "success"){
            userList = data.user;
            $.each(userList,function(i, item){
                //nameList += "<li style='font-size:14px;color:#5d5d5d;'>"+item.name+"</li><br>";
                nameList += "<option value="+item.value+">"+item.name+"</option>"
            });
            $("#slt-existedlist").html(nameList);
        }else{
            //console.log('DEBUG GET:'+status);
        }
    },"json")
}

// Get mess and write it to chatroom
function getMessList(){
    //console.log("DEBUG:autoRefresh")
    var mesList="";
    $.get("./json/data.json",function(data,status){
        if(status == "success"){
            context = data.mess;
            $.each(context,function(i,item){  
                mesList += "<div  style='font-size:14px;color:#5d5d5d;'>"+"From"+item.from+"to"+item.to+": "+item.info+"</div><br>";
            });
            $("#chat-dialog-con").html(mesList);
        }else{
            console.log('DEBUG GET:'+status);
        }
    },"json")        
}

// Get realtime user&mess data 
// function autoRefresh(){
// 	setInterval(getOnlineUser, 1000);
//     setInterval(getMessList, 1000);
// }

function sendMessage(msg){
    //var $strMess =$("#txtInput");
    if(msg !== "") {
        webSocket.send(msg);
        //$("#txtInput").val("");
    }
}

function updateChatRoom(message){
    var data = JSON.parse(message.data);
    $("#chat-dialog-con").append(data.userMessage);
}

