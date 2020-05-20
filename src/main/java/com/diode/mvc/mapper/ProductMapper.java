package com.diode.mvc.mapper;

import com.diode.mvc.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author unlikeha@163.com
 * @date 2020/5/19
 */
@Component
public interface ProductMapper {
    /**
     * 根据ID获取单个对象
     * @param productId 主键
     * @return resultType
     */
    Product selectOne(@Param("productId") int productId);

    /**
     * 根据ID删除单个对象
     * @param productId 主键
     * @return 受影响的条数
     */
    int deleteOne(@Param("productId") int productId);

    //TODO 删除多个
    /**
     * 根据ID删除多个对象
     * @param productId 主键
     * @return 受影响的条数
     */
    int deletlist(@Param("productId") int productId);

    /**
     * 根据ID修改单个对象
     * @param productId 主键
     * @param productPrice 商品价格
     * @return 受影响的条数
     */
    int updateOne(@Param("productId") int productId,@Param("productPrice") float productPrice);

    /**
     * 增加单个对象
     * @param product 商品
     * @return 受影响的条数
     */
    int insertOne(Product product);
}
