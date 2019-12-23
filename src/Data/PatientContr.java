package data;

import java.math.BigDecimal;

final public class PatientContr {

    private BigDecimal contribution;

    public PatientContr (BigDecimal contr) throws WrongCodeException {

        if (contr == null) throw new WrongCodeException();
        this.contribution = contr;
    }

    public BigDecimal getContribution() {
        return contribution;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContr patCont = (PatientContr) o;
        return contribution.equals(patCont.contribution);

    }
}
