package java_0508;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestStackQueue {
    public boolean isValid(String s) {
        //1.创建一个栈,栈里保存字符类型
        Stack<Character> stack = new Stack<>();
        //2.循环遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //3.判断 c 是否为左括号,如果是左括号,就入栈
            //单引号表字符;双引号表String
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;//进入下次循环,取出下一个字符
            }
            if (stack.empty()) {
                //如果发现当前字符不是左括号,并且栈又为空,此时也就说明字符串非法
                //当前情况说明,之前没有合适的左括号和当前括号匹配
                return false;
            }
            //4.判定 c 是否为右括号,如果是右括号,就取栈顶元素对比一下
            char top = stack.pop(); //pop即可以return出栈顶元素,也可以出栈
           if (top == '(' && c == ')') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            //除了上面三种合法情况,剩下的都是非法情况
            return false;
        }
        //遍历完字符串之后,还要看栈是否为空,空栈才能是合法的字符串
        if (stack.empty()) {
            return true;
        }
        return false;
    }


    public boolean isValid2(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        //1.创建一个栈,栈里保存字符类型
        Stack<Character> stack = new Stack<>();
        //2.循环遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //3.判断 c 是否为左括号,如果是左括号,就入栈
            //单引号表字符;双引号表String
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;//进入下次循环,取出下一个字符
            }
            if (stack.empty()) {
                //如果发现当前字符不是左括号,并且栈又为空,此时也就说明字符串非法
                //当前情况说明,之前没有合适的左括号和当前括号匹配
                return false;
            }
            //4.判定 c 是否为右括号,如果是右括号,就取栈顶元素对比一下
            char top = stack.pop(); //pop即可以return出栈顶元素,也可以出栈
            if (map.get(top) == c) {
                continue;
            }
            //除了上面三种合法情况,剩下的都是非法情况
            return false;
        }
        //遍历完字符串之后,还要看栈是否为空,空栈才能是合法的字符串
        if (stack.empty()) {
            return true;
        }
        return false;
    }



    public boolean isValidByOwn(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if (map.get(top) == c) {
                continue;
            }
            return false;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
