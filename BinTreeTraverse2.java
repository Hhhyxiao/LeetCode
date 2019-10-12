package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinTreeTraverse2 {

    private int[] array = {1,2,3,4};
    private static List<Node> nodeList = null;
    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinTreeTraverse2 binTree = new BinTreeTraverse2();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);
        System.out.println(isCousins(root, 4, 3));
    }

    public static String tree2str(Node t) {
        String res = "";
        if(t == null) return "";
        res += String.valueOf(t.data);
        String temp1 = tree2str(t.leftChild);
        String temp2 = tree2str(t.rightChild);
        if(t.leftChild != null || t.rightChild != null) res += "(" + temp1 + ")";
        if(t.rightChild != null); res += "(" + temp2 + ")";
        return res;
    }
    public  static boolean isCousins(Node root, int x, int y) {
        HashMap<Integer, Integer> depth = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        val.put(root.data, 101);
        queue.offer(root);
        int cnt = 1;
        int deep = 1;
        int tc = 0;
        while(!queue.isEmpty()){
            tc = 0;
            for(int i = 0; i < cnt; cnt++){
                Node temp = queue.poll();
                if(temp == null) break;
                depth.put(temp.data, deep);
                if(temp.leftChild != null){
                    val.put(temp.leftChild.data, temp.data);
                    queue.offer(temp.leftChild);
                    tc++;
                }
                if(temp.rightChild != null){
                    val.put(temp.rightChild.data, temp.data);
                    queue.offer(temp.rightChild);
                    tc++;
                }
            }
            deep++;
            cnt = tc;
            System.out.print(deep);
        }
        System.out.print(depth.get(x));
        System.out.print(depth.get(y));
        return depth.get(x) == depth.get(y) && (val.get(x) != val.get(y));
    }
}
