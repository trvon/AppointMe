var functions = require('firebase-functions');

var config = {
        apiKey: "AIzaSyA0k9j5dceCFVeRp0OLP_DTnXJ2mn5C0DQ",
        authDomain: "timely4-88b69.firebaseapp.com",
        databaseURL: "https://timely4-88b69.firebaseio.com",
        projectId: "timely4-88b69",
        storageBucket: "timely4-88b69.appspot.com",
        messagingSenderId: "252859490902"
    };
    firebase.initializeApp(config);
var admin = require("firebase-admin");

var serviceAccount = require("Key.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://timely4-88b69.firebaseio.com"
});
// // Start writing Firebase Functions
// // https://firebase.google.com/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// })
