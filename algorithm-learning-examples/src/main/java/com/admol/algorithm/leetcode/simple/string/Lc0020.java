package com.admol.algorithm.leetcode.simple.string;

import com.admol.algorithm.datastructure.stack.ArrayStack;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"     输出: true
 * 示例 2:
 * 输入: "()[]{}" 输出: true
 * 示例 3:
 * 输入: "(]"     输出: false
 * 示例 4:
 * 输入: "([)]"   输出: false
 * 示例 5:
 * 输入: "{[]}"   输出: true
 *
 * @author : admol
 * @Date : 2020/6/9
 */
public class Lc0020{

    public static boolean isValid(String s) {
        // 字符串为空或者字符串的长度为奇数,则肯定不符合规则
        if(s == null){
            return false;
        }
        s = s.replace(" ","");
        // 奇数
        if((s.length() & 1) == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        // 替换掉所有的空格
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            // 是否需要弹出
            if(needPop(c)){
                if(stack.isEmpty()){
                    return false;
                }
                Character popChar = stack.pop();
                if(!checkValid(popChar,c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        // 判断栈是否为空, 不为空, 说明不是有效的
        return stack.isEmpty();
    }
    /**
     * 使用自己写的栈实现入栈出栈操作
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        // 字符串为空或者字符串的长度为奇数,则肯定不符合规则
        if(s == null){
            return false;
        }
        s = s.replace(" ","");
        if((s.length() & 1) == 1){
            return false;
        }
        ArrayStack<Character> arrayStack = new ArrayStack(true);
        // 替换掉所有的空格
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            // 是否需要弹出
            if(needPop(c)){
                if(arrayStack.isEmpty()){
                    return false;
                }
                Character popChar = arrayStack.pop();
                if(!checkValid(popChar,c)){
                    return false;
                }
            }else{
                arrayStack.push(c);
            }
        }
        // 判断栈是否为空, 不为空, 说明不是有效的
        return arrayStack.isEmpty();
    }

    private static boolean checkValid(Character popChar,Character c){
        if(popChar == '{'){
            return c == '}';
        }
        if(popChar == '('){
            return c == ')';
        }
        if(popChar == '['){
            return c == ']';
        }
        return false;
    }
    private static boolean needPop(char c){
        switch(c){
            case ')': return true;
            case '}': return true;
            case ']': return true;
        }
        return false;
    }

    public static void main(String[] args){
        String[] str = {"){","{}","()[]{}","( )[  ]{  }","(]{}","( ]{  }"," ","(((","}}}"};
        for(String s : str){
            System.out.println(s+" :是否有效:"+isValid(s));
        }

    }
}
