public class LinkedListDeque<T> {

    private class ObjectNode {
        private T item;
        private ObjectNode prev;
        private ObjectNode next;
        public ObjectNode(T item, ObjectNode prev, ObjectNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

    private ObjectNode sentinel;

    private int size;

    public LinkedListDeque() {
        size = 0;
        this.sentinel = new ObjectNode(null, null, null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
    }


    //Same as get, but uses recursion.
    public T getRecursive(int index) {
        return getRecursive(this.sentinel.next, index);
    }

    private T getRecursive(ObjectNode next, int i) {
        if (i == 0) {
            return next.item;
        }
        return getRecursive(next.next, i - 1);
    }

    //    public void addFirst(T item): Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        size += 1;
        ObjectNode objectNode = new ObjectNode(item, sentinel, sentinel.next);
        sentinel.next.prev = objectNode;
        sentinel.next = objectNode;
    }

    //    public void addLast(T item): Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        size += 1;
        ObjectNode objectNode = new ObjectNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = objectNode;
        sentinel.prev = objectNode;
    }

//    public boolean isEmpty(): Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

//    public int size(): Returns the number of items in the deque.
    public int size() {
        return size;
    }

//    public void printDeque(): Prints the items in the deque from first to last,
//    separated by a space. Once all the items have been printed, print out a new line.
    public void printDeque() {
        ObjectNode objectNode = sentinel.next;
        while (objectNode.item != null) {
            System.out.print(objectNode.item);
            objectNode = objectNode.next;
        }
        System.out.println();
    }

//    public T removeFirst(): Removes and returns the item at the front of the deque.
//    If no such item exists, returns null.
    public T removeFirst() {
        ObjectNode next = this.sentinel.next;
        sentinel.next = next.next;
        next.next.prev = sentinel;
        size = size == 0 ? size : size - 1;
        return next.item;
    }

//    public T removeLast(): Removes and returns the item at the back of the deque.
//    If no such item exists, returns null.
    public T removeLast() {
        ObjectNode prev = this.sentinel.prev;
        sentinel.prev = prev.prev;
        prev.prev.next = sentinel;
        size = size == 0 ? size : size - 1;
        return prev.item;
    }

//    public T get(int index): Gets the item at the given index, where 0 is the front,
//    1 is the next item, and so forth. If no such item exists,
//    returns null. Must not alter the deque!
    public T get(int index) {
        ObjectNode temp = this.sentinel.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

}
