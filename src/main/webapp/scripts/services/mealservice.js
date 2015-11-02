'use strict';

/**
 * @ngdoc service
 * @name koreanDiningAdvisorApp.mealService
 * @description
 * # mealService
 * Service in the koreanDiningAdvisorApp.
 */
angular.module('koreanDiningAdvisorApp')
.service('MealService', function ($resource) {
	var def = $resource('meals', {}, {
		'getAll' : {
			'method' : 'GET',
			'isArray' : true
		}
	});
	return def;

});
