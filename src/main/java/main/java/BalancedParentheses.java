package main.java;

public class BalancedParentheses {
    public static boolean balancedParentheses(String s){
        int numUnclosed = 0;
        for (int i=0;i<s.length(); i+=1){
            if (s.charAt(i) == '('){
                numUnclosed += 1;
            }
            else if (s.charAt(i) == ')'){
                numUnclosed -= 1;
            }
            if (numUnclosed < 0){
                return false;
            }
        }
        return numUnclosed == 0;
    }
}
//linear runtime complexity