angular.module('app.controllers', []).controller('AccountListController', function($scope, $state, popupService, $window, Accounts) {
  $scope.accounts = Account.query(); //fetch all accounts. Issues a GET to /api/vi/accounts

  $scope.deleteAccount = function(account) { // Delete an Account. Issues a DELETE to /api/v1/accounts/:id
    if (popupService.showPopup('Really delete this?')) {
      account.$delete(function() {
        $scope.accounts = Accounts.query(); 
        $state.go('accounts');
      });
    }
  };
}).controller('AccountViewController', function($scope, $stateParams, Accounts) {
  $scope.account = Accounts.get({ id: $stateParams.id }); //Get a single account.Issues a GET to /api/v1/accounts/:id
}).controller('AccountCreateController', function($scope, $state, $stateParams, Accounts) {
  $scope.account = new Accounts();  //create new account instance. Properties will be set via ng-model on UI

  $scope.addAccount = function() { //create a new account. Issues a POST to /api/v1/accounts
    $scope.account.$save(function() {
      $state.go('accounts'); // on success go back to the list i.e. accounts state.
    });
  };
}).controller('AccountEditController', function($scope, $state, $stateParams, Accounts) {
  $scope.updateAccount = function() { //Update the edited account. Issues a PUT to /api/v1/accounts/:id
    $scope.account.$update(function() {
      $state.go('accounts'); // on success go back to the list i.e. accounts state.
    });
  };

  $scope.loadAccount = function() { //Issues a GET request to /api/v1/accounts/:id to get an account to update
    $scope.account = Accounts.get({ id: $stateParams.id });
  };

  $scope.loadAccount(); // Load an account which can be edited on UI
});
