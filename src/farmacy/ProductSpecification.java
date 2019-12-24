package farmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import services.NathionalHealthService;

import java.util.List;


public class ProductSpecification implements NathionalHealthService {

    data.ProductID productID;

    String description;

    int price;


    public ProductSpecification(ProductID productID, String description, int price){
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
    public ProductSpecification getProductSpecific(ProductID productID) {
        return new ProductSpecification(productID,getDescription(),getPrice());
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) {
        return null;
    }

}
