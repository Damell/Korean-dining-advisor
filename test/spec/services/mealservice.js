'use strict';

describe('Service: mealService', function () {

  // load the service's module
  beforeEach(module('koreanDiningAdvisorApp'));

  // instantiate service
  var MealService;
  beforeEach(inject(function (_MealService_) {
    MealService = _MealService_;
  }));

  it('should do something', function () {
    expect(!!MealService).toBe(true);
  });

});
