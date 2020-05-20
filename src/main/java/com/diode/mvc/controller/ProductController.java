package com.diode.mvc.controller;

import com.diode.mvc.pojo.Product;
import com.diode.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author unlikeha@163.com
 * @date 2020/5/20
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("")
    public String selectOne(@RequestParam("productId") int productId){
        Product product=productService.selectOne(productId);
        if(null==product){
            return "未找到该商品";
        }else {
            return product.toString();
        }
    }

    @DeleteMapping
    public String deleteOne(@RequestParam("productId") int productId){
        int result=productService.deleteOne(productId);
        if(result!=-1&&result!=0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    //todo 得到返回的主键
    @PostMapping
    public String insertOne(@RequestParam("productPrice") float productPrice){
        Product product=new Product();
        product.setProductPrice(productPrice);
        if(productService.insertOne(product)!=-1){
            return "增加成功";
        }else {
            return "增加失败";
        }
    }

    @PutMapping
    public String updateOne(@RequestParam("productId") int productId,@RequestParam("productPrice") float productPrice){
        int result=productService.updateOne(productId,productPrice);
        if(result!=-1&&result!=0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
