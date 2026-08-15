package two_pointers;
import java.util.*;

public class TwoSum2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = twoSum(numbers, target);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No two numbers found.");
        }

        sc.close();
    }
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                // +1 because Two Sum II uses 1-based indexing
                return new int[] {start + 1, end + 1};
            } 
            else if (sum < target) {
                start++;
            } 
            else {
                end--;
            }
        }

        return new int[0];
    }
}
