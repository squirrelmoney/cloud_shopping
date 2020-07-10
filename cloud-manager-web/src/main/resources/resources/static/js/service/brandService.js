//提交数据到服务器的接口
app.service("brandService",function ($http) {
    this.search = function (pageNo,pageSize,brand) {
        return $http({
            method: 'post',
            url: '/Brand/brand/search?pageNo=' +pageNo + "&pageSize=" + pageSize,
            data: brand
        });
    }
    this.save = function (brand) {
        // $scope.brand = angular.copy($scope.brand);
        return $http({
            method: 'put',
            url: '/Brand/brand/',
            data: brand
        })
    }
    this.update = function (brand) {
        // $scope.brand = angular.copy($scope.brand);
        return $http({
            method: 'post',
            url: '/Brand/brand/',
            data: brand
        })
    }


    this.findPage =function (pageNo,pageSize) {
        return  $http.get("/Brand/brand/findPage?pageNo=" + pageNo + "&pageSize=" + pageSize);
    }
    this.delete=function (ids) {
        return   $http({
            method: 'post',
            url: '/Brand/brand/ids',
            data: ids,
        });
    }
})