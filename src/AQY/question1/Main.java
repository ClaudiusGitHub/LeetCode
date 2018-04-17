package AQY.question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length();
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '(') {
                temp++;
                sum = temp > sum ? temp : sum;
            } else {
                temp--;
            }
        }
        System.out.println(sum);
    }
}
