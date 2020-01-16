package com.shevart.datastructuresdraft.linkedlist

class SinglyLinkedList<V> : LinkedList<V> {
    private var firstItem: Node<V>? = null

    override fun pushFrontItem(item: V) {
        firstItem = Node(item, firstItem)
    }

    override fun getFrontItem(): V? {
        return firstItem?.data
    }

    override fun popFrontItem(): V? {
        val currentFirstItem = firstItem?.data
        firstItem = firstItem?.next
        return currentFirstItem
    }

    override fun pushBackItem(item: V) {
        if (firstItem == null) {
            pushFrontItem(item)
            return
        }
        val nextNode = findLastNode()
        nextNode?.next = Node(item)
    }

    override fun getBackItem(): V? {
        return findLastNode()?.data
    }

    override fun popBackItem(): V? {
        if (firstItem?.next == null) {
            return popFrontItem()
        }
        val newLastNode = findNodeBy { node -> node.next?.next == null }
        val currentBackItem = newLastNode?.next?.data
        newLastNode?.next = null
        return currentBackItem
    }

    override fun getItemByIndex(index: Int): V? {
        if (index == 0) {
            return firstItem?.data
        }
        var count = 1
        var nextNode = firstItem?.next
        while (count++ != index) {
            nextNode = nextNode?.next
            if (nextNode == null) {
                return null
            }
        }
        return nextNode?.data
    }

    override fun isContainsItem(item: V): Boolean {
        return findNodeBy { node -> node.data == item } != null
    }

    override fun remove(item: V): Boolean {
        if (firstItem?.data == item) {
            firstItem = firstItem?.next
            return true
        }
        val nodeBeforeTarget = findNodeBy { node -> node.next?.data == item }
            ?: return false

        nodeBeforeTarget.next = nodeBeforeTarget.next?.next
        return true
    }

    override fun isEmpty(): Boolean {
        return firstItem == null
    }

    override fun addBefore(target: V, item: V): Boolean {
        if (firstItem?.data == target) {
            pushFrontItem(item)
            return true
        }
        return false
    }

    override fun addAfter(pivotItem: V, item: V): Boolean {
        return false
    }

    override fun size(): Int {
        var size = 0
        var nextNode = firstItem
        while (nextNode != null) {
            size++
            nextNode = nextNode.next
        }
        return size
    }

    private fun findLastNode(): Node<V>? {
        return findNodeBy { node -> node.next == null }
    }

    private inline fun findNodeBy(condition: (node: Node<V>) -> Boolean): Node<V>? {
        var next = firstItem
        while (next != null) {
            if (condition(next)) {
                return next
            }
            next = next.next
        }
        return null
    }

    private data class Node<V>(
        val data: V,
        var next: Node<V>? = null
    )
}