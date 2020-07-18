//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../Specification/specification/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../Specification/specification/findPage?findPage='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../Specification/specification/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.put('../Specification/specification/',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../Specification/specification/',entity );
	}
	//删除
	this.dele=function(ids){
		console.log(ids)
		return $http.get('../Specification/specification/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../Specification/specification/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
