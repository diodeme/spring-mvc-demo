package com.diode.mvc.pojo;

/**
 * @author unlikeha@163.com
 * @date 2020/5/20
 */
public class Product {
    private int productId;
    private float productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productPrice=" + productPrice +
                '}';
    }
}
