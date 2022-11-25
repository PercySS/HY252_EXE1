package A12;

import java.text.Normalizer;
import java.util.Scanner;

public class Ask2 {
    static void checkPhrase(String s) {
        if (s.equals("")) {
            throw new RuntimeException("Wrong input for phrase, please try again!");
            //Didn't know which way you want me to close the program, so I threw an exception.
            //System.out.println("Wrong input for phrase.");
            //System.exit(0);
        }
    }

    public static boolean isPalindromikiFrash(String s) {
        //Normalizing the phrase.
        String normalS = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        //Rejecting all Unknown characters. (I accept only a-z, A-z, 0-9, α-ω, Α-Ω)
        normalS = normalS.replaceAll("[^a-zA-Z0-9α-ωΑ-Ω]", "");

        //putting σ -> ς
        normalS = normalS.replace('ς', 'σ');

        //Putting phrase to lowercase because java is case-sensitive.
        normalS = normalS.toLowerCase();


        boolean f = true;

        char[] s1 = new char[normalS.length()];
        char[] s2 = new char[normalS.length()];

        for (int i = 0; i < normalS.length(); i++) {
            s1[i] = normalS.charAt(i);
            s2[i] = normalS.charAt(normalS.length() - i - 1);
        }

        for (int i = 0; i < normalS.length(); i++) {
            if (s1[i] != s2[i]) {
                f = false;
                break;
            }
        }

        return f;
    }

    public static void main(String[] args) {
        //Getting the phrase from the user.
        Scanner in = new Scanner(System.in);
        System.out.println("Type in a phrase:");
        String nextLine = in.nextLine();

        //Checking the phrase for null.
        checkPhrase(nextLine);

        //Starting a timer
        long startTime = System.nanoTime();


        if (isPalindromikiFrash(nextLine)) {
            System.out.println("Your phrase can be read both ways.");
        } else {
            System.out.println("Your phrase cannot be read both ways.");
        }
        //beep
        float estimatedTime = (System.nanoTime() - startTime) / 1000000F;
        System.out.println("It took me "+ estimatedTime  + " seconds to get your results.");
    }
}
