package farmacy;

import Data.Interfaces.ProductIDInter;
import data.HealthCardID;
import Data.PatientContr;
import services.NathionalHealthService;

import java.util.List;


public class ProductSpecification implements NathionalHealthService {

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

    @Override
    public Dispensing getePrescription(HealthCardID hcID) {
        return null;
    }

    @Override
    public PatientContr getPatientCont(HealthCardID hcID) {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductIDInter productID) {
        return new ProductSpecification(productID,getDescription(),getPrice());
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) {
        return null;
    }

}
