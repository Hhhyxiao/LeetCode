package LeetCode;

public class LC443 {
    public static void main(String[] args) {
        char[] chars = {'a','a'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        if(chars.length == 1) return 1;
        char pre = chars[0];
        int index = 1;
        int count = 1;
        int cnt;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == pre){
                count++;
            }
            if(chars[i] != pre || i == chars.length - 1){
                char temp1 = chars[i];
                if(count != 1){
                    int temp = count / 10;
                    while(temp!= 0){
                        temp = temp / 10;
                        index++;
                    }
                    cnt = 0;
                    while(count!= 0){
                        chars[index--] = (char) ('0' + count % 10);
                        count = count / 10;
                        cnt++;
                    }
                    index += cnt + 1;
                }
                if(temp1 != pre){
                    chars[index++] = chars[i];
                    count = 1;
                    pre = chars[i];
                }
            }
        }
        return index;
    }
}
