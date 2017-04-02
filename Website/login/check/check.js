'use strict';

angular.module('myApp.welcome', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/check', {
            templateUrl: 'welcome/check/check.html',
        });
    }]);