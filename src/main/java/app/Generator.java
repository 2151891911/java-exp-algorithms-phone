package app;

import java.util.ArrayList;
import java.util.Scanner;

import algorithms.Combo;

import java.util.Arrays;
import java.util.List;

public class Generator {
	
	Combo com = new Combo();

    // check if there are zeros if false we go to method that demands no zeros
    private static boolean noZeros(String micro) {
        int counter = 0;
        for (int i = 0; i < micro.length(); i++) {
            if (micro.charAt(i) == '0') {
                counter++;
            }
        }
        if (counter > 0) {
            return false;
        } else
            return true;
    }

    // 000, 00, 0, 001, 100 cases
    private boolean onlyOne(String micro) {
        int counter = 0;
        for (int i = 0; i < micro.length(); i++) {
            if (micro.charAt(i) == '0') {
                counter++;
            }
        }
        if (counter > 1) {
            return false;
        } else if (micro.length() == 1 && micro.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    // generate options method
    public List<String> generateCombos(String micro) {
        ArrayList<String> all = new ArrayList<>();
        all.add(micro);
        if (noZeros(micro)==false) {
            all.add(Ambig.delZeros(micro));
        } else if (noZeros(micro)) {
            all.addAll(Ambig.allNum(micro));
        } else if (onlyOne(micro)) {
            all.addAll(Ambig.oneZero(micro));
        }
        return all;
    }

    // method to force user input three chars
    public boolean inputCheck(String str) {
        if (str.length() > 30) {
            System.out.println("Input too long. Try again.");
            return false;
        } else if (str.length() < 6) {
            System.out.println("Input too short. Try again.");
            return false;
        } else if (str.matches("(([0-9](\\s|$)|[0-9][0-9](\\s|$)|[0-9][0-9][0-9](\\s|$))+)+")) {
            return true;
        } else {
            System.out.println("Wrong input. Try again.");
            return false;
        }
    }

    // the main user input method
    public void userInput() {
        Scanner sc = new Scanner(System.in);
        boolean b = false;
        String input = "";
        while (!b) {
            System.out.println("Please input your phone number, or press 'e' to exit.");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("e")) {
                sc.close();
                return;
            }
            b = inputCheck(input);
        }
        sc.close();
        List<String> inputList = Arrays.asList(input.split("\\s"));
        ArrayList<ArrayList<String>> genComb = new ArrayList<>();
        for (String s : inputList) {
            genComb.add((ArrayList<String>) generateCombos(s));
            System.out.println(s);
        }
        String[][] matrix = new String[genComb.size()][];
        for (int i = 0; i < genComb.size(); i++) {
            ArrayList<String> row = genComb.get(i);
            matrix[i] = row.toArray(new String[row.size()]);
        }
        com.comboStart(matrix);
    }
}