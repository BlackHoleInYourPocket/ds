package linkedlist

data class DoubleNode<T>(var value: T, var next: DoubleNode<T>?, var prev: DoubleNode<T>?) {
    override fun toString(): String {
        return if (next != null) "$value -> ${next.toString()}"
        else "$value"
    }
}

class DoubleLinkedList<T> : ILinkedList<T, DoubleLinkedList<T>, DoubleNode<T>> {
    val first
        get() = head
    private var head: DoubleNode<T>? = null
    private var tail: DoubleNode<T>? = null
    private var size = 0

    override fun toString(): String {
        return if (isEmpty()) "Empty List"
        else return head.toString()
    }

    override fun isEmpty(): Boolean = size == 0
    override fun size(): Int = size

    override fun nodeAt(index: Int): DoubleNode<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /*
    Adds a value at the front of the list.
    head-first insertion
    O(1)
     */
    override fun push(value: T): DoubleLinkedList<T> {
        if (isEmpty()) {
            head = DoubleNode(value, head, head)
            if (tail == null) tail = head
            size++
            return this
        }
        val lastHead = head
        head = DoubleNode(value, lastHead, null)
        lastHead?.prev = head
        size++
        return this
    }

    /*
    Adds a value at the front of the list.
    tail-end insertion
    O(1)
    */
    override fun append(value: T): DoubleLinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        val newNode = DoubleNode(value, null, tail)
        tail?.next = newNode
        tail = tail?.next
        size++
        return this
    }

    /*
    Adds a value after specific node at the list
    O(1)
     */
    override fun insert(value: T, afterSingleNode: DoubleNode<T>): DoubleLinkedList<T> {
        if (tail == afterSingleNode) {
            append(value)
            return this
        }
        val newDoubleNode = DoubleNode(value, afterSingleNode.next, afterSingleNode)
        afterSingleNode.next?.prev = newDoubleNode
        afterSingleNode.next = newDoubleNode
        size++
        return this
    }

    /*
    Removing a value at the front of the list
     */
    override fun pop(): DoubleLinkedList<T> {
        if (!isEmpty()) size--
        head = head?.next
        return this
    }

    /*
    Removing the last node of the list
     */
    override fun removeLast(): DoubleLinkedList<T>? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return this
    }

    /*
     removing a node at a particular point in the lis
     */
    override fun removeAfter(value: DoubleNode<T>): DoubleLinkedList<T> {
        if (value.next == tail) {
            tail = value
        }
        value.next?.let {
            size--
        }
        value.next = value.next?.next
        value.next?.next?.prev = value
        return this
    }
}