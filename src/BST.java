import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return findVal(val, root);
    }

    /**
     * Recursively searches if a value is in the tree
     */
    public boolean findVal(int val, BSTNode node){
        if (node.getVal() == val){
            return true;
        }
        /**
         * Lower numbers are on the left of the tree
         * */
        if (node.getLeft() != null && val < node.getVal()){
            return findVal(val, node.getLeft());
        }
        /**
         * Higher numbers are on the right of the tree
         * */
        else if (node.getRight() != null && val > node.getVal()){
            return findVal(val, node.getRight());
        }
        return false;
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        findInorder(root, inorder);
        return inorder;
    }

    /**
     * Recursively puts the nodes in order
     * of lowest to highers value
     * @param inorder, Arraylist which holds the order
     */
    public void findInorder(BSTNode node, ArrayList<BSTNode> inorder) {
        if (node.getLeft() != null){
            findInorder(node.getLeft(), inorder);
        }
        inorder.add(node);
        if (node.getRight() != null){
            findInorder(node.getRight(), inorder);
        }
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        findPreorder(root, preorder);
        return preorder;
    }

    /**
     * Recursively puts the nodes in preorder
     * @param preorder, Arraylist of nodes in proper preorder
     * Goes in the order Root, Left, Right
     */
    public void findPreorder(BSTNode node, ArrayList<BSTNode> preorder) {
        preorder.add(node);
        if (node.getLeft() != null){
            findPreorder(node.getLeft(), preorder);
        }
        if (node.getRight() != null){
            findPreorder(node.getRight(), preorder);
        }
    }
    /**
     * @return ArrayList of BSTNodes in postorder
     * Goes in the order Left, Right, Root
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();
        findPostorder(root, postorder);
        return postorder;
    }

    /**
     * Recursively put the nodes in postorder
     * @param postorder, Arraylist holding the node order
     */
    public void findPostorder(BSTNode node, ArrayList<BSTNode> postorder) {
        if (node.getLeft() != null){
            findPostorder(node.getLeft(), postorder);
        }
        if (node.getRight() != null){
            findPostorder(node.getRight(), postorder);
        }
        postorder.add(node);
    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        findLocation(root, val);
    }

    /**
     * Insets a node in its correct spot in the tree
     * @param val of the node to be inserted
     */
    public void findLocation(BSTNode node, int val){
        /**
         * Val lower than the current
         * node go to left side of tree
         */
        if (val < node.getVal()){
            if (node.getLeft() != null){
                findLocation(node.getLeft(), val);
            }
            else{
                BSTNode newNode = new BSTNode(val);
                node.setLeft(newNode);
            }
        }
        /**
         * Val higher than the current
         * node go to right side of tree
         */
        else if (val > node.getVal()) {
            if (node.getRight() != null) {
                findLocation(node.getRight(), val);
            }
            else {
                BSTNode newNode = new BSTNode(val);
                node.setRight(newNode);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
