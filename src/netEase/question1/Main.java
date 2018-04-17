package netEase.question1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 相邻数4的倍数
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums; i++) {
            int numi = in.nextInt();
            LinkedList<Integer> help = new LinkedList<>();
            for (int j = 0; j < numi; j++) {
                help.add(in.nextInt());
            }
            list.add(help);
        }
        for (int i = 0; i < nums; i++) {
            int four = 0;
            int notFour = 0;
            int two = 0;
            for (int num : list.get(i)) {
                if (num % 4 == 0) {
                    four++;
                } else if (num % 2 == 0) {
                    two++;
                } else {
                    notFour++;
                }
            }
            if (two > 0) {
                if (notFour - four <= 0)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            } else {
                if (notFour - four <= 1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

    }
}
