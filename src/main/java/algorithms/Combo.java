package algorithms;

import java.util.List;
import java.util.logging.Logger;
import app.ValidPhone;

import java.util.ArrayList;

public class Combo {
	
	
	static Logger logger = Logger
			.getLogger(Combo.class.getName());
	
	
	ValidPhone vp = new ValidPhone();

    public static List<String[]> combine(String[][] matrix) {
        int [] sizeArray= new int[matrix.length];
        int [] counterArray = new int[matrix.length];
        int total = 1;
        for (int i = 0; i < matrix.length; ++i) {
            sizeArray[i] = matrix[i].length;
            total *= matrix[i].length;
        }
        List<String[]> list = new ArrayList<>(total);
        StringBuilder sb;

        for (int count = total; count > 0; --count) {
            sb = new StringBuilder();
            for (int i = 0; i < matrix.length; ++i) {
                sb.append(matrix[i][counterArray[i]]);
            }
            String [] tmpi = new String[sb.toString().length()];
            for (int tmp = 0; tmp < sb.toString().length(); tmp++) {
                tmpi[tmp] = "" + sb.toString().toCharArray()[tmp];
            }
            list.add(tmpi);
            for (int incIndex = matrix.length - 1; incIndex >= 0; --incIndex) {
                if (counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                    ++counterArray[incIndex];
                    break;
                }
                counterArray[incIndex] = 0;
            }
        }
        return list;
    }

    public void comboStart(String[][] matrix) {

        System.out.println("All Number Combinations are:");
        ArrayList <String> valid = new ArrayList<>();
        // outer loop
        for (String[] num : (combine(matrix))) {
            StringBuilder oneNum = new StringBuilder();
            // inner micro loop
            for (String s : num) {
                oneNum.append(s);
            }
            System.out.println(oneNum);
            if(vp.check(new String(oneNum))){
            valid.add(new String(oneNum));
            }
        }
        System.out.println("The valid combinations are:");
        for (String st : valid) {
            System.out.println(st);
        }
    }
}
