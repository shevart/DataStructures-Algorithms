package com.shevart.datastructuresdraft.linkedlist

interface LinkedList<V> {
    fun pushFrontItem(item: V)

    fun getFrontItem(): V?

    fun popFrontItem(): V?

    fun pushBackItem(item: V)

    fun getBackItem(): V?

    fun popBackItem(): V?

    fun getItemByIndex(index: Int): V?

    fun isContainsItem(item: V): Boolean

    fun remove(item: V): Boolean

    fun isEmpty(): Boolean

    fun addBefore(target: V, item: V): Boolean

    fun addAfter(pivotItem: V, item: V): Boolean

    fun size(): Int
}