//服务层
app.service('sellerService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../Seller/seller/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../Seller/seller/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../Seller/seller/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../Seller/seller/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../Seller/seller/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../Seller/seller/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../Seller/seller/search?page='+page+"&rows="+rows, searchEntity);
	}
	//更改状态
	this.updateStatus=function(sellerId,status){
		return $http.get('../Seller/seller/updateStatus?sellerId='+sellerId+'&status='+status);
	}

});
