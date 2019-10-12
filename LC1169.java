package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC1169 {
    public static void main(String[] args) {
        String[] transactions = {"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"};
        System.out.println(invalidTransactions(transactions));
    }
    public static List<String> invalidTransactions(String[] transactions) {
        HashMap<String,List<Integer>> map = new HashMap<String, List<Integer>>();
        List<String> res = new LinkedList<String>();
        String[][] m = new String[transactions.length][];
        for(int i = 0; i < transactions.length; i++){
            String[] temp = transactions[i].split(",");
            m[i] = temp;
            if(Integer.valueOf(temp[2]) > 1000) res.add(transactions[i]);
            if(map.get(temp[0]) == null){
                List<Integer> temp1 = new LinkedList<Integer>();
                temp1.add(i);
                map.put(temp[0], temp1);
            }
            else{
                for(Integer index: map.get(temp[0])){
                    if(!temp[3].equals(m[index][3]) && temp[0].equals(m[index][0])){
                        if(Math.abs(Integer.valueOf(temp[1]) - Integer.valueOf(m[index][1])) <= 60){
                            if(!res.contains(transactions[i])) res.add(transactions[i]);
                            if(!res.contains(transactions[index])) res.add(transactions[index]);
                        }
                    }
                }
            }
        }
        return res;
    }
}
