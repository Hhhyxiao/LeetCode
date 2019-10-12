package LeetCode;

public class LC744 {
    public static void main(String[] args) {
        char[] temp = {'c','f','j'};
        char target = 'c';
        System.out.print(nextGreatestLetter(temp, target));

    }
    public static char nextGreatestLetter(char[] letters, char target) {
        char min = 'z' + 1;
        char res = 'z' + 1;
        for(int i = 0; i < letters.length; i++){
            min = letters[i] > min ? min : letters[i];
            if(letters[i] > target){
                res = res > letters[i] ? letters[i] : res;
            }
        }
        if(res == (char)'z' + 1) return min;
        return res;
    }
}
