package java_0329;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {
    public static Node bulid() {
        //手动构造一棵树
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('F');
        Node h = new Node('G');

        //手动连接
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

    //写一个方法，求二叉树中节点的个数
    //还是借助遍历的方法
    //使用后序遍历的方式
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        //访问根节点：此处的访问操作应该是计数器+一；
        //体会递归“拆分问题”的过程
        //整个树节点个数 = 根节点的个数（1） + 左子树节点的个数（递归去求） + 有字数的节点的个数（递归）
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树叶子节点的个数
    //还是要遍历树
    //并且要拆分问题
    //求root叶子结点的个数 = root.left 的叶子结点个数 + root.right叶子节点的个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //此时的root没有子树，root自己就是叶子结点
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //求二叉树第K层节点的个数
    //如果k<1 只能是空树，直接返回0
    //如果=1，求根节点的个数，返回1
    //k层节点的个数 = 左子树的K—1 层节点个数 + 右子树的K-1层节点个数
    public static int kLeveSize(Node root,int k) {
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLeveSize(root.left,k - 1) + kLeveSize(root.right,k - 1);
    }

    //在二叉树中查找指定元素
    //如果存在就返回该节点的引用，如果不存在，返回null
    //核心思路还是遍历
    Node find(Node root, char toFind) {
        if (root == null) {
            return null;
        }

        //此处的访问就是一个比较操作
        if (root.val == toFind) {
            return root;
        }

        //分别递归去查找左右子树
        Node result = find(root.left,toFind);
        if (result != null) {
            return result;
        }
        return find(root.right,toFind);
    }

    public static void main(String[] args) {
        Node root = bulid();
        System.out.println("先序遍历：");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println();



    }
}
