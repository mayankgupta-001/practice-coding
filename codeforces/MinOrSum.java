package codeforces;
import java.util.*;

public class MinOrSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
        
            for (int i = 0; i < n; i++) {
                ans |= sc.nextInt();
            }
        
            System.out.println(ans);
        }
        sc.close();
    }
}