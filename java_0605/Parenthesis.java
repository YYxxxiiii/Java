package java_0605;

import java.util.Stack;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> sk = new Stack<Character>();
        if  (A == null ){
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                sk.push(A.charAt(i));
            } else if (A.charAt(i) == ')') {
                if (sk.empty()) {
                    return false;
                } else {
                    sk.pop();
                }
            } else {
                return false;
            }
        }
        if  (!sk.empty()){
            return false;
        } else {
            return true;
        }
    }
}
