/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 边界情况：空链表或只有一个节点的链表是回文的
        if (head == null || head.next == null) {
            return true;
        }

        // 步骤1: 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        // 当fast走到末尾时, slow正好在中间
        // 偶数个节点: fast.next.next为null, slow在中点前一个
        // 奇数个节点: fast.next为null, slow在正中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 步骤2: 反转后半部分的链表
        // secondHalfStart 是后半部分的头节点
        ListNode secondHalfStart = reverseList(slow.next);
        
        // 断开前半部分和后半部分的连接
        slow.next = null;

        // 步骤3: 比较前半部分和反转后的后半部分
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (p2 != null) { // 以p2为准，因为p2的长度 <= p1的长度
            if (p1.val != p2.val) {
                result = false;
                break; // 发现不匹配，直接退出
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // (可选) 步骤4: 恢复链表结构，将反转的后半部分再反转回来
        // slow.next = reverseList(secondHalfStart);

        return result;
    }

    /**
     * 辅助函数：反转一个链表
     * @param head 要反转的链表的头节点
     * @return 反转后新链表的头节点
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // 暂存下一个节点
            curr.next = prev;              // 当前节点指向前一个节点
            prev = curr;                   // prev 指针后移
            curr = nextTemp;               // curr 指针后移
        }
        return prev; // 返回新的头节点
    }
}