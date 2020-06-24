package com.admol.algorithm.leetcode.simple;

import com.admol.algorithm.leetcode.ListNode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 链接：https://leetcode-cn.com/problems/min-stack
 * @author : admol
 * @Date : 2020/6/24
 */
public class Lc0155{

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

    /***
     * 题目要求能在常数时间内检索到最小元素的栈
     * 所以每次在入栈操作的时候, 都计算出一个最小值, 并将元素栈顶与之对应的, 存放到最小值的栈
     * 元素栈出栈时, 最小值栈同时跟着出栈
     * 例如, 元素栈入栈顺序为 -2,0,-3时, 最小值栈入栈顺序为-2,-2,-3
     */
    static class MinStack{

        /**存储元素的栈*/
        ListNode stack;
        /**元素栈顶对应的最小值栈列表*/
        ListNode minStack;

        public MinStack() {
        }

        /**
         *  将元素 x 推入栈中
         *  栈: 先入,后出;后进先出;
         *  所以后面进来的放到队头
         * @param x
         */
        public void push(int x) {
            ListNode node = new ListNode(x);
            if(stack == null){
                // 初始化两个栈
                stack = node;
                minStack = node;
            }else {
                // 1.新元素做对头
                node.next = stack;
                stack = node;
                // 2.计算最小值, 并入栈
                int min = Math.min(minStack.val,x);
                ListNode minNode = new ListNode(min);
                minNode.next = minStack;
                minStack = minNode;
            }
        }

        /**
         * 删除栈顶的元素
         */
        public void pop() {
            if(stack == null){
                return;
            }
            // 出栈
            stack = stack.next;
            minStack = minStack.next;
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public int top() {
            if(stack != null){
                return stack.val;
            }
            return -1;
        }

        /**
         * 检索栈中的最小元素
         * @return
         */
        public int getMin() {
            return minStack.val;
        }

    }

}
