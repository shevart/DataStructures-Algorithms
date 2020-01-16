package com.shevart.datastructuresdraft.linkedlist

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

open class SinglyListTest {
    private lateinit var linkedList: LinkedList<Int>

    @Before
    fun setUp() {
        linkedList = createList()
    }

    @Test
    fun `test - pushFrontItem() - add one item`() {
        // perform
        linkedList.pushFrontItem(1)

        // check
        assertEquals(1, linkedList.getFrontItem())
    }

    @Test
    fun `test - pushFrontItem() - add two items`() {
        // perform
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)

        // check
        assertEquals(2, linkedList.getFrontItem())
    }

    @Test
    fun `test - popFrontItem() - empty list`() {
        // perform
        val result = linkedList.popFrontItem()
        val listEmpty = linkedList.isEmpty()

        // check
        assertEquals(null, result)
        assertEquals(true, listEmpty)
    }

    @Test
    fun `test - popFrontItem() - not empty list`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.popFrontItem()
        val resultForEmptyList = linkedList.popFrontItem()

        // check
        assertEquals(1, result)
        assertEquals(null, resultForEmptyList)
    }

    @Test
    fun `test - pushBackItem() - add one item, empty list`() {
        // perform
        linkedList.pushBackItem(1)

        // check
        assertEquals(1, linkedList.getFrontItem())
        assertEquals(1, linkedList.getBackItem())
    }

    @Test
    fun `test - pushBackItem() - add one item, not empty list`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        linkedList.pushBackItem(2)

        // check
        assertEquals(1, linkedList.getFrontItem())
        assertEquals(2, linkedList.getBackItem())
    }

    @Test
    fun `test - pushBackItem() - add two items, empty list`() {
        // perform
        linkedList.pushBackItem(1)
        linkedList.pushBackItem(2)

        // check
        assertEquals(1, linkedList.getFrontItem())
        assertEquals(2, linkedList.getBackItem())
    }

    @Test
    fun `test - pushBackItem() - add two items, not empty list`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        linkedList.pushBackItem(2)
        linkedList.pushBackItem(3)

        // check
        assertEquals(1, linkedList.getFrontItem())
        assertEquals(3, linkedList.getBackItem())
    }

    @Test
    fun `test - popBackItem() - empty list`() {
        // perform
        val result = linkedList.popBackItem()

        // check
        assertEquals(null, result)
    }

    @Test
    fun `test - popBackItem() - not empty list`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.popBackItem()
        val resultForEmptyList = linkedList.popBackItem()

        // check
        assertEquals(1, result)
        assertEquals(null, resultForEmptyList)
    }

    @Test
    fun `test - getItemByIndex() - empty list`() {
        // perform
        val result = linkedList.getItemByIndex(1)

        // check
        assertEquals(null, result)
    }

    @Test
    fun `test - getItemByIndex() - not empty list, index = 0`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.getItemByIndex(index = 0)

        // check
        assertEquals(1, result)
    }

    @Test
    fun `test - getItemByIndex() - not empty list, index = 2`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushBackItem(2)
        linkedList.pushBackItem(3)

        // perform
        val result = linkedList.getItemByIndex(index = 2)

        // check
        assertEquals(3, result)
    }

    @Test
    fun `test - getItemByIndex() - not empty list, index is out`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)
        linkedList.pushFrontItem(3)

        // perform
        val result = linkedList.getItemByIndex(index = 1000)

        // check
        assertEquals(null, result)
    }

    @Test
    fun `test - isContains() - empty list`() {
        // perform
        val result = linkedList.isContainsItem(1)

        // check
        assertEquals(false, result)
    }

    @Test
    fun `test - isContains() - single item list, contains`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.isContainsItem(1)

        // check
        assertEquals(true, result)
    }

    @Test
    fun `test - isContains() - single item list, not contains`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.isContainsItem(2)

        // check
        assertEquals(false, result)
    }

    @Test
    fun `test - isContains() - multiple items list, contains`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushBackItem(2)
        linkedList.pushBackItem(3)

        // perform
        val result = linkedList.isContainsItem(1)

        // check
        assertEquals(true, result)
    }

    @Test
    fun `test - isContains() - multiple items list, not contains`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)
        linkedList.pushFrontItem(3)

        // perform
        val result = linkedList.isContainsItem(4)

        // check
        assertEquals(false, result)
    }

    @Test
    fun `test - remove() - empty list`() {
        // perform
        val itemRemoved = linkedList.remove(1)

        // check
        assertEquals(false, itemRemoved)
    }

    @Test
    fun `test - remove() - single item list, contains the item`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val itemRemoved = linkedList.remove(1)
        val containsAfterWasRemoved = linkedList.isContainsItem(1)

        // check
        assertEquals(true, itemRemoved)
        assertEquals(false, containsAfterWasRemoved)
    }

    @Test
    fun `test - remove() - single item list, not contains the item`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val itemRemoved = linkedList.remove(2)
        val containsAfterWasRemoved = linkedList.isContainsItem(2)

        // check
        assertEquals(false, itemRemoved)
        assertEquals(false, containsAfterWasRemoved)
    }

    @Test
    fun `test - remove() - multiple items list, contains the item`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)
        linkedList.pushFrontItem(3)

        // perform
        val itemRemoved = linkedList.remove(1)
        val containsAfterWasRemoved = linkedList.isContainsItem(1)

        // check
        assertEquals(true, itemRemoved)
        assertEquals(false, containsAfterWasRemoved)
    }

    @Test
    fun `test - remove() - multiple items list, not contains the item`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)
        linkedList.pushFrontItem(3)

        // perform
        val itemRemoved = linkedList.remove(4)
        val containsAfterWasRemoved = linkedList.isContainsItem(4)

        // check
        assertEquals(false, itemRemoved)
        assertEquals(false, containsAfterWasRemoved)
    }

    @Test
    fun `test - isEmpty() - empty list`() {
        // perform
        val empty = linkedList.isEmpty()

        // check
        assertEquals(true, empty)
    }

    @Test
    fun `test - isEmpty() - not empty list`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val empty = linkedList.isEmpty()

        // check
        assertEquals(false, empty)
    }

    @Test
    fun `test - size() - empty list`() {
        // perform
        val size = linkedList.size()

        // check
        assertEquals(0, size)
    }

    @Test
    fun `test - size() - not empty list, single item`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val size = linkedList.size()

        // check
        assertEquals(1, size)
    }

    @Test
    fun `test - size() - not empty list, multiple items`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushFrontItem(2)
        linkedList.pushFrontItem(3)

        // perform
        val size = linkedList.size()

        // check
        assertEquals(3, size)
    }

    @Test
    fun `test - addBefore() - empty list`() {
        // perform
        val result = linkedList.addBefore(target = 1, item = 2)

        // check
        assertEquals(false, result)
    }

    @Test
    fun `test - addBefore() - single item list, target exists`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.addBefore(target = 1, item = 2)
        val firstItem = linkedList.getFrontItem()
        val lastItem = linkedList.getBackItem()

        // check
        assertEquals(true, result)
        assertEquals(2, firstItem)
        assertEquals(1, lastItem)
    }

    @Test
    fun `test - addBefore() - single item list, target not exists`() {
        // prepare
        linkedList.pushFrontItem(1)

        // perform
        val result = linkedList.addBefore(target = 2, item = 3)
        val size = linkedList.size()

        // check
        assertEquals(false, result)
        assertEquals(1, size)
    }

    @Test
    fun `test - addBefore() - multiple items list, target exists`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushBackItem(2)
        linkedList.pushBackItem(3)

        // perform
        val result = linkedList.addBefore(target = 1, item = 0)
        val firstItem = linkedList.getFrontItem()
        val size = linkedList.size()

        // check
        assertEquals(true, result)
        assertEquals(0, firstItem)
        assertEquals(4, size)
    }

    @Test
    fun `test - addBefore() - multiple items list, target not exists`() {
        // prepare
        linkedList.pushFrontItem(1)
        linkedList.pushBackItem(2)
        linkedList.pushBackItem(3)

        // perform
        val result = linkedList.addBefore(target = 0, item = 0)
        val firstItem = linkedList.getFrontItem()
        val size = linkedList.size()

        // check
        assertEquals(false, result)
        assertEquals(1, firstItem)
        assertEquals(3, size)
    }

    protected open fun createList(): LinkedList<Int> = SinglyLinkedList()
}