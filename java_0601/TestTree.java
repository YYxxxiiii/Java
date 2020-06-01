package java_0601;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}


public class TestTree {
    public static Node build() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //求二叉树中节点的个数
    //使用先序遍历的方式
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        //访问根节点:此处的访问操作应该是计数器 + 1
        //递归是一个拆分的问题
        //整个树节点个数 = 根节点的个数(1) + 左子树节点的个数 + 右子树节点的个数
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树叶子结点个数
    //遍历树&拆分
    //求 root 叶子结点的个数 = root.left 的叶子节点个数 + root.right 的叶子节点个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历:");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历:");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历:");
        postOrder(root);
        System.out.println();
    }

}
