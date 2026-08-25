package leetcode;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int prefixProduct = 1;
        for (int i = 1; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i - 1];
        }
        
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return result;
    }
}