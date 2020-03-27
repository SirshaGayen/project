var demoApp = angular.module('demo'
    , ['demo.controllers', 'demo.services']
);
// demoApp.config(['$routeProvider','$httpProvider',
// 	function($routeProvider,$httpProvider) {
//     $routeProvider
//     .when("/ab", {
//         templateUrl : "../templates/paper.html",
//         controller:'PaperController'
//     });
// }]);
demoApp.constant("CONSTANTS", {
    getUserByIdUrl: "http://localhost:8080/a",
    getAllUsers: "/user/getAllUsers",
    saveUser: "/user/saveUser"
});