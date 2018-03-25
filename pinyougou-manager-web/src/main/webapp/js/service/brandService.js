//品牌服务层
app.service('brandService',function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../brand/findAll.do');
    }
    //分页
    this.findPage=function(page,rows){
        return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    }
    this.save=function (entity) {
        var methodName="";
        if(entity.id!=null&&entity.id!=undefined){
            methodName="update";
        }else{
            methodName="add";
        }
        return $http.post("/brand/"+methodName+".do", entity);
    }
    this.findOne=function (id) {
       return  $http.get("/brand/findOne.do?id="+id);
    }
    this.del=function (ids) {
        return $http.get("/brand/deleteByIds.do?ids="+ids)
    }
    this.search=function (page,rows,entity) {
       return  $http.post("/brand/search.do?page="+page+"&rows="+rows,entity);
    }
});