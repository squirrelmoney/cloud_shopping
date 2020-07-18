app.controller("LoginUserController", function ($scope, LoginUserService) {
    $scope.getloginName=function () {
        LoginUserService.getloginName().success(function (data) {
            console.log(data)
            $scope.loginName = data.loginName;
        })
    }
    })