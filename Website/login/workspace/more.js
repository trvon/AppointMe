function more() {
    // Only displays if there is a user
    // Will need to add check for employee with identifier
    if(document.getElementById('name').innerHTML !== "") {
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