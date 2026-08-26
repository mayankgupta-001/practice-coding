package leetcode;

public class ValidateBinarySearchTree {
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
    // public boolean isValidBST(TreeNode root) {
    //     return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // public boolean isValidBST(TreeNode node, long min, long max) {
    //     if (node == null) {
    //         return true;
    //     }
    //     if (node.val <= min || node.val >= max) {
    //         return false;
    //     }
    //     return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    // }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        BstPair pair = ValidBST(root);
        return pair.isBst;
    }
    public BstPair ValidBST(TreeNode root) {
        if(root == null) {
            return new BstPair();
        }
        BstPair left = ValidBST(root.left);
        BstPair right = ValidBST(root.right);
        BstPair myPair = new BstPair();
        myPair.min = Math.min(root.val, Math.min(left.min, right.min));
        myPair.max = Math.max(root.val, Math.max(left.max, right.max));
        if(left.isBst && right.isBst && left.max < root.val && right.min > root.val) {
            myPair.isBst = true;
        } else {
            myPair.isBst = false;
        }
        return myPair;
    }
}

//doing it using class
class BstPair {
    boolean isBst = true;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
}
