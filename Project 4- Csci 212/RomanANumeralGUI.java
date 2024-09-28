import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class RomanANumeralGUI extends JFrame {//class for the GUI

    public RomanANumeralGUI() {//constructor for the GUI
        super("Roman Numerals to Arabic");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new GridLayout(1, 2));
        // Create the content pane
        

        // Create the text areas
        TextArea romanTextArea = new TextArea("Roman Numerals: " + "\n"); // Text area show roman values
        TextArea arabicTextArea = new TextArea("Arabic Numerals: " + "\n");// 
        Container contentPane = getContentPane();
        // Read the input file
        String inputFilePath = "C:\\Users\\jamja\\Desktop\\P4 TESTING\\input3.txt";
        ArrayList<String> romanNumerals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] romanNumArray = line.split(",");
                for (String romanNum : romanNumArray) {
                    romanNumerals.add(romanNum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        romanTextArea.setEditable(false);
        arabicTextArea.setEditable(false);
        // Sort the Roman numerals using a TreeMap
        TreeMap<String, Integer> sortedRomanNumerals = new TreeMap<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return valueOf(s1) - valueOf(s2);
            }
        });
        for (String romanNum : romanNumerals) {
            sortedRomanNumerals.put(romanNum, valueOf(romanNum));
        }

        // Add the sorted Roman numerals and their Arabic values to the text areas
        for (String romanNum : sortedRomanNumerals.keySet()) {
            romanTextArea.append(romanNum + "\n");
            arabicTextArea.append(sortedRomanNumerals.get(romanNum) + "\n");
        }

        // Add the text areas to the content pane
        JScrollPane scroll1 = new JScrollPane(romanTextArea);
        JScrollPane scroll2 = new JScrollPane(arabicTextArea);
        contentPane.add(scroll1);
        contentPane.add(scroll2);

        // Set the content pane and show the window
        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    
    /** 
     * @param romanNumeral
     * @return int
     */
    public static int valueOf(String romanNumeral) {
        HashMap<Character, Integer> romanToArabic = new HashMap<>();//hashmap for the roman numerals
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);

        int arabicValue = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {//for loop to go through the roman numerals
            char currentChar = romanNumeral.charAt(i);

            if (i < romanNumeral.length() - 1 && romanToArabic.get(currentChar) < romanToArabic.get(romanNumeral.charAt(i + 1))) {
                arabicValue -= romanToArabic.get(currentChar);
            } else {
                arabicValue += romanToArabic.get(currentChar);
            }
        }

        return arabicValue;
    }
}
