app.controller("brandController", function ($scope, brandService,$controller) {
    $controller('baseController',{$scope:$scope});
    //查询方法
    $scope.brand = {id: "", name: "", firstChar: ""};
    $scope.searchBrand = {id: "", name: "", firstChar: ""};
    $scope.Ids = [];
    $scope.Toupdate = function (data) {
        $scope.brand=data;
    };
    $scope.Tosave = function () {
        $scope.brand = {id: "", name: "", firstChar: ""};
    }


    $scope.reloadList=function(){
        $scope.search();
    };
    $scope.search = function () {
        brandService.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage, $scope.searchBrand)
            .success(function (data) {
                console.log(data)
            $scope.list = data.data.pageNum;
            $scope.paginationConf.totalItems = data.data.pageSize;

        })
    };

    //$scope.optionButton = "";
    $scope.option=function(){
        var method={};
        if($scope.brand.id==undefined||$scope.brand.id==""||$scope.brand.id==null){
            method=brandService.save;
        }else{
            method=brandService.update;
        }
        method($scope.brand).success(function (data) {
            console.log(data)
            $scope.paginationConf.currentPage = (data.data.id / $scope.paginationConf.itemsPerPage) + 1;
            console.log($scope.paginationConf.currentPage)
          //  $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        })
    };


    $scope.checkboxModel = function ($event, data) {
        if ($event.target.checked) {  //$event表示源   如果为true，则添加，如果false则删除
            $scope.Ids.push(data.id);
            console.log($scope.Ids)
        } else {
            var idx = $scope.Ids.indexOf(data.id);//纯JS（找到该id的索引位置）
            $scope.Ids.splice(idx, 1);//参数一（索引的位置） 参数二（删除的个数）
            console.log($scope.Ids)
        }
    }
    $scope.delete = function () {
       brandService.delete($scope.Ids).success(function () {
            console.log($scope.Ids);
            console.log($scope.paginationConf.currentPage)
            $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        })
    };
    $scope.findPage = function () {
        brandService.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.Ids = [];
            $scope.list = data.pageNum;
            console.log(data);
            $scope.paginationConf.totalItems = data.pageSize;
        })
    };

})