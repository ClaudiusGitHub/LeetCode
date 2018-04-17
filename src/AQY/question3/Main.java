package AQY.question3;

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
        int[] record = new int[num1 + 1];
        record[1] = 1;
        for (int i = 2; i <= num1; i++) {
            if (record[i] == 0) {
                record[i] = i;
                int temp = i * i;
                while (temp <= num1) {
                    record[temp] = 1;
                    //奇数个
                    temp = temp * i;
                    if (temp <= num1) {
                        record[temp] = i;
                    } else {
                        break;

                    }
                    temp = temp * i;
                }
            }
        }
        int sum = 0;
        int tsum = (int) Math.sqrt(num2);
        for (int i = 1; i <= num1; i++) {
            if (record[i] == 1) {
                sum += tsum;
            } else {
                sum += (int) Math.sqrt(num2 / record[i]);
            }
        }
        System.out.println(sum);
        for (int i = 0; i < num1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < num1; i++) {
            System.out.print(record[i] + " ");
        }
    }
}
