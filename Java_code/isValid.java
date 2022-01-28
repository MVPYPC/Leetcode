package Leetcode.Java_code;

import java.util.Stack;

public class isValid {
    public boolean judge(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else
                switch (s.charAt(i)){
                    case ')':
                        if(!stack.empty() && stack.peek() == '(')
                            stack.pop();
                        else return false;
                        break;

                    case ']':
                        if(!stack.empty() && stack.peek() == '[')
                            stack.pop();
                        else return false;
                        break;

                    case '}':
                        if(!stack.empty() && stack.peek() == '{')
                            stack.pop();
                        else return false;
                        break;

                    default:
                        return false;
                }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        quickprint.print(new isValid().judge("("));
    }
}
