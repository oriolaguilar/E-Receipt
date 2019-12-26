package farmacy;

import data.PatientContr;
import data.ProductID;
import data.PatientContr;
import java.math.BigDecimal;

public class ProductSaleLine {

    private ProductID productID;

    private BigDecimal price;

    private PatientContr contr;


    public ProductSaleLine(ProductID productID, BigDecimal price, PatientContr contr){
        this.productID = productID;
        this.price= price;
        this.contr= contr;
    }
    public ProductSaleLine(ProductID productID){
        this.productID=productID;
    }

    public void setProductID(ProductID productID) {
        this.productID = productID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PatientContr getContr() {
        return contr;
    }

    public void setContr(PatientContr contr) {
        this.contr = contr;
    }
}
