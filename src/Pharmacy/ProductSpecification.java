package Pharmacy;

import Data.ProductID;

import java.math.BigDecimal;


public class ProductSpecification {

    private ProductID productID;
    private String description;
    private BigDecimal price;


    public ProductSpecification(ProductID productID, String description, BigDecimal price){
        this.productID = productID;
        this.description = description;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}