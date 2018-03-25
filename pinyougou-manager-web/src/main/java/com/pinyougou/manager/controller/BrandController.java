package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("findAll")
    public  List<TbBrand> findAll(){
        return brandService.findAll();
    }
    @RequestMapping("/findPage")
    public PageResult findByPage(int page,int rows){
        return brandService.findPage(page, rows);
    }
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand){
        try {
            brandService.add(tbBrand);
            return new Result(true,"新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
        TbBrand tbBrand = brandService.findOne(id);
        return tbBrand;
    }
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
    @RequestMapping("/deleteByIds")
    public Result deleteByIds(Long[] ids){
        try {
            brandService.deleteByIds(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page,int rows){
        return brandService.search(tbBrand, page, rows);
    }

}
