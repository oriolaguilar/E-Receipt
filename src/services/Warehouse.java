package services;

import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.ProductSaleLine;

import java.util.List;

public interface Warehouse {
    void updateStock(List<ProductSaleLine> listofProducts) throws InsuficientExistence;
}
