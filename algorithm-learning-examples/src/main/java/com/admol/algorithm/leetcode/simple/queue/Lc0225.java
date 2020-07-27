package com.admol.algorithm.leetcode.simple.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * @author : admol
 * @Date : 2020/7/2
 */
public class Lc0225{

    public static void main(String[] args){

        MyStack queue  = new MyStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.top());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
    }

    static class MyStack {

        /**队列是先进先出*/
        LinkedList<Integer> queue;

        /**
         * 栈是现金后出
         */
        public MyStack() {
            queue = new LinkedList();
        }

        /**
         * 入栈
         * @param x
         */
        public void push(int x) {
            //需要每次加入到队列的对头
            //queue.addFirst(x);
            // 不用addFirst
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.remove());
                sz--;
            }
        }

        /**
         * 出栈,并移除栈顶元素
         * @return
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public int top() {
            return queue.peek();
        }

        /**
         * 返回栈是否为空
         * @return
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
