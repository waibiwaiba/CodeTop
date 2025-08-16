package main.java.com.leetcode.queue.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // 构造函数，初始化两个队列
    public MyStack() {
        queue1 = new LinkedList<>(); // 我们假设 queue1 是主队列
        queue2 = new LinkedList<>(); // queue2 是备用队列
    }
    
    // 将元素 x 压入栈顶 (O(1) 复杂度)
    public void push(int x) {
        // 新元素应该加到哪个队列？
        queue1.add(x);
    }
    
    // 移除并返回栈顶元素 (O(n) 复杂度)
    public int pop() {
        // 1. 先处理边界情况：如果栈是空的怎么办？
        if(queue1.isEmpty()){
            //throw new Exception("error: poping a empty stack.");
            return -999999;
        }
        // 2. 把主队列的 n-1 个元素搬运到备用队列
        for(int i=0;i<queue1.size()-1;i++){
            queue2.add(queue1.poll());
        }
        // 3. 获取并移除主队列的最后一个元素
        int temp = queue1.poll();
        // 4. 交换主副队列的身份
        Queue<Integer> temp_queue = new LinkedList<>();
        temp_queue = queue1;
        queue1 = queue2;
        queue2 = temp_queue;
        return temp; // 临时返回值
    }
    
    // 返回栈顶元素 (O(n) 复杂度)
    public int top() {
        // 和 pop 非常类似，但最后那个元素不真的丢掉
        if(queue1.isEmpty()){
            //throw new Exception("error: poping a empty stack.");
            return -999999;
        }
        // 2. 把主队列的 n-1 个元素搬运到备用队列
        for(int i=0;i<queue1.size()-1;i++){
            queue2.add(queue1.poll());
        }
        // 3. 获取并移除主队列的最后一个元素
        int temp = queue1.peek();
        queue2.add(queue1.poll());
        // 4. 交换主副队列的身份
        Queue<Integer> temp_queue = new LinkedList<>();
        temp_queue = queue1;
        queue1 = queue2;
        queue2 = temp_queue;
        return temp; // 临时返回值
    }
    
    // 如果栈为空，返回 true；否则，返回 false (O(1) 复杂度)
    public boolean empty() {
        // 检查哪个队列？
        return queue1.isEmpty(); // 临时返回值
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */



// 正确答案
// import java.util.LinkedList;
// import java.util.Queue;

// class MyStack {

//     private Queue<Integer> queue1;
//     private Queue<Integer> queue2;

//     public MyStack() {
//         queue1 = new LinkedList<>(); // 主队列
//         queue2 = new LinkedList<>(); // 备用队列
//     }
    
//     public void push(int x) {
//         queue1.add(x);
//     }
    
//     public int pop() {
//         // (在刷题环境下，可以假设调用时栈不为空)
        
//         // 使用 while 循环，直到主队列只剩一个元素
//         while (queue1.size() > 1) {
//             queue2.add(queue1.poll());
//         }
        
//         // 获取最后一个元素
//         int result = queue1.poll();
        
//         // 交换队列身份
//         Queue<Integer> tempQueue = queue1;
//         queue1 = queue2;
//         queue2 = tempQueue;
        
//         return result;
//     }
    
//     public int top() {
//         // (在刷题环境下，可以假设调用时栈不为空)

//         while (queue1.size() > 1) {
//             queue2.add(queue1.poll());
//         }
        
//         // 获取最后一个元素
//         int result = queue1.poll();
//         // 关键区别：把它也加到备用队列，因为它没有被删除
//         queue2.add(result);
        
//         // 交换队列身份
//         Queue<Integer> tempQueue = queue1;
//         queue1 = queue2;
//         queue2 = tempQueue;
        
//         return result;
//     }
    
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }