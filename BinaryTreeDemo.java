import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeDemo {

    // 1. Construct Binary Tree from Level-Order Array
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            // Assign left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;

            // Assign right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // 2. Preorder Traversal (Root -> Left -> Right)
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 3. Inorder Traversal (Left -> Root -> Right)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 4. Postorder Traversal (Left -> Right -> Root)
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // 5. Level-Order Traversal (Breadth-First Search)
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    // Main Method to Test
    public static void main(String[] args) {
        // Example array representing level order: [1, 2, 3, 4, 5, null, 6]
        Integer[] arr = {1, 2, 3, 4, 5, null, 6};

        TreeNode root = buildTree(arr);

        System.out.println("--- Binary Tree Traversals ---");
        
        System.out.print("Level Order : ");
        levelOrder(root);
        System.out.println();

        System.out.print("Preorder    : ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder     : ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder   : ");
        postorder(root);
        System.out.println();
    }
}