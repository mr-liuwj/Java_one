package com.lcy.util;

/**
 * @author liuweijin
 * @date 2022-04-24 17:20
 * @desc
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
