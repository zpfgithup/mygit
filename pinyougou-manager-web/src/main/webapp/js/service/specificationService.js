//规格服务层
app.service('specificationService',function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../specification/findAll.do');
    }
    //分页
    this.findPage=function(page,rows){
        return $http.get('../specification/findPage.do?page='+page+'&rows='+rows);
    }
    this.save=function (entity) {
        var methodName="";
        if(entity.id!=null&&entity.id!=undefined){
            methodName="update";
        }else{
            methodName="add";
        }
        return $http.post("/specification/"+methodName+".do", entity);
    }
    this.findOne=function (id) {
        return  $http.get("/specification/findOne.do?id="+id);
    }
    this.del=function (ids) {
        return $http.get("/specification/deleteByIds.do?ids="+ids)
    }
    this.search=function (page,rows,entity) {
        return  $http.post("/specification/search.do?page="+page+"&rows="+rows,entity);
    }
});