package farmacy;

import Data.Interfaces.ProductIDInter;
import Data.ProductID;
import Data.HealthCardID;
import Data.PatientContr;
import services.NationalHealthService;

import java.util.Date;
import java.util.List;

public class Dispensing implements NationalHealthService {

    private byte nOrder;

    private Date initDate, finalDate;

    private boolean isCompleted;

    public Dispensing(){

    }

    public boolean dispensingEnabled(){return true;
    }

    public void setProductAsDispensed(ProductID productID){}

    public void setCompleted(){}
    @Override
    public Dispensing getePrescription(HealthCardID hcID) {
        return null;
    }

    @Override
    public PatientContr getPatientCont(HealthCardID hcID) {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductIDInter pID) {
        return null;
    }


    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) {
        return null;
    }
}
