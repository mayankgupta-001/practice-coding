import java.util.*;
class AvlTree{
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    private int balance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }
    public Node insert(Node node, int key) {
        if(node == null) return new Node(key);
        if(key < node.data) {
            node.left = insert(node.left, key);
        } else if(key > node.data) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        int balance = balance(node);
        if(balance > 1 && key < node.left.data) {
            return rightRotate(node);
        } else if(balance < -1 && key > node.right.data) {
            return leftRotate(node);
        } else if(balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if(balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public Node rightRotate(Node node){
        Node newNode = node.left;
        Node temp = newNode.right; 
        newNode.right = node;
        node.left = temp;
        return newNode;
    }
    public Node leftRotate(Node node){
        Node newNode = node.right;
        Node temp = newNode.left;
        newNode.left = node;
        node.right = temp;
        return newNode;
    }
    public void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AvlTree tree = new AvlTree();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int key = sc.nextInt();
            tree.root = tree.insert(tree.root, key);
        }

        tree.inorder(tree.root);
        sc.close();
    }
}