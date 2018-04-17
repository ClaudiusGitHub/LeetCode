package JD.question1;


import java.util.Scanner;

public class Main {
    private static int[] record;
    private static final int constant = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        record = new int[num + 1];
        compute(num);
    }

    public static void compute(int n) {
        //1个的时候
        int sum = (int) Math.pow(n, 2) % constant;
        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (record[i] == 0) {
                record[i] = 1;
                for (int j = 2, temp = (int) Math.pow(i, 2); temp < n; j++) {
                    record[temp] = j - 1;
                    temp = (int) Math.pow(i, j);
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(i + " :" + record[i]);
//        }
        //从底数为2开始
        for (int i = 2; i <= n; i++) {
            //该底数可以化简为的次方数
            int temp = record[i];
            //temp是化简为多少次方
            for (int j = 1; j <= n; j++) {
                System.out.println("sum" + sum);
                sum += (computeTimes((int) Math.pow(i, 1.0 / temp), temp * j, n) % constant);
                sum %= constant;
            }
        }
        System.out.println(sum);
    }

    /**
     * @param num1 底数是多少
     * @param num2 指数的总个数
     * @param n    总数
     * @return
     */
    public static int computeTimes(int num1, int num2, int n) {
        int sum = 0;
        int stop = (int) Math.sqrt(num2);
        for (int i = 1; i <= num2; i++) {
            if (Math.pow(num1, i) > n)
                break;
            if (num2 % i == 0)
                sum++;
        }
        System.out.println(num1 + " " + num2 + " " + sum);
        return sum;
    }
}
