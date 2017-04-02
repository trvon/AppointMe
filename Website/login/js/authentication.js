var authClient = new FirebaseSimpleLogin(myRef, function(error, user) { ... });
authClient.createUser(email, password, function(error, user) {
    if (error === null) {
        console.log("User created successfully:", user);
    } else {
        console.log("Error creating user:", error);
    }
});
var authClient = new FirebaseSimpleLogin(myRef, function(error, user) { ... });
authClient.login('password', {
    email: '<email@domain.com>',
    password: '<password>'
});