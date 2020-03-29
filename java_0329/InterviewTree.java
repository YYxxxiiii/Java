package java_0329;

import java.util.ArrayList;
import java.util.List;

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
}
