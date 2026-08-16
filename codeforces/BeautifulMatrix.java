package codeforces;
import java.util.*;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    row = i;
                    col = j;
                }
            }
        }
        int moves = 0;
        if (row > 2)
            moves += row - 2;
        else
            moves += 2 - row;
 
        if (col > 2)
            moves += col - 2;
        else
            moves += 2 - col;
        System.out.println(moves);
        sc.close();
    }
}