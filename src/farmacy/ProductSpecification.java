package farmacy;

import Data.Interfaces.ProductIDInter;


public class ProductSpecification {

    private ProductIDInter productID;

    private String description;

    private int price;


    public ProductSpecification(ProductIDInter productID, String description, int price){
        this.productID= productID;
        this.description = description;
        this.price=price;
    }
    public ProductSpecification(ProductIDInter productID){
        this.productID= productID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }


}
