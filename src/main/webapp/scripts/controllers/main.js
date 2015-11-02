'use strict';

/**
 * @ngdoc function
 * @name koreanDiningAdvisorApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the koreanDiningAdvisorApp
 */
angular.module('koreanDiningAdvisorApp')
.controller('MainCtrl', function ($scope, MealService) {

	$scope.meals = MealService.getAll();

});
