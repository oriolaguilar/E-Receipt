package Data;

import Data.Exceptions.ProductIDException;


final public class ProductID{

    private final String UPC;

    public ProductID(String code) throws ProductIDException {
        if (code == null || !correctCode(code))
            throw new ProductIDException("Wrong UPC code.");

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
