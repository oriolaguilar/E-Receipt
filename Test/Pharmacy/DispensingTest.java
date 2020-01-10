package farmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Data.ProductID;
import farmacy.Exceptions.DispensingNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    Dispensing dispensation;
    MedicineDispensingLine medicinePrescription;
    MedicineDispensingLine medicinePrescription2;


    byte nOrder = 5;

    @BeforeEach
    public void setUp() throws WrongCodeException, ProductIDException {
        medicinePrescription  = new MedicineDispensingLine
                (new ProductID("1010101010"), "Prendre cada 8 hores");
        medicinePrescription2 = new MedicineDispensingLine(
                new ProductID("1234567890"),"Prendre cada 3 dies");

        List<MedicineDispensingLine> prescription = new ArrayList<>();
        prescription.add(medicinePrescription);
        prescription.add(medicinePrescription2);

        dispensation = new Dispensing(nOrder, new Date(120, 10, 1), new Date(1578555847876L), prescription);
    }


    @Test
    public void dispensingEnabledTest() throws DispensingNotAvailableException {
        assertTrue(dispensation.dispensingEnabled());
    }

    @Test
    public void setProductAsDispensedTest() throws WrongCodeException, ProductIDException {
        dispensation.setProductAsDispensed(new ProductID("1010101010"));
        assertTrue(medicinePrescription.getAcquired());
    }

    @Test
    public void setCompletedTest(){
        dispensation.setCompleted();
        assertTrue(medicinePrescription.getAcquired());
        assertTrue(medicinePrescription2.getAcquired());
    }
}
