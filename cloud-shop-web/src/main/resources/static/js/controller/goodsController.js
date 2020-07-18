 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,goodsService,uploadService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	$scope.initentity=function(){
		$scope.entity={};
		$scope.entity.goods={}
		$scope.entity.goodsDesc={}
		$scope.entity.itemImages=[]
	}


	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			$scope.entity.goodsDesc.introduction=editor.html();
			$scope.entity.goodsDesc.itemImages=JSON.stringify($scope.entity.goodsDesc.itemImages)

			console.log($scope.entity)
			serviceObject=goodsService.add( $scope.entity);//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
		        	$scope.reloadList();//重新加载
					$scope.initentity();
					editor.html('');//清空富文本编辑器
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.Ids ).success(
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
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.pageNum;
				$scope.paginationConf.totalItems=response.pageSize;//更新总记录数
			}			
		);
	}
	$scope.grade = 1;//默认为1级
	//设置级别
	$scope.setGrade = function (value) {
		$scope.grade = value;
	}

	//根据上级ID显示下级列表
	$scope.findByParentId=function(parentId){
		goodsService.findByParentId(parentId).success(
			function(response){
				console.log(response)
				if ($scope.grade===1)
					$scope.category1=response;
				else if ($scope.grade===2)
				$scope.category2=response;
				else if ($scope.grade===3){
					$scope.category3=response;

				}

			}
		);
	}
	$scope.categoryentity1={}
	$scope.categoryentity2={}
	$scope.categoryentity3={}
	//$scope.entity={goods:[],goodsDesc:[],itemList:[]}
	$scope.entity.goods={}
	$scope.entity.goodsDesc={}
	$scope.entity.goodsDesc.itemImages=[]
	$scope.locatIds=function () {
		if ($scope.grade===1){
			$scope.entity.goods.category1Id=$scope.categoryentity1.id;
			$scope.findByParentId($scope.categoryentity1.id);
			$scope.setGrade(2)
		}
		else if ($scope.grade===2){
			$scope.entity.goods.category2Id=$scope.categoryentity2.id;
			$scope.findByParentId($scope.categoryentity2.id);
			$scope.setGrade(3)
		}
		else if ($scope.grade===3){
			$scope.entity.goods.category3Id=$scope.categoryentity3.id;
			$scope.entity.goods.typeTemplateId=$scope.categoryentity3.typeId;
		}
		console.log("添加数据",$scope.entity)
	}
	/**
	 * 上传图片
	 */
	$scope.image_entity={};
	$scope.uploadFile=function(){
		uploadService.uploadFile().success(function(response) {
			console.log(response)
			if(response.success){//如果上传成功，取出url
				$scope.image_entity.url=response.message;//设置文件地址
				console.log($scope.image_entity.url)
			}else{
				alert(response.message);
			}
		}).error(function() {
			alert("上传发生错误");
		});
	};


	//添加图片列表
	$scope.add_image_entity=function(){
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
		$scope.image_entity={};
	}
	//列表中移除图片
	$scope.remove_image_entity=function(index){
		$scope.entity.goodsDesc.itemImages.splice(index,1);
	}

});	
