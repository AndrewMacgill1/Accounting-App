angular.module('app.services', []).factory('Accounts', function($resource) {
  return $resource('/api/v1/accounts/:id', { id: '@accountId' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
