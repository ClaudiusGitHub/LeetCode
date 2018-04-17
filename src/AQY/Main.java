package AQY;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int sum = 0;
        int mostSum = (int) Math.sqrt(num2);
        for (int i = 1; i <= num1; ++i) {
            double a = Math.sqrt(i);
            if (a == (int) a) {
                sum += mostSum;
            } else {
                int temp = i;
                int midddle = (int) Math.sqrt(temp);
                for (int j = 2; j <= midddle; ++j) {
                    while (temp % (j * j) == 0) {
                        temp /= (j * j);
                    }
                }
                sum += (int) Math.sqrt(num2 / temp);
            }
        }
        System.out.println(sum);
    }
}
