package leetcode_21;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode startNode;
        if (l1.val < l2.val) {
            startNode = l1;
            l1 = l1.next;
        } else {
            startNode = l2;
            l2 = l2.next;
        }
        ListNode indexTmp = startNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                indexTmp.next = l1;
                l1 = l1.next;
            } else {
                indexTmp.next = l2;
                l2 = l2.next;
            }
            indexTmp = indexTmp.next;
        }

        if (l1 != null) indexTmp.next = l1;
        if (l2 != null) indexTmp.next = l2;
        return startNode;
    }
}


class ListNode {
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
