package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC572 {
    public int[] array = {3,4,5,1,2};
    private static List<TreeNode> nodeList = null;
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int newData) {
            left = null;
            right = null;
            val = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left= nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    public static void main(String[] args) {
        LC572 binTree = new LC572();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        TreeNode root = nodeList.get(0);
        LC572 binTree2 = new LC572();
        int[] array1 = {4,1,2};
        binTree2.array = array1;
        binTree2.createBinTree();
        TreeNode root2 = nodeList.get(0);
        System.out.println(isSubtree(root, root2));
    }

    public static String tree2str(TreeNode t) {
        String res = "";
        if(t == null) return "";
        res += String.valueOf(t.val);
        String temp1 = tree2str(t.left);
        String temp2 = tree2str(t.right);
        if(t.left != null || t.right != null) res += "(" + temp1 + ")";
        if(t.right != null); res += "(" + temp2 + ")";
        return res;
    }

    static int flag = 0;
    static int fin = 0;
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t != null) return false;
        if(t == null && s != null) return false;
        order(s,t);
        return (fin == 1) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public static void order(TreeNode s, TreeNode t){
        if(!(s == null && t == null)){
            if(s == null || t == null){
                flag = 1;
            }
            else if(s.val != t.val){
                flag = 1;
            }
        }
        if(flag == 1) return;
        order(s.left, t.left);
        if(flag == 1) return;
        order(s.right, t.right);
        if(flag == 0) fin = 1;
    }
}
