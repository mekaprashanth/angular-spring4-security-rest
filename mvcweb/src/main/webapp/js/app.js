angular
		.module('exampleApp', [ 'ngRoute', 'ngCookies', 'exampleApp.services' ])
		.config(
				[
						'$routeProvider',
						'$locationProvider',
						'$httpProvider',
						function($routeProvider, $locationProvider,
								$httpProvider) {

							$routeProvider.when('/create', {
								templateUrl : 'partials/create.html',
								controller : CreateController
							});

							$routeProvider.when('/login', {
								templateUrl : 'partials/login.html',
								controller : LoginController
							});

							$routeProvider.otherwise({
								templateUrl : 'partials/home.html',
								controller : IndexController
							});

							$locationProvider.hashPrefix('!');

							/*
							 * Register error provider that shows message on
							 * failed requests or redirects to login page on
							 * unauthenticated requests
							 */
							$httpProvider.interceptors.push(function($q,
									$rootScope, $location) {
								return {
									'responseError' : function(rejection) {
										var status = rejection.status;
										var config = rejection.config;
										var method = config.method;
										var url = config.url;

										if (status == 401) {
											$location.path("/login");
										} else {
											$rootScope.error = method + " on "
													+ url
													+ " failed with status "
													+ status;
										}

										return $q.reject(rejection);
									}
								};
							});

							/*
							 * Registers auth token interceptor, auth token is
							 * either passed by header or by query parameter as
							 * soon as there is an authenticated user
							 */
							$httpProvider.interceptors
									.push(function($q, $rootScope, $location) {
										return {
											'request' : function(config) {
												var isRestCall = config.url
														.indexOf('rest') == 0;
												if (isRestCall
														&& angular
																.isDefined($rootScope.authToken)) {
													var authToken = $rootScope.authToken;
													if (exampleAppConfig.useAuthTokenHeader) {
														config.headers['X-Auth-Token'] = authToken;
													} else {
														config.url = config.url
																+ "?token="
																+ authToken;
													}
												}
												return config
														|| $q.when(config);
											}
										};
									});

							$httpProvider.interceptors
									.push(function($rootScope) {
										return {
											'response' : function(response) {
												var xAuthToken = response
														.headers()['X-Auth-Token'];
												if (xAuthToken !== undefined) {
													$rootScope.authToken = xAuthToken;
												}
												return response;
											}
										};
									});
						} ]

		)
		.run(
				function($rootScope, $location, $cookieStore, $cookies,
						UserService) {

					/* Reset error when a new view is loaded */
					$rootScope.$on('$viewContentLoaded', function() {
						delete $rootScope.error;
					});

					$rootScope.hasRole = function(role) {
						var found = -1;
						if (angular.isDefined($rootScope.loginuser)) {
							found = $.inArray(role, $rootScope.loginuser.roles) > -1;
						}

						return found;
					};

					$rootScope.logout = function() {
						delete $rootScope.loginuser;
						delete $rootScope.authToken;
						UserService.logout();
						$location.path("/login");
					};

					// /* Try getting valid user from cookie or go to login page
					// */
					// var originalPath = $location.path();
					// $location.path("/login");
					// var remembermetoken =
					// $cookieStore.get('remember_me_cookie');
					// var remembermetoken2 =
					// $cookies.getObject('remember_me_cookie');
					//
					// if (remembermetoken !== undefined || remembermetoken2 !==
					// undefined) { $rootScope.authToken = authToken;
					// $location.path(originalPath);
					// }

					$rootScope.initialized = true;
				});

function IndexController($scope, $rootScope, $log, UserService) {

	if (!angular.isDefined($rootScope.loginuser)) {
		var promise = UserService.checklogin();
		var payload;
		promise.then(function(payload) {
			$log.debug("IndexController checklogin -- "
					+ JSON.stringify(payload.data));
			$rootScope.loginuser = payload.data;
		}, function(errorPayload) {
			$log.error('failure checking login user', errorPayload);
		});
	}
	var promise = UserService.getallusers();
	var payload;
	promise.then(function(payload) {
		$log.debug("IndexController getallusers -- "
				+ JSON.stringify(payload.data));
		$scope.users = payload.data;
	}, function(errorPayload) {
		$log.error('failure getting all users', errorPayload);
	});
};

function CreateController($scope, $location, UserService, $log) {

	$scope.user = {};
	$scope.roles = ['ADMIN', 'USER', 'CEO'];
//	$scope.role={};
	$scope.selectedroles=[];
	// toggle selection for a given fruit by name
	  $scope.toggleSelection = function toggleSelection(rolename) {
	    var idx = $scope.selectedroles.indexOf(rolename);

	    // is currently selected
	    if (idx > -1) {
	      $scope.selectedroles.splice(idx, 1);
	    }

	    // is newly selected
	    else {
	      $scope.selectedroles.push(rolename);
	    }
	  };
	$scope.save = function() {
		$scope.user['roles'] = $scope.selectedroles;
		var promise = UserService.createuser($scope.user);
		$log.debug($scope.user);
		var payload;
		promise.then(function(payload) {
			$log.debug(payload.data);
			$location.path("/");
		}, function(errorPayload) {
			$log.error('failure creating user', errorPayload);
		});
	};
};

function LoginController($scope, $log, $rootScope, $location, $cookieStore,
		UserService) {
	$scope.login = function() {
		var promise = UserService.login($scope.username, $scope.password,
				$scope.rememberMe);
		promise.then(function(payload) {
			$rootScope.loginuser = payload.data;
			$log.debug("LoginController login -- "
					+ JSON.stringify(payload.data));
			$location.path('/');
		}, function(errorPayload) {
			$log.error('failure authenticating user', errorPayload);
		});
	};
};

var services = angular.module('exampleApp.services', [ 'ngResource',
		'ngCookies' ]);

services.factory("UserService", function($http, $rootScope, $cookieStore) {
	return {
		
		logout : function()	{
			return $http.get('/mvcsample/logout');
		},
		checklogin : function() {
			return $http.get('/mvcsample/rest/checklogin', {
				headers : {
					'Content-Type' : 'application/json'
				}
			});
		},

		getallusers : function() {
			return $http.get('/mvcsample/rest/users');
		},
		getuserdetails : function(userIdParam) {
			var user = $resource('/mvcsample/rest/user/:userId', {
				userId : '@userId'
			});
			user.get({
				userId : userIdParam
			})
			return user;
		},
		createuser : function(newUser) {
			return $http.post('/mvcsample/rest/portaluser', newUser, {

				headers : {
					// 'Content-Type' : 'application/x-www-form-urlencoded'
					'Content-Type' : 'application/json'
				}
			});
		},
		login : function(username, password, rememberme) {
			// if (!rememberme) {
			// $cookieStore.remove('remember_me_cookie');
			// }
			return $http({
				url : '/mvcsample/login',
				method : 'POST',
				data : $.param({
					'username' : username,
					'password' : password,
					'rememberme' : rememberme
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			});
		}
	};
});
