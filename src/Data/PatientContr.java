package Data;

import Data.Exceptions.WrongCodeException;

import java.math.BigDecimal;

final public class PatientContr {

    private BigDecimal contribution;

    public PatientContr (BigDecimal contr) throws WrongCodeException {

        if (contr == null || !correctContr(contr))
            throw new WrongCodeException("Wrong number. Must be a number lower than 1.00");
        this.contribution = contr;
    }

    private boolean correctContr(BigDecimal contr){
        return contr.floatValue() < 1.000;
    }

    
    public BigDecimal getContribution() {
        return contribution;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContr patCont = (PatientContr) o;
        return contribution.equals(patCont.contribution);

    }
    @Override
    public int hashCode(){
        return contribution.hashCode();
    }

    @Override
    public String toString(){
        return "Patient Contribution{ Contribution: "+contribution.toString()+ '\'' + '}';
    }
}
