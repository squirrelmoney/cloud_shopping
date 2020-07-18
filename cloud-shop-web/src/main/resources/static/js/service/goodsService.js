//服务层
app.service('goodsService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../Goods/goods/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../Goods/goods/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../Goods/goods/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../Goods/goods/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../Goods/goods/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../Goods/goods/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../Goods/goods/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.findByParentId=function(parentId){
		return $http.get('../Goods/goods/findOnlyByParentId?parentId='+parentId);
	}
//文件上传服务层
	app.service("uploadService",function($http){
		this.uploadFile=function(){
			var formData=new FormData();
			formData.append("file",file.files[0]);
			return $http({
				method:'POST',
				url:"../upload.do",
				data: formData,
				headers: {'Content-Type':undefined},
				transformRequest: angular.identity
			});
		}
	});

});
