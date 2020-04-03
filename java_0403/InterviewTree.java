package java_0403;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class InterviewTree {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }


    //看从root出发能不能找到p 或者q ,只要找到一个 就返回t
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //递归按照后序遍历来查找
        //满足两个条件即可
        //p q 分布在 左右中 三个位置中的其中两个
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        //相加为0：当前不是他们两的祖先
        //等于一：当前是他们俩之一的祖先，
        // 也有可能是公共祖先，
        // 但不一定是最近的公共祖先
        //如果是2：那就是pq的最近公共祖先
        if (left + right + mid == 2) {  //注意这个
            lca = root;
        }
        //如果三个位置之和为0，表示没找到 F
        //只要找到一个以上都返回T
        return  (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        //基于递归的方式来完成双向链表构建
        //为保证有序性，需要中序遍历
        //二叉搜索树的中序遍历结果是有序的
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            //当前这个节点没有子树
            return pRootOfTree;
        }

        //最终链表 => zuo + gen + you
        //就需要左子树链表的尾巴

        //1.先递归处理左子树
        //left 是左子树这个链表的根节点
        TreeNode left = Convert(pRootOfTree.left);
        //2.需要找到左子树链表的尾节点
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        //循环结束之后，lefttail就指向了左链表的尾部
        //3.吧左子树和当前节点连在一起
        if (left != null) {
            leftTail.right = pRootOfTree;
            leftTail.left = leftTail;
        }
        //4.递归转换右子树，吧右子树变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        //5.把当前节点和右子树连在一起
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //6.最终返回 新的链表的头节点
        return left == null ? pRootOfTree : left;
    }




}
