/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head==null){
//             return null;
//         }
//         ListNode prev = null;
//         ListNode current = head;
//         while(current.next!=null){
//             prev = current;
//             current = current.next;
//             prev.next = null;
//             current.next = prev;
//         }
//         return current;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        // prev 指向反转后新链表的头部，初始为 null
        ListNode prev = null;
        // curr 指向当前需要处理的节点，初始为 head
        ListNode curr = head;

        while (curr != null) {
            // 1. 暂存 curr 的下一个节点，防止链表断裂
            ListNode nextTemp = curr.next;
            
            // 2. 核心：将当前节点的 next 指针指向前一个节点
            curr.next = prev;
            
            // 3. 移动指针，为下一次循环做准备
            //    prev 指针移动到当前位置
            prev = curr;
            //    curr 指针移动到下一个位置
            curr = nextTemp;
        }

        // 循环结束时，prev 指向了原链表的最后一个节点，即新链表的头节点
        return prev;
    }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. 递归的终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 递归地反转除了头节点以外的剩余链表
        // newHead 是反转后新链表的头节点（也就是原链表的尾节点）
        ListNode newHead = reverseList(head.next);
        
        // 2. 将当前头节点 head 连接到已反转链表的末尾
        //    head.next 此刻指向的是原链表的第二个节点，
        //    它在反转后变成了新链表的最后一个节点。
        //    所以 head.next.next = head; 就是让新链表的最后一个节点指向 head。
        head.next.next = head;
        
        // 3. 断开 head 原来的指向，防止形成环路
        head.next = null;

        // 4. 返回新链表的头节点
        return newHead;
    }
}