package com.shevart.algorithms.hard.mergeksortedlists

class Solution {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val noNullLists = lists.filter { it != null }
        if (noNullLists.isEmpty()) {
            return null
        }

        if (noNullLists.size == 1) {
            return noNullLists[0]!!
        }

        var result = noNullLists.first()
        noNullLists.forEachIndexed { index, listNode ->
            if (index != 0) {
                result = merge(result!!, listNode!!)
            }
        }

        return result
    }

    fun merge(first: ListNode, second: ListNode): ListNode {
        if (first.next == null && second.next == null) {
            return insert(second.`val`, first)
        }

        var result = first
        var next: ListNode? = second
        while (next != null) {
            result = insert(next.`val`, result)
            next = next.next
        }
        return result
    }

    fun insert(number: Int, listNode: ListNode): ListNode {
        // number less
        if (number <= listNode.`val`) {
            val result = ListNode(number)
            result.next = listNode
            return result
        }

        // number in list
        var currentNode: ListNode? = listNode
        var previous = listNode
        while (currentNode != null) {
            if (currentNode.`val` >= number) {
                val result = ListNode(number)
                result.next = currentNode
                previous.next = result
                return listNode
            }
            previous = currentNode
            currentNode = currentNode.next
        }

        // number bigger then values from list
        previous.next = ListNode(number)
        return listNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}