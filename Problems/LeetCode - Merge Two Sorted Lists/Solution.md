# Description

Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

# Solution
```
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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }

        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode result = null;
        ListNode resultLastNode = null;

        while (current1 != null && current2 != null) {
            final ListNode currentNode;
            if (current1.val <= current2.val) {
                currentNode = new ListNode(current1.val);
                current1 = current1.next;
            } else {
                currentNode = new ListNode(current2.val);
                current2 = current2.next;
            }

            if (result == null) {
                result = currentNode;
            } else {
                resultLastNode.next = currentNode;
            }
            resultLastNode = currentNode;
        }
        resultLastNode.next = current1 != null ? current1 : current2;
        return result;
    }
}
```


# Tests
```
    @Test
    fun `test empty`() {
        assertTrue(
            intArrayOf()
                .contentEquals(
                    test(array1 = intArrayOf(), array2 = intArrayOf())
                )
        )
    }

    @Test
    fun `test case 1`() {
        val result = test(array1 = intArrayOf(), array2 = intArrayOf(0))
        assertTrue(intArrayOf(0).contentEquals(result))
    }

    @Test
    fun `test case 2`() {
        val result = test(array1 = intArrayOf(1, 2, 4), array2 = intArrayOf(1, 3, 4))
        assertTrue(intArrayOf(1, 1, 2, 3, 4, 4).contentEquals(result))
    }

    @Test
    fun `test case 3`() {
        val result = test(array1 = null, array2 = null)
        assertTrue(intArrayOf().contentEquals(result))
    }

    private fun listNodeToArray(node: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var currentNode = node


        while (currentNode != null) {
            result.add(currentNode.`val`)
            currentNode = currentNode.next
        }
        return result.toIntArray()
    }

    private fun arrayToListNode(array: IntArray?): ListNode? {
        if (array == null) {
            return null
        }
        if (array.isEmpty()) {
            return null;
        }
        if (array.size == 1) {
            return ListNode(array.first())
        }
        val result = ListNode(array.first())
        var last = result

        array.forEachIndexed { index, i ->
            if (index != 0) {
                last.next = ListNode(i)
                last = last.next
            }
        }
        return result
    }

    private fun test(array1: IntArray?, array2: IntArray?): IntArray {
        return listNodeToArray(
            MergeTwoSortedListsProblem().mergeTwoLists(
                arrayToListNode(array1),
                arrayToListNode(array2),
            )
        )
    }
```
