package JD.question2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder().append(sc.nextLine());
        System.out.println(getCount(str));
    }

    private static int getCount(StringBuilder str) {
        if (str.length() == 0)
            return 1;
        if (str.charAt(0) == '(')
            str.deleteCharAt(0);
        else
            return 0;
        int count = 0;
        int num = str.length();
        for (int i = 0; i < num; i++) {
            if (str.charAt(i) == ')') {
                str.deleteCharAt(i);
                count += getCount(str);
                str.insert(i, ')');
            }
        }
        str.insert(0, '(');
        return count;
    }
}
