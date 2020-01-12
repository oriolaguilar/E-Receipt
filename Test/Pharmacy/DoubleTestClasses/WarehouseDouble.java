package Pharmacy.DoubleTestClasses;

import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.ProductSaleLine;
import services.Warehouse;

import java.util.List;

public class WarehouseDouble implements Warehouse {
    private int quantity = 3;

    @Override
    public void updateStock(List<ProductSaleLine> listofProducts) throws InsuficientExistence {
        if (quantity < listofProducts.size()){
            throw new InsuficientExistence("No hi ha suficiengs medicaments");
        }
        quantity -= listofProducts.size();
    }
}
