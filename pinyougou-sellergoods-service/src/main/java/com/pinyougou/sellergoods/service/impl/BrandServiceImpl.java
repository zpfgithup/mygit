package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(new TbBrandExample());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page) tbBrandMapper.selectByExample(null);
        PageResult result=new PageResult(page.getTotal(),page.getResult());
        return result;
    }

    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult search(TbBrand tbBrand, int pageNum, int pageSize) {
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(tbBrand!=null){
            if(StringUtils.isNotBlank(tbBrand.getName())){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if(StringUtils.isNotBlank(tbBrand.getFirstChar())){
                criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> tbBrands = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return new PageResult(tbBrands.getTotal(),tbBrands.getResult());
    }
}
