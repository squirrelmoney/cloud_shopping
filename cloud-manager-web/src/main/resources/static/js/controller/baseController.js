//品牌控制层
app.controller('baseController' ,function($scope){
    $scope.entity={}

    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    $scope.Ids=[];//选中的ID集合

    //更新复选
    $scope.updateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.Ids.push(id);
        }else{
            var idx = $scope.Ids.indexOf(id);
            $scope.Ids.splice(idx,1);//删除
        }
    }
    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        console.log("json数据",json)
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
                console.log("value1",value)
            }
            value+=json[i][key];
            console.log("value2",value)
        }
        console.log("转换后的数据：",value)
        return value;
    }

});