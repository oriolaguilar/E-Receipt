package Pharmacy;

import Data.Exceptions.ProductIDException;
import Data.Exceptions.WrongCodeException;
import Pharmacy.Exceptions.InsuficientExistence;
import Pharmacy.Exceptions.QuantityMinorThanImport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.SalesHistory;
import services.Warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class CashPaymentTest {

    private static class WarehouseDouble implements Warehouse{
        private List<ProductSaleLine> list;

        public WarehouseDouble() throws ProductIDException, WrongCodeException {
        }

        @Override
        public void updateStock(List<ProductSaleLine> listofProducts) {
            for (ProductSaleLine i: listofProducts){
                list.add(i);
            }
        }

    }

    private static class SalesHistoryDouble implements SalesHistory{
        public List<Sale> saleList=new ArrayList<>();

        public SalesHistoryDouble() throws ProductIDException {
        }

        public void registerSale(Sale sale){
            saleList.add(sale);
        }

    }

    private Warehouse warehouse;
    private SalesHistory salesHistory;
    private CashPayment cashPayment;

    @BeforeEach
    void setUp() throws ProductIDException, WrongCodeException {
    }

    @Test
    void realizePayment() throws InsuficientExistence, QuantityMinorThanImport {
        BigDecimal price = new BigDecimal(20);
        BigDecimal quantity = new BigDecimal(30);
        cashPayment.realizePayment(price,quantity);

    }
}