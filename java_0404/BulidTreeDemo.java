package java_0404;

import java.util.Scanner;

public class BuildTreeDemo {
    static class TreeNode {
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 这里的循环是因为在线 OJ 一般都是多组输入
        while (scanner.hasNext()) {
            // line 这个字符串就对应一组形如 "abc##de#g##f###" 的输入数据
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            // 一定要严格注意输出数据格式, 格式多个空格少个换行都是不行的
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
    }

    private static int index = 0;
    private static TreeNode build(String line) {
        // 为了在后面的递归创建过程中能时刻知道当前访问到 line 中的哪个元素了,
        // 使用一个专门的变量来记录一下
        // 通过下面的方法辅助完成递归
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        // 获取到当前处理到哪个节点
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        // 当前字符不是 # 就创建一个节点
        TreeNode root = new TreeNode(cur);
        index++;    // 准备处理下一个节点. 下一个节点开始就是当前 root 左子树的先序遍历结果
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }

}
