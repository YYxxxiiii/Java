package java_0405;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class InterviewTree {
    public static void preOrderByLoop(TreeNode root) {
        //非递归的方式来完成遍历
        //需要一个栈来协助
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            //访问这个节点
            System.out.println(top.val + " ");
            //把左右数分别入栈
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        //准备一个栈起到辅助效果
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {   //为了遍历所有元素
            //1.循环往左找,把路径遇到的节点都入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2.如果当前栈为空,遍历就结束了
            if (stack.isEmpty()) {
                break;
            }
            //3.取栈顶元素并访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");

            //4.从当前节点的右子树再出发继续刚才的过程
            cur = top.right;
        }
    }

    public static void posOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prev记录了当前已经访问过得节点中的最后一个节点
        // 也就是即将被访问的元素的前一个节点
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            //拿出栈顶元素的值,看看可不可以访问
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right) {

            }
        }

    }
}
