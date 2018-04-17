package AQY.question2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strs = string.split(" ");
        int length1 = strs[0].length();
        int length2 = Integer.parseInt(strs[1]);
        int length3 = strs[2].length();
        int length4 = Integer.parseInt(strs[3]);
        int temp1 = length1 * length2;
        int temp2 = length3 * length4;
        if (temp1 > temp2) {
            System.out.println("Greater");
        } else if (temp2 > temp1) {
            System.out.println("Less");
        } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < length2; i++) {
                stringBuilder1.append(strs[0]);
            }
            for (int i = 0; i < length4; i++) {
                stringBuilder2.append(strs[2]);
            }
            int record = stringBuilder1.toString().compareTo(stringBuilder2.toString());
            if (record > 0) {
                System.out.println("Greater");
            } else if (record < 0) {
                System.out.println("Less");
            } else {
                System.out.println("Equal");
            }
        }
    }
}
