package A11;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.PrintWriter;
import java.util.Scanner;

class DrawE {
    static void checkParam(String a, int b) {
        if (a.equals("") || 0 == b) {
            throw new RuntimeException("Wrong Components");
        }
    }

    static void checkValues(String a, int b) {
        if (!a.equals("c") && !a.equals("w") && !a.equals("f") && !a.equals("g")) {
            throw new RuntimeException("Invalid value for mode.");
        }
        if (b < 5 || b > 20) {
            throw new RuntimeException("Value for length out of bounds.");
        }
    }

    static String formString(int L) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < L; i++) {
            if (i == 0 || i == L / 2 || i == L - 1) {
                for (int k = 0; k < L; k++) {
                    str.append("*");
                }
            } else {
                str.append("*");
            }
            str.append("\n");
        }
        return str.toString();
    }

    static void drawOnConsole(int L) {
        System.out.println(formString(L));
    }

    static void drawOnWindow(int L) {
        JOptionPane.showMessageDialog(null, formString(L), "Window ",JOptionPane.INFORMATION_MESSAGE);
    }

    static void drawInFile(int L) {
        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\temp\\E.html", "UTF-8");
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>");
            writer.println("</head>");
            writer.println("<body><font size=\"" + L + "\">E with font size =" + L +"</font></body>");
            writer.println("</html>");
            writer.close();
        } catch (Exception e) {
            System.out.println("Problem: " + e);
        }
    }

    static void drawGraphics(int L) {
        JFrame f = new JFrame("Painting the letter E") {
            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                Line2D line1 = new Line2D.Double(50, 50, 50, 200 + 10*L);
                Line2D line2 = new Line2D.Double(50, 50, 100 + L, 50);
                Line2D line3 = new Line2D.Double(50, (line1.getY1() + line1.getY2()) / 2, 100 + L, (line1.getY1() + line1.getY2()) / 2);
                Line2D line4 = new Line2D.Double(50, line1.getY2(), 100 + L, line1.getY2());

                g2.draw(line1);// a line
                g2.draw(line2);// another line
                g2.draw(line3);// a third line
                g2.draw(line4);// the last line
            }
        };
        f.setVisible(true);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }





    public static void main(String[] args) {


        //Checking for the validity of the parameters
        checkParam(args[0], Integer.parseInt(args[1]));

        //Checking for the values of the parameters
        checkValues(args[0], Integer.parseInt(args[1]));

        String M = args[0];
        int L = Integer.parseInt(args[1]);

        //variables that will help me on the recursion
        String[] parameters = new String[2];
        String Ans;

        do {
            //Modes
            switch (M) {
                case "c":
                    drawOnConsole(L);
                    break;
                case "w":
                    drawOnWindow(L);
                    break;
                case "f":
                    drawInFile(L);
                    break;
                case "g":
                    drawGraphics(L);
                    break;
            }

            if (L > 5) {
               parameters[0] = M;
               L--;
               parameters[1] = String.valueOf(L);
               main(parameters);
            }

            if (M.equals("w")) {
                Ans = JOptionPane.showInputDialog("Give me a number ", 4);
                if (Ans == null || Ans.equals(" ")) {
                    System.exit(0);
                }
                L = Integer.parseInt(Ans);
            } else {
                Scanner scr = new Scanner(System.in);
                System.out.println("Give me a new number ");
                L = scr.nextInt();
            }
        } while (L >= 5 && L <= 20);
    }
}