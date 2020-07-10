app.controller("baseController", function ($scope) {
    //查询方法
    $scope.brand = {id: "", name: "", firstChar: ""};
    $scope.searchBrand = {id: "", name: "", firstChar: ""};
    $scope.Ids = [];
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            console.log($scope.paginationConf.itemsPerPage)
            //$scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
            //   $scope.reload();//重新加载
            $scope.reloadList();
        }
    };

    $scope.Toupdate = function (data) {
        $scope.brand=data;
    };
    $scope.Tosave = function () {
        $scope.brand = {id: "", name: "", firstChar: ""};
    }



})