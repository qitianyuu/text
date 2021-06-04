package com.qi.algorithm.util;

import com.qi.algorithm.entity.ListNode;

/**
 * Description: tool
 * Author: Qi
 * Date: 06-04-2021
 */
public class Tool {

    public static void printLinkList(ListNode head){
        ListNode listNode = head;
        while (listNode.next != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
        System.out.println("finish!");
    }
}