'use strict';

/**
 * Entry point into chat room
 */
window.onload = function() {
    createRoom();
};

// Get createRoom data and enter room
function createRoom(){
    var crData ={
        "id":'',
        "name":'',
        "age":'',
        "school":'',
        "location":'',
    }
    //console.log(crData);
    // write input to obj
    crData.name = $("#cr-name").val();
    crData.age = $("#cr-age").val();
    crData.school = $("#cr-school").val();
    crData.location = $("#cr-location").val();
    //console.log(crData);
    // transfer obj to json
    var postData = JSON.stringify(crData);
    console.log(postData);
}