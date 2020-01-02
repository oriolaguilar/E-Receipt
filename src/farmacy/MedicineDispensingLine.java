package farmacy;

import Data.Interfaces.ProductIDInter;
import Data.ProductID;

public class MedicineDispensingLine {

    private ProductIDInter medicine;
    private boolean isAdquired;
    private String description;

    public MedicineDispensingLine(ProductIDInter medicine, String descrition){
        this.medicine = medicine;
        this.description = descrition;
        isAdquired = false;
    }

    public ProductIDInter getMedicine() {
        return medicine;
    }
    public boolean getAdquired(){
        return isAdquired;
    }
    public void setAdquired(boolean adquired) {
        isAdquired = adquired;
    }
}
