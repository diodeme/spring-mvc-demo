package com.diode.mvc.service;

import com.diode.mvc.mapper.ProductMapper;
import com.diode.mvc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author unlikeha@163.com
 * @date 2020/5/20
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 根据ID获取单个对象
     * @param productId 主键ID
     * @return 获取到对象返回对象，否则返回null
     */
    public Product selectOne(int productId){
        Product product=productMapper.selectOne(productId);
        return product;
    }

    /**
     * 根据ID删除某一行
     * @param productId 主键ID
     * @return 影响行数或-1
     */
    public int deleteOne(int productId){
        try{
            return productMapper.deleteOne(productId);
        }catch (Exception e )
        {
            return -1;
        }
    }

    /**
     * 根据ID更新某一行
     * @param productId 主键ID
     * @param productPrice 商品价格
     * @return 返回影响条数或-1
     */
    public int updateOne(int productId,float productPrice){
        try{
            return productMapper.updateOne(productId,productPrice);
        }catch (Exception e )
        {
            return -1;
        }
    }

    /**
     * 新增某一行
     * @param product 商品价格
     * @return 返回影响条数或-1
     */
    public int insertOne(Product product){
        try{
            return productMapper.insertOne(product);
        }catch (Exception e )
        {
            return -1;
        }
    }
}
