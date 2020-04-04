package java_0404;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class InterviewTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isSecondStep = false;

        // 针对这个树进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 针对当前节点进行访问(判断是否符合完全二叉树的要求)
            if (!isSecondStep) {
                // 这是第一阶段
                if (cur.left != null && cur.right != null) {
                    // 直接把这两个子树入队列即可
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 当前第一阶段中某个节点只有右子树, 没有左子树. 一定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 切换到第二阶段
                    isSecondStep = true;
                    queue.offer(cur.left);
                } else {
                    // 左右子树都为空, 也要切换到第二阶段
                    isSecondStep = true;
                }
            } else {
                // 这是第二阶段
                // 要求第二阶段中任何一个节点都必须没有子树.
                // 只要找到某个节点带子树, 就说明找到了反例
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        // 整个树都遍历完了, 也没找到反例, 最终就 return true. 认为就是完全二叉树.
        return true;
    }

    // result 相当于一个二维数组
    // 针对当前的 ArrayList (包含了所有的层) 来说, 每个元素又是一个 List (每一层里面的所有节点内容).
    // result 0 号元素对应着第 0 层节点
    // result 1 号元素对应着第 1 层节点
    // .....
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 此处由于要把每一层的节点放到一个单独的 List 中. 所以之前的层序遍历方式就不太行了.
        // 此处还是基于递归的方式来解决这个问题
        if (root == null) {
            return result;
        }
        // helper 方法辅助递归. 第二个参数表示当前的层数(层数从 0 开始算, 和 List 下标正好对上)
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        // 把当前节点添加到 result 中的合适位置
        // result.get(level).add(root.val);
        List<Integer> row = result.get(level);
        row.add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
//        InterviewTree tree = new InterviewTree();
//        TreeNode root = build();
//        boolean ret = tree.isCompleteTree(root);
    }
}
