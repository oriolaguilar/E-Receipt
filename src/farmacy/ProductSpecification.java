package farmacy;

import Data.Interfaces.ProductIDInter;

import java.math.BigDecimal;


public class ProductSpecification {

    private ProductIDInter productID;

    private String description;

    private BigDecimal price;


    public ProductSpecification(ProductIDInter productID, String description, BigDecimal price){
        this.productID = productID;
        this.description = description;
        this.price = price;
    }
    public ProductSpecification(ProductIDInter productID){
        this.productID= productID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }


}