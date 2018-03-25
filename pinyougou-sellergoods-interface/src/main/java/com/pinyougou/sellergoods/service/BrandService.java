package com.pinyougou.sellergoods.service;

import entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    List<TbBrand> findAll();
    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);
    void add(TbBrand tbBrand);
    TbBrand findOne(Long id);
    void update(TbBrand tbBrand);
    void deleteByIds(Long[] ids);
    PageResult search(TbBrand tbBrand,int pageNum, int pageSize);
}
