package com.example.leetcode;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode iterator = head;
        List<Integer> list = new ArrayList<>();
        List<Integer> innerlist = new ArrayList<>();
        while (iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }
        for (int i = right-1; i >= left-1; i--) {
            innerlist.add(list.get(i));
        }
        int j = 0;
        for (int i = left-1; i <= right-1; i++) {
            list.set(i, innerlist.get(j));
            j++;
        }
        iterator = head;
        for (int i = 0; i < list.size(); i++) {
            iterator.val = list.get(i);
            iterator = iterator.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = reverseBetween(head,2,4);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }
}

