'use strict';

angular.module('myApp.welcome', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/admin', {
            templateUrl: 'welcome/welcome.html',
            controller: 'WelcomeCtrl'
        });
    }]);
