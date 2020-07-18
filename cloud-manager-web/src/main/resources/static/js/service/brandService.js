//提交数据到服务器的接口
app.service("brandService",function ($http) {
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('/Brand/brand/list');
    }

    this.search = function (page,rows,brand) {
        return $http({
            method: 'post',
            url: '/Brand/brand/search?page=' +page + "&rows=" + rows,
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


    this.findPage =function (page,rows) {
        return  $http.get("/Brand/brand/findPage?page=" + page + "&rows=" + rows);
    }
    this.delete=function (ids) {
        return   $http({
            method: 'get',
            url: '/Brand/brand/delete?ids='+ids
        });
    }
})