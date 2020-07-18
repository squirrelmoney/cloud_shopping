//控制层
app.controller('itemCatController', function ($scope, $controller, itemCatService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        itemCatService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    //分页
    $scope.findPage = function (page, rows) {
        itemCatService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    $scope.templateEntity={}
    $scope.locatId=function () {
        $scope.entity.typeId=$scope.templateEntity.id;

    }

    $scope.locateParent=function(){

        if ($scope.entity_2 !=null){
            $scope.entity.parentId=$scope.entity_2.parentId+1;//entity_x显示的是父级目录
        }else  if ($scope.entity_1 !=null){
            $scope.entity.parentId=$scope.entity_1.parentId+1;
        }else {
            $scope.entity.parentId=0;
        }
        console.log("模板",$scope.entity)
    }
    //保存
    $scope.save = function () {

        var serviceObject;//服务层对象
        if ($scope.entity.id != null&&$scope.entity.id!=0&&$scope.entity.id!=""&&$scope.entity.id!=undefined ) {//如果有ID
            serviceObject = itemCatService.update($scope.entity); //修改
        } else {
            serviceObject = itemCatService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                    $scope.entity={}
                } else {
                    alert(response.message);
                }
            }
        );
    }


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        itemCatService.dele($scope.Ids).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.Ids = [];
                }
            }
        );
    }


    $scope.searchEntity = {};//定义搜索对象
    //分页控件配置
    $scope.MypaginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载

        }
    };
    $scope.p_entity={id:0}
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByParentId($scope.MypaginationConf.currentPage, $scope.MypaginationConf.itemsPerPage, $scope.p_entity.id);//重新加载
    }
    //根据上级ID显示下级列表
    $scope.findByParentId = function (page, rows, parentId) {
        itemCatService.findByParentId(parentId, page, rows).success(
            function (response) {
                console.log(response)
                $scope.list = response.pageNum;
                $scope.MypaginationConf.totalItems = response.pageSize;//更新总记录数
            }
        );
    }
    $scope.grade = 1;//默认为1级
    //设置级别
    $scope.setGrade = function (value) {
        $scope.grade = value;
    }

    //读取列表
    $scope.selectList = function (p_entity) {
        if ($scope.grade == 1) {//如果为1级
            $scope.entity_1 = null;
            $scope.entity_2 = null;
        }
        if ($scope.grade == 2) {//如果为2级
            $scope.entity_1 = p_entity;
            $scope.entity_2 = null;
        }
        if ($scope.grade == 3) {//如果为3级
            $scope.entity_2 =p_entity;
        }
        $scope.p_entity=p_entity;
        $scope.reloadList();	//查询此级下级列表
        $scope.locateParent();
    }

    $scope.templateList={}

    //查询实体
    $scope.findOne = function (id) {
        itemCatService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }
    //搜索
    $scope.typeTemplate=function() {
        itemCatService.getTypeTemplateData().success(
            function (response) {
                $scope.templateList=response;
                console.log("模板列表：",$scope.templateList)

            }
        );
    }

});	
