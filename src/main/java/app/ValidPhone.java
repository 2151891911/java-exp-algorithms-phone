package app;

public class ValidPhone {

    // phone code checker
    public boolean check(String phone) {
        String homep = phone.substring(0, 3);
        String mobile = phone.substring(0, 6);
        if (homep.equals("210") && phone.length() == 10) {
            return true;
        } else if (mobile.equals("003069") && phone.length() == 14) {
            return true;
        } else
        	return false;
    }

}