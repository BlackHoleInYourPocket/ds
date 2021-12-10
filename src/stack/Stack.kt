package stack

class Stack<T : Any> : IStack<T> {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("---bottom---")
    }

    /*
    append the value passed as parameter to the end of the ArrayList
     */
    override fun push(element: T) {
        storage.add(element)
    }

    /*
     return the last element you’have inserter.
     */
    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    /*
    look at the top element of the stack without mutating its contents.
     */
    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

}
