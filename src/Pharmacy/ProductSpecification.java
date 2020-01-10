package farmacy;

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
    public ProductSpecification(ProductID productID){
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