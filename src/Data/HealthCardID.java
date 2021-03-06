package Data;

import Data.Exceptions.HealthCardException;

final public class HealthCardID{

    private final String personalID;

    public HealthCardID(String code) throws HealthCardException {
        if (code == null || !correctCode(code))
            throw new HealthCardException("Wrong code, check the restrictions!");

        this. personalID = code;
    }

    private boolean correctCode(String code){
        boolean length = code.length() == 14;
        boolean prefix = true;

        for(int i = 0; i < 4; i++){
            if (!Character.isLetter(code.charAt(i))) prefix = false;
        }

        return length && prefix;
    }


    public String getPersonalID() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }
    @Override
    public int hashCode() {
        return personalID.hashCode();
    }

    @Override
    public String toString() {
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';
    }

}