package StackAndQueues;

import java.util.Stack;

public class ValidParentheses {
    static void main() {
        System.out.println(isValid("]]"));
    }
    static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()) return false;
                if(isValid(stack.peek(), c)){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isValid(char a, char b){
        if(a == '(' && b == ')') return true;
        else if(a == '[' && b == ']') return true;
        else if(a == '{' && b == '}') return true;
        return false;
    }
}
