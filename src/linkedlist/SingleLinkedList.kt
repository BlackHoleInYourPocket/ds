package linkedlist

data class SingleNode<T>(var value: T, var next: SingleNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) "$value -> ${next.toString()}"
        else "$value"
    }
}

class SingleLinkedList<T> : ILinkedList<T, SingleLinkedList<T>, SingleNode<T>> {
    private var head: SingleNode<T>? = null
    private var tail: SingleNode<T>? = null
    private var size = 0

    override fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty List"
        else return head.toString()
    }

    /*
    returns node at the specific index
    O(i)
     */
    override fun nodeAt(index: Int): SingleNode<T>? {
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
    override fun push(value: T): SingleLinkedList<T> {
        head = SingleNode(value, head)
        if (tail == null) tail = head
        size++
        return this
    }

    /*
    Adds a value at the front of the list.
    tail-end insertion
    O(1)
     */
    override fun append(value: T): SingleLinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        with(tail) {
            this?.let {
                next = SingleNode(value)
                tail = it.next
                size++
            }
        }
        return this
    }

    /*
    Adds a value after specific node at the list
    O(1)
     */
    override fun insert(value: T, afterSingleNode: SingleNode<T>): SingleLinkedList<T> {
        if (tail == afterSingleNode) {
            append(value)
            return this
        }
        val newSingleNode = SingleNode(value = value, next = afterSingleNode.next)
        afterSingleNode.next = newSingleNode
        size++
        return this
    }


    /*
    Removing a value at the front of the list
     */
    override fun pop(): SingleLinkedList<T> {
        if (!isEmpty()) size--
        head = head?.next
        return this
    }

    /*
    Removing the last node of the list
     */
    override fun removeLast(): SingleLinkedList<T>? {
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
    override fun removeAfter(value: SingleNode<T>): SingleLinkedList<T> {
        if (value.next == tail) {
            tail = value
        }
        value.next?.let {
            size--
        }
        value.next = value.next?.next
        return this
    }

    override fun size() = size
}


