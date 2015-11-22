angular.module('example', [
    'ui.router',
    'angular.filter',
    'ui.bootstrap'
]);

angular.module('example')
        .constant('API_URL', 'http://localhost:8081/example')
        .config(function ($httpProvider, $stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/login');
        });
