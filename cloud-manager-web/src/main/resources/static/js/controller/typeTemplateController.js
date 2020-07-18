 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.entity.brandIds=  JSON.parse($scope.entity.brandIds);//转换品牌列表
				$scope.entity.specIds=  JSON.parse($scope.entity.specIds);//转换规格列表
				$scope.entity.customAttributeItems= JSON.parse($scope.entity.customAttributeItems);//转换扩展属性

			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象
		$scope.entity.brandIds=JSON.stringify($scope.entity.brandIds);
		$scope.entity.specIds=JSON.stringify($scope.entity.specIds);
		$scope.entity.customAttributeItems=JSON.stringify($scope.entity.customAttributeItems);
		if($scope.entity.id!=null&&$scope.entity.id!=""&&$scope.entity.id!=undefined){//如果有ID
			serviceObject=typeTemplateService.update($scope.entity); //修改
			$scope.entity={id:"",name:"",specIds:{},brandIds:{},customAttributeItems:[]}
		}else{
			console.log("添加的对象",$scope.entity)
			serviceObject=typeTemplateService.add( $scope.entity);//增加
			$scope.entity={id:"",name:"",specIds:{},brandIds:{},customAttributeItems:[]}
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		typeTemplateService.dele( $scope.Ids ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.Ids=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				console.log(response)
				$scope.list=response.pageNum;
				$scope.paginationConf.totalItems=response.pageSize;//更新总记录数
			}			
		);
	}
	$scope.brandList={data:[]};//品牌列表
	$scope.specificationList={data:[]}
	$scope.entity={id:"",name:"",specIds:{},brandIds:{},customAttributeItems:[]}
	//$scope.brandList={data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};//品牌列表
	//搜索
	$scope.getData=function(){
		$scope.getBrandData();
		$scope.getSpecificationData();
	}
	$scope.getBrandData=function(){
		typeTemplateService.getBrandData().success(
			function(response){
				$scope.brandList.data=response;
				console.log("品牌列表：",$scope.brandList)
			}
		);

	$scope.getSpecificationData=function () {
		typeTemplateService.getSpecificationData().success(
			function(response){
				console.log(response)
				$scope.specificationList.data=response;
				console.log("规格列表：",$scope.specificationList);
			}
		)};

		//新增扩展属性行
		$scope.addTableRow=function(){
			$scope.entity.customAttributeItems.push({});
		}

		//删除扩展属性行
		$scope.deleTableRow=function(index){
			$scope.entity.customAttributeItems.splice(index,1);//删除
		}


	}
});	
