package codeforces;
import java.util.*;

public class CirnosPerfectBitmasksClassroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            if (x == 1) {
                System.out.println(3);
            } else if ((x & (x - 1)) == 0) {
                System.out.println(x + 1);
            } else {
                System.out.println(x & -x);
            }
        }
        sc.close();
    }
}
