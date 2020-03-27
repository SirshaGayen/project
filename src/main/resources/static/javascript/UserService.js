'use strict'
angular.module('demo.services', []).factory('UserService', ["$http", "CONSTANTS", function ($http, CONSTANTS) {
    var service = {};
    service.getUserById = function (userId) {
        var url = CONSTANTS.getUserByIdUrl;
        return $http.get(url);
        //return userId;
    }
    // service.getAllUsers = function() {
    //     return $http.get(CONSTANTS.getAllUsers);
    // }
    // service.saveUser = function(userDto) {
    //     return $http.post(CONSTANTS.saveUser, userDto);
    // }
    return service;
}]);

