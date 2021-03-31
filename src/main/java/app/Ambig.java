package app;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Ambig {
	
	// here we create a logger to log on events
	static Logger logger = Logger
					.getLogger(Ambig.class.getName());

    // helper methods to add appropriate zero character(s)
    private static String once(String micro, int idx) {
        StringBuilder str = new StringBuilder(micro);
        return new String(str.insert(idx, '0'));
    }

    private static String twice(String micro, int idx) {
        char[] zero = { '0', '0' };
        StringBuilder str = new StringBuilder(micro);
        return new String(str.insert(idx, zero));
    }

    // limit this by not having a zero
    public static List<String> allNum(String micro) {
        List<String> opt = new ArrayList<>();
        switch (micro.length()) {
            case 1:
                opt.add(new String(once(micro, 1)));// 1-> 10
                opt.add(new String(twice(micro, 1)));// 1->100
                break;
            case 2:
                opt.add(new String(once(micro, 1)));// 12->102
                opt.add(new String(once(micro, 2)));// 12->120
                opt.add(new String(twice(micro, 1)));// 12 -> 1002
                break;
            case 3:
                opt.add(new String(once(micro, 2)));// 123->1203
                opt.add(new String(twice(micro, 1)));// 123->10023
                break;
            default: logger.log(Level.INFO, "No case recorded");
        }
        return opt;
    }

    // only one zero present
    public static List<String> oneZero(String micro) {
        List<String> opt = new ArrayList<>();
        if (micro.charAt(micro.length() - 1) == '0' && micro.length() == 3) {
            opt.add(new String(twice(micro, 1)));// 120->10020
        } else {
            opt.add(new String(once(micro, 2)));// 102->1002, 012 -> 0102, 01 -> 010, 10->100
        }
        return opt;
    }

    //restrict all zeros
    public static String delZeros(String micro) {
        StringBuilder sb = new StringBuilder(micro);
        for (int i = 0; i < micro.length(); i++) {
            if (micro.charAt(i)=='0'){
                sb.deleteCharAt(i);                
            }
        }
        return new String(sb);
    }
    
    
    private Ambig() {}
}