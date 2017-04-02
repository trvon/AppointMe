var Firebase = require("firebase");
var firebase = new Firebase("https://timely4-88b69.firebaseio.com");
var config = {
    apiKey: "AIzaSyA0k9j5dceCFVeRp0OLP_DTnXJ2mn5C0DQ",
    authDomain: "timely4-88b69.firebaseapp.com",
    databaseURL: "https://timely4-88b69.firebaseio.com",
    projectId: "timely4-88b69",
    storageBucket: "timely4-88b69.appspot.com",
    messagingSenderId: "252859490902"
};
firebase.initializeApp(config);
//var rootRef = firebase.database();

var starCountRef = firebase.database().ref('AnthemUser/' + "0");
starCountRef.on('value', function(snapshot) {
    // updateStarCount(postElement, snapshot.val());
    console.log("VALUE",snapshot.val());
    //actual info printed below
    //document.write(snapshot.val().fName);
    //document.write(snapshot.val().id);
    //document.write(snapshot.val().time);
});

function time() {
    var t = firebase.database().ref('AnthemUser/' + "0").on('value', function(snapshot) {
        return snapshot.val().time});
    return t;
}