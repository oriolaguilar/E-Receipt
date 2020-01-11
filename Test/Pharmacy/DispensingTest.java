package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.ProductID;
import Pharmacy.Exceptions.DispensingNotAvailableException;
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
    public void setUp() throws ProductIDException {
        medicinePrescription  = new MedicineDispensingLine
                (new ProductID("1010101010"), "Prendre cada 8 hores");
        medicinePrescription2 = new MedicineDispensingLine(
                new ProductID("1234567890"),"Prendre cada 3 dies");

        List<MedicineDispensingLine> prescription = new ArrayList<>();
        prescription.add(medicinePrescription);
        prescription.add(medicinePrescription2);

        dispensation = new Dispensing(nOrder, new Date(110, 10, 1), new Date(1578555847876L), prescription);
    }


    @Test
    public void dispensingEnabledTest() throws DispensingNotAvailableException {
        assertTrue(dispensation.dispensingEnabled());
    }

    @Test
    public void setProductAsDispensedTest() throws ProductIDException {
        dispensation.setProductAsDispensed(new ProductID("1010101010"));
        assertTrue(medicinePrescription.getAcquired());
    }

    @Test
    public void setCompletedTest() throws ProductIDException {
        dispensation.setCompleted();
        assertFalse(dispensation.getIsCompleted());
        dispensation.setProductAsDispensed(new ProductID("1234567890"));
        dispensation.setProductAsDispensed(new ProductID("1010101010"));
        dispensation.setCompleted();
        assertTrue(dispensation.getIsCompleted());
    }
}
