package A13;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import A12.Ask2;

public class Ask3 {

    public static void main(String[] args) {
        //--------------------------------------------------------
        // Starting the timer at the very beginning of the program.
        long start = System.currentTimeMillis();
        //--------------------------------------------------------

        int wordCtr = 0;
        int letterCtr = 0;
        int palindromicCtr = 0;

        try {
            FileInputStream fis= new FileInputStream("Resources/gr.dic"); //file to be scanned
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()) {
                //System.out.println(sc.nextLine());
                String tmpS = sc.nextLine();
                wordCtr++;
                letterCtr += numLetters(tmpS);
                if (Ask2.isPalindromikiFrash(tmpS)) {
                    System.out.println(tmpS);
                    palindromicCtr++;
                }
            }
            sc.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        //---------------------------------------
        //beep.
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|It took me " + sec + " seconds to get your results.                       |");
        //---------------------------------------

        printResults(wordCtr, letterCtr, palindromicCtr);
    }




    private static int numLetters(String s) {
        int letters = 0;
        for (int i = 0; i < s.length(); i++) {
            letters++;
        }
        return letters;
    }

    private static void printResults(int words, int letters, int palindromicWords) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|The total number of words: " + words + ".                                  |");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|The average size of a word: " + (float) letters/words + " letters.                      |");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|The total number of palindromic words: " + palindromicWords + ".                          |");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|The percentage of palindromic words in the dictionary: " + ((float) palindromicWords / words) * 100 + "%.|");
        System.out.println("----------------------------------------------------------------------");
    }
}