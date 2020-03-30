package java15_0329;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class TestTree {
    public static Node build() {
        // 手动把一棵树构造出来.
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

    // 写一个方法, 求二叉树中节点的个数
    // 使用后序遍历的方式
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        // 访问根节点: 此处的访问操作应该是计数器 + 1;
        // 体会递归 "拆分问题" 的过程
        // 整个树节点个数 = 根节点的个数(1) + 左子树节点的个数 + 右子树的节点个数
        return 1 + size(root.left) + size(root.right);
    }

    // 求二叉树叶子节点的个数
    // 还是要遍历树, 并且拆分问题
    // 求 root 叶子节点的个数 = root.left 的叶子节点个数 + root.right 的叶子节点个数.
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 此时的 root 没有子树, root 自己就是叶子节点
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    // 求二叉树第 k 层节点的个数
    // 如果 k < 1 只能是空树. 直接返回 0
    // 如果 k == 1 求根节点的个数. 直接返回 1
    // k 层节点的个数 = 左子树的 k - 1 层节点个数 + 右子树的 k - 1 层节点个数.
    public static int kLevelSize(Node root, int k) {
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    // 在二叉树中查找指定元素
    // 如果存在就返回该节点的引用. 如果不存在, 返回 null
    // 核心思路还是遍历
    Node find(Node root, char toFind) {
        if (root == null) {
            return null;
        }
        // 此处的 "访问" 就是一个比较操作了
        if (root.val == toFind) {
            return root;
        }
        // 分别递归的去查找左右子树
        Node result = find(root.left, toFind);
        if (result != null) {
            return result;
        }
        return find(root.right, toFind);
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历: ");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历: ");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历: ");
        postOrder(root);
        System.out.println();
    }
}
