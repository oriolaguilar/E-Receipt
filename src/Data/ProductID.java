package Data;

import Data.Exceptions.WrongCodeException;
import Data.Interfaces.ProductIDInter;

final public class ProductID implements ProductIDInter {

    private final String UPC;

    public ProductID(String code) throws WrongCodeException {
        if (code == null || !correctCode(code))
            throw new WrongCodeException("Wrong UPC code.");

        this.UPC = code;
    }

    private boolean correctCode(String code){
        boolean length = code.length() == 10;
        boolean allNumbers = true;
        for (int i = 0; i < code.length(); i++){
            if (!Character.isDigit(code.charAt(i)))
                allNumbers = false;
        }

        return length && allNumbers;
    }

    @Override
    public String getUPC() {
        return UPC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID prodID = (ProductID) o;
        return this.UPC.equals(prodID.UPC);
    }
    @Override
    public int hashCode() {
        return UPC.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" + "Universal Product Code ='" + UPC + '\'' + '}';
    }

}
