package linkedlist

interface ILinkedList<K, T, N> {

    fun isEmpty(): Boolean
    fun size(): Int
    fun nodeAt(index: Int): N?
    fun push(value: K): T
    fun append(value: K): T
    fun insert(value: K, afterSingleNode: N): T
    fun pop(): T
    fun removeLast(): T?
    fun removeAfter(value: N): T

}