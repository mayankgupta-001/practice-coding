package two_pointers;
import java.util.*;

class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of heights: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter the heights:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int result = obj.maxArea(height);
        System.out.println("Maximum Area = " + result);
        sc.close();
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int heightt = Math.min(height[left], height[right]);
            int width = right - left;
            int area = heightt * width;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

