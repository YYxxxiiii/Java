package java15_0329;

import sun.awt.OSInfo;

import java.awt.print.PrinterGraphics;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            // 空树返回一个空的 List (元素个数为 0, 但是不是 null)
            return result;
        }
        // 访问根节点, 此处的访问操作, 把元素 add 到 List 中
        result.add(root.val);
        // 递归遍历左子树, 把左子树的遍历结果加入到 List 中
        result.addAll(preorderTraversal(root.left));
        // 递归遍历右子树, 把右子树的遍历结果加到 List 中
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 可以分成四种情况:
        // 1. p q 都为 null
        // 2. p 为 null, q 不为 null
        // 3. p 不为 null, q 为 null
        // 4. p q 都不为 null
        if (p == null && q == null) {
            // 两个树都是空树. 认为是相同的
            return true;
        }
        // if ((p == null && q != null) || (p != null && q == null)) {
        // 由于上面的逻辑, p 和 q 不会同时为 null. 只有说一个为 null 一个非 null 才能进入条件内部
        if (p == null || q == null) {
            // p 和 q 只有一个为 null 另一个不为 null
            return false;
        }
        // 下面的逻辑就是处理都不为 null 的情况了
        // 先判断根节点是否相同
        if (p.val != q.val) {
            // 这两棵树一定不相等
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            // 如果两棵树的根节点的值相同, 进一步判定 s 和 t 是不是相同的树
            ret = isSameTree(s, t);
        }
        return ret || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点深度就是 1
            return 1;
        }
        // 递归要执行三组
//        return 1 + (maxDepth(root.left) > maxDepth(root.right)
//                ? maxDepth(root.left) : maxDepth(root.right));

        // 递归只执行两组
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (Math.max(leftDepth, rightDepth));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            // 空树认为是平衡的
            return true;
        }
        if (root.left == null && root.right == null) {
            // 没有子树, 也认为是平衡的
            return true;
        }
        // 看当前节点对应的子树是否是平衡的
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            // 不是平衡的树
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            // 两者一个为空一个非空
            return false;
        }
        if (t1.val != t2.val) {
            // 两个树的根节点值不同, 肯定不是镜像关系
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public void levelOrder(TreeNode root) {
        // 不能使用递归来解了.
        // 可以借助一个队列来完成
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 访问元素
            System.out.print(cur.val + " ");
            // 把左右子树入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public static TreeNode build() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        TreeNode I = new TreeNode(9);
        TreeNode J = new TreeNode(10);
        TreeNode K = new TreeNode(11);
        TreeNode L = new TreeNode(12);
        TreeNode Z = new TreeNode(26);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        D.right = G;
        F.left = Z;
        E.left = H;
        E.right = I;
        C.left = K;
        C.right = L;
        K.left = J;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        InterviewTree interviewTree = new InterviewTree();
        interviewTree.levelOrder(root);
        System.out.println();
        // boolean ret = interviewTree.isBalanced(root);
    }
}
