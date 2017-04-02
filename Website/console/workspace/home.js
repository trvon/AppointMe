var config = {
    apiKey: "AIzaSyA0k9j5dceCFVeRp0OLP_DTnXJ2mn5C0DQ",
    authDomain: "timely4-88b69.firebaseapp.com",
    databaseURL: "https://timely4-88b69.firebaseio.com",
    projectId: "timely4-88b69",
    storageBucket: "timely4-88b69.appspot.com",
    messagingSenderId: "252859490902"
};

firebase.initializeApp(config);
var rootRef = firebase.database();

var starCountRef = firebase.database().ref('AnthemSecurity/' + "0");
starCountRef.on('value', function(snapshot) {
    // updateStarCount(postElement, snapshot.val());
    console.log("VALUE",snapshot.val());
    document.getElementById("name").innerHTML =  snapshot.val().fName;
    document.getElementById("date").innerHTML = "Appt. on: "+snapshot.val().date;
    document.getElementById("time").innerHTML = "at: "+snapshot.val().time;
    document.getElementById("why").innerHTML = "Reasoning: "+snapshot.val().whyImHere;
    if(snapshot.val().fName === ""){
        document.getElementById("dd").innerHTML = "";
        document.getElementById('pic').style.visibility='hidden';
        document.getElementById('button').style.visibility='hidden';
        document.getElementById('btn').style.visibility='hidden';
        document.getElementById('user').style.visibility='hidden';
        document.getElementById('temp').style.visibility='hidden';
        document.getElementById('reference').style.visibility='hidden';

    } else {
        document.getElementById("dd").innerHTML = "Confirmed meeting with Monica";
        document.getElementById('pic').style.visibility='visible';
        document.getElementById('btn').style.visibility='visible';
        document.getElementById('button').style.visibility='visible';
        document.getElementById('reference').style.visibility='visible';
        document.getElementById("button").style.visibility='visible';
        document.getElementById('user').style.visibility='visible';
    }
    document.write(snapshot.val().fName);
    document.write(snapshot.val().id);
    document.write(snapshot.val().time);

});
function finish() {
    //Remove person from
    firebase.database().ref('AnthemSecurity/').remove();
    document.getElementById("pic").style.visibility = "hidden";
    document.getElementById("btn").style.visibility = "hidden";
    document.getElementById("button").style.visibility = "hidden";
    document.getElementById("temp").style.visibility = "hidden";
    document.getElementById("refernce").style.visibility = "hidden";
    document.getElementById("name").innerHTML =  "";
    document.getElementById("date").innerHTML = "";
    document.getElementById("time").innerHTML = "";
    document.getElementById("dd").innerHTML ="";
    document.getElementById("why").innerHTML = "";
}

function more() {
    // Only displays if there is a user
    // Will need to add check for employee with identifier
    if(document.getElementById('name').innerHTML === "") {
        var contact = firebase.database().ref('AnthemContacts/' + "0");
        contact.on('value', function(info) {
            document.getElementById("empName").innerHTML = info.val().fName;
            document.getElementById("local").innerHTML = info.val().location;
            document.getElementById("empName").style.display="visible";
            document.getElementById("local").style.display="visible";
        })} else {
        document.getElementById("empName").style.display="hidden";
        document.getElementById("local").style.display="hidden";
    }
}