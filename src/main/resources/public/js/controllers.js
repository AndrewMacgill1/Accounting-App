angular.module('app.controllers', []).controller('ShipwreckListController', function($scope, $state, popupService, $window, Accounts) {
  $scope.accounts = Accounts.query(); //fetch all accounts. Issues a GET to /api/vi/accounts

  $scope.deleteAccounts = function(accounts) { // Delete an account. Issues a DELETE to /api/v1/accounts/:id
    if (popupService.showPopup('Really delete this?')) {
      accounts.$delete(function() {
        $scope.accounts = Accounts.query(); 
        $state.go('accounts');
      });
    }
  };
}).controller('ShipwreckViewController', function($scope, $stateParams, Accounts) {
  $scope.accounts = Accounts.get({ id: $stateParams.id }); //Get a single account. Issues a GET to /api/v1/accounts/:id
}).controller('ShipwreckCreateController', function($scope, $state, $stateParams, Accounts) {
  $scope.accounts = new Accounts();  //create new account instance. Properties will be set via ng-model on UI

  $scope.addAccounts = function() { //create a new account. Issues a POST to /api/v1/accounts
    $scope.accounts.$save(function() {
      $state.go('accounts'); // on success go back to the list i.e. accounts state.
    });
  };
}).controller('ShipwreckEditController', function($scope, $state, $stateParams, Accounts) {
  $scope.updateAccounts = function() { //Update the edited account. Issues a PUT to /api/v1/accounts/:id
    $scope.accounts.$update(function() {
      $state.go('accounts'); // on success go back to the list i.e. accounts state.
    });
  };

  $scope.loadAccounts = function() { //Issues a GET request to /api/v1/accounts/:id to get an account to update
    $scope.accounts = Accounts.get({ id: $stateParams.id });
  };

  $scope.loadAccounts(); // Load an account which can be edited on UI
});
