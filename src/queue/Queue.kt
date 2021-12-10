package linkedlist.queueu

import linkedlist.DoubleLinkedList

class ArrayListQueue<T> : IQueue<T> {

    private val list = arrayListOf<T>()

    override fun toString(): String = list.toString()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)


    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)
}

class LinkedListQueue<T> : IQueue<T> {

    private val list = DoubleLinkedList<T>()

    override fun toString(): String = list.toString()

    private var size = 0

    override val count: Int
        get() = size

    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        list.first?.let {
            list.pop().first?.value
            size--
        }
        return null
    }

    override fun peek(): T? = list.first?.value
}

