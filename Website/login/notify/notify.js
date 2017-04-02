'use strict';

angular.module('myApp.welcome', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/notify', {
            templateUrl: 'notify/notify.html'
        });
    }]);
