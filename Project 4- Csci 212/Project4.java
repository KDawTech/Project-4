
/*main file
@author
//Name: Kevon Dawkins
//Date: 5/6/2023
//Description: This program will convert Roman Numerals to Arabic Numerals
//hashmaps and treemaps are used to store the values of the roman numerals and arabic numerals
//The program will read in a file that contains a list of Roman Numerals and Arabic Numerals.
//The program will then convert the Roman Numerals to Arabic Numerals then display the results in a GUI.
*/


import java.io.*;
import javax.swing.*;

public class Project4 {
    public static void main(String[] args) { // main method

        String inputFilePath = "input.txt";// file path to input file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) { // try-with-resources statement

            br.readLine();

            String line;// String[] lineArray;

            while ((line = br.readLine()) != null) { // System.out.println(line);

                String[] romanNumerals = line.split(",");// Split the line by commas that are seperated by spaces

                for (String romanNumeral : romanNumerals) {

                    int arabicValue = RomanANumeralGUI.valueOf(romanNumeral);//passes the valueof to the String value

                    System.out.println(romanNumeral + " " + arabicValue);//prints the value //only for testing
                    System.out.println(RomanANumeralGUI.valueOf(romanNumeral));//prints the valueoF of the value thats passed onto to romanNumeral
                }
            }
        } catch (IOException e) { 
            e.printStackTrace();
            System.exit(1);
            return;
            // throw new RuntimeException(e);
            // return;

        }
        RomanANumeralGUI gui = new RomanANumeralGUI(); // new RomanANumeralGUI2();
        gui.setBounds(100, 100, 300, 300);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
