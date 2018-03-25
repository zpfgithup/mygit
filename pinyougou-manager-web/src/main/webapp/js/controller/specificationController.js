app.controller('specificationController', function ($scope,$controller,specificationService) {

    $controller('baseController', {$scope: $scope})

    //读取列表数据绑定到表单中
    $scope.findAll = function () {
        specificationService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }
    $scope.save=function(){
        var serviceObject;//服务层对象
        specificationService.save($scope.entity).success(
            function(response){
                if(response.success){
                    alert(response.message);
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }
    $scope.searchEntity = {};//定义搜索对象
    //条件查询
    $scope.search = function (page, rows) {
        specificationService.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }
    //新增选项行
    $scope.addTableRow=function(){
        $scope.entity.specificationOptionList.push({});
    }
    //批量选项删除
    $scope.deleTableRow=function(index){
        $scope.entity.specificationOptionList.splice(index,1);//删除
    }
    $scope.findOne = function (id) {
        specificationService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }
})