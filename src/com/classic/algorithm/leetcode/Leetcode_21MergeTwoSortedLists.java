package com.classic.algorithm.leetcode;



public class Leetcode_21MergeTwoSortedLists {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) { val = x; }
	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
         ListNode runner = new ListNode(0);
         ListNode head = runner;;

         while (l1 != null && l2 != null) {
             if (l1.val < l2.val) {
                 runner.next = l1;
                 l1 = l1.next;
             } else {
                 runner.next = l2;
                 l2 = l2.next;
             }
             runner = runner.next;
         }
         runner.next = l1 != null ? l1 : l2;
         return head.next;
    }


    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {

          if (l1 == null) return l2;
          else if (l2 == null) return l1;

          ListNode p = l1;
          ListNode q = l2;

          ListNode head = null;
          ListNode runner = new ListNode(0);

          while (p != null && q != null) {
              if (p.val < q.val) {
                  if (runner == null) {
                      head = p;
                      runner = p;
                      p = p.next;
                  } else {
                      runner.next = p;
                      p = p.next;
                      runner = runner.next;
                  }
              } else {
                  if (runner == null) {
                      head = q;
                      runner = q;
                      q = q.next;
                  } else {
                      runner.next = q;
                      q = q.next;
                      runner = runner.next;
                  }
              }
          }

         runner.next = p != null ? p : q;

         return head.next;
    }
}
