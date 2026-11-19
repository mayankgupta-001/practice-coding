package bst;

public class UniqueBinarySearchTrees {
    public int[] counts = null;
    public int numTrees(int n) {
        counts = new int[1 + n];    
        return find(n);
    }
    
    public int find(int n) {
        if (counts[n] != 0) return counts[n];
        if (n <= 1) return 1;
        int total = 0;
        for (int i = 1; i <= n; ++i) {
            total += find(i - 1) * find(n - i);
        }
        counts[n] = total;
        
        return total;
    }
}
