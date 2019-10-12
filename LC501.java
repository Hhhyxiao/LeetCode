package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC501 {

    private int[] array = {1,1};
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
        LC501 binTree = new LC501();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        TreeNode root = nodeList.get(0);
        for(Integer temp:findMode(root) ){
            System.out.println(temp);
        }
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
    static List<Integer> res = new LinkedList<Integer>();
    static int max = 0;
    static int pre;
    static int cnt;
    public static Integer[] findMode(TreeNode root) {
        Integer[] ans = new Integer[0];
        if(root == null) return ans;
        pre = root.val;
        cnt = 0;
        order(root);
        ans = res.toArray(new Integer[res.size()]);
        return ans;
    }

    public static void order(TreeNode root){
        if(root == null) return;
        order(root.left);
        if(root.val == pre){
            cnt++;
            if(cnt > max){
                res.clear();
                res.add(root.val);
                max = cnt;
            }else if(cnt == max){
                res.add(pre);
            }
        }else{
            System.out.print(pre);
            pre = root.val;
            cnt = 1;
            if(cnt > max){
                res.clear();
                res.add(root.val);
                max = cnt;
            }else if(cnt == max){
                res.add(pre);
            }
        }
        order(root.right);
    }
}
