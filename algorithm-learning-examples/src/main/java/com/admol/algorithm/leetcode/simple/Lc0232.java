package com.admol.algorithm.leetcode.simple;

import java.util.Stack;

/**
 * 用栈实现队列
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0232{


    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        while(!myQueue.empty()){
            System.out.println(myQueue.pop());
        }
    }
    /**
     * 队列的特点: 先进先出
     */
    static class MyQueue {
        // 栈的特点, 先进后出
        Stack<Integer> stack;
        Stack<Integer> outStack;

        public MyQueue() {
            stack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            // 原来的栈是先进后出, 需要实现先进先出, 所以需要将原来栈低的放到栈顶
            stack.push(x);
        }

        public int pop() {
            while(outStack.isEmpty()){
                // 将入栈的依次出栈放到 另一个栈中
                // 比如原栈依次入栈为1,2,3,4, 然后依次出栈为4,3,2,1加入到新栈, 然后新栈出栈顺序就为1,2,3,4; 实现了队列的功能
                while(!stack.isEmpty()){
                    outStack.push(stack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            while(outStack.isEmpty()){
                while(!stack.isEmpty()){
                    outStack.push(stack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && outStack.isEmpty();
        }
    }
}
