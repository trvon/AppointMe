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

var starCountRef = firebase.database().ref('AnthemSecurity/' + "0");
starCountRef.on('value', function(snapshot) {
    // updateStarCount(postElement, snapshot.val());
    document.getElementById("name").innerHTML =  snapshot.val().fName;
    document.getElementById("date").innerHTML = "Appt. on: "+snapshot.val().date;
    document.getElementById("time").innerHTML = "at: "+snapshot.val().time;
    document.getElementById("why").innerHTML = "Reasoning: "+snapshot.val().whyImHere;
    if(snapshot.val().fName == ""){
        document.getElementById("dd").innerHTML = "";
        document.getElementById('pic').style.visibility='hidden';
        document.getElementById('button').style.visibility='hidden';
        document.getElementById('btn').style.visibility='hidden';
        document.getElementById('user').style.visibility='hidden';
        document.getElementById("content").style.visibility = "hidden";

    } else {
        document.getElementById('pic').style.visibility='visible';
        document.getElementById('btn').style.visibility='visible';
        document.getElementById('button').style.visibility='visible';
        document.getElementById('user').style.visibility='visible';
        document.getElementById("content").style.visibility = "visible";
    }
});

function finish() {
    //Remove person from
    firebase.database().ref('AnthemSecurity/').remove();
    document.getElementById("pic").style.visibility = "hidden";
    document.getElementById("btn").style.visibility = "hidden";
    document.getElementById("button").style.visibility = "hidden";
    document.getElementById("content").style.visibility = "hidden";
    document.getElementById("refernce").style.visibility = "hidden";
    document.getElementById("name").innerHTML =  "";
    document.getElementById("date").innerHTML = "";
    document.getElementById("time").innerHTML = "";
    document.getElementById("dd").innerHTML ="";
    document.getElementById("why").innerHTML = "";
}
