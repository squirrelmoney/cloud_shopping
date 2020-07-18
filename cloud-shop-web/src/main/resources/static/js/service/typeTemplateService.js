//服务层
app.service('typeTemplateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../TypeTemplate/typeTemplate/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../TypeTemplate/typeTemplate/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../TypeTemplate/typeTemplate/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../TypeTemplate/typeTemplate/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../TypeTemplate/typeTemplate/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../TypeTemplate/typeTemplate/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../TypeTemplate/typeTemplate/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.getBrandData=function () {
		return $http.get('../Brand/brand/forType');
	}
	this.getSpecificationData=function () {
		return $http.get('../Specification/specification/forType');
	}

});
