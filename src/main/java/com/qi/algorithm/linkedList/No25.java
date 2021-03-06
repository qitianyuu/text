package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

/**
 * Description:给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * Author: Qi
 * Date: 06-07-2021
 */
public class No25 {
    //反转前n个
    ListNode tmp = null;
    public ListNode reverseN(ListNode head, int n){
        if (n == 1){
            tmp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tmp;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    //k个一组反转(迭代法)
    public ListNode reverseKGroup(ListNode head, int k) {
        int all = 0;
        ListNode c = head;
        while (c != null){
            c = c.next;
            all++;
        }
        k--;
        for (int i = 1; ; i = k + i + 1){
            //if (i > all){
            if (i + k > all){
                break;
            }
            head = reverseBetween(head, i, i + k);
        }
        return head;
    }

    //k个一组反转(递归法)
    public ListNode reverseab(ListNode a, ListNode b){
        ListNode p, c, n;
        p = null;
        c = a;
        while(c != b){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public ListNode reverseKgroup(ListNode head, int k){
        if (head == null){
            return head;
        }
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newhade = reverseab(a,b);
        a.next = reverseKGroup(b,k);
        return newhade;
    }


}
