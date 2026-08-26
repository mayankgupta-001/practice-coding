package leetcode;

public class DeleteNodeInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                int maxLeft = findMax(root.left);
                root.left = deleteNode(root.left, maxLeft);
                root.val = maxLeft;

                // int minRight = findMin(root.right);
                // root.right = deleteNode(root.right, minRight); 
                // root.val = minRight;
            }
        }
        return root;
    }
    public int findMax(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int rightMax = findMax(root.right);
        return Math.max(root.val, rightMax);
    }
    public int findMin(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;
        int leftMin = findMin(node.left);
        return Math.min(node.val, leftMin);
    }
}
