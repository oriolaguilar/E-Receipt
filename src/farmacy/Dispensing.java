package farmacy;

import Data.Interfaces.ProductIDInter;
import Data.ProductID;
import Data.HealthCardID;
import Data.PatientContr;
import services.NathionalHealthService;

import java.util.Date;
import java.util.List;

public class Dispensing {

    private byte nOrder;

    private Date initDate, finalDate;

    private boolean isCompleted;

    public Dispensing(){

    }

    public boolean dispensingEnabled(){return true;
    }

    public void setProductAsDispensed(ProductID productID){}

    public void setCompleted(){}

}
