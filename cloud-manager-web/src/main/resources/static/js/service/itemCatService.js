//服务层
app.service('itemCatService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../ItemCat/itemCat/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../ItemCat/itemCat/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../ItemCat/itemCat/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../ItemCat/itemCat/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../ItemCat/itemCat/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../ItemCat/itemCat/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../ItemCat/itemCat/search?page='+page+"&rows="+rows, searchEntity);
	}

	//根据上级ID查询下级列表
	this.findByParentId=function(parentId,page,rows){
		return $http.get('../ItemCat/itemCat/findByParentId?parentId='+parentId+"&page="+page+"&rows="+rows);
	}
	this.getTypeTemplateData=function () {
		return $http.get('../TypeTemplate/typeTemplate/TypeTemplateData');
	}
});
