'use strict'
var module = angular.module('demo.controllers', []);
module.controller("UserController",
    function ($scope, UserService) {
        $scope.a = "123333";

        UserService.getUserById(1).then(function (value) {
            console.log(value.data);
            $scope.paperArray = value.data;
        }, function (reason) {
            console.log("error occured");
        }, function (value) {
            console.log("no callback");
        });
    });