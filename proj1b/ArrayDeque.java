public class ArrayDeque<T> implements Deque<T> {

    private T[] array;
    private int size = 0;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
    }

//    public void addFirst(T item): Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T item) {
        add(0, item);
    }


//    public void addLast(T item): Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T item) {
        add(size, item);
    }

    private T remove(int index) {
        if (size == 0) {
            return null;
        }
        T result = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size -= 1;
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return result;
    }

    private void add(int index, T item) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size += 1;
        if (size == array.length) {
            resize(size * 2);
        }
    }


    private void resize(int capability) {
        T[] newArray = (T[]) new Object[capability];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }



//    public int size(): Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

//    public void printDeque(): Prints the items in the deque from first to last,
//    separated by a space. Once all the items have been printed, print out a new line.
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.get(i));
        }
        System.out.println();
    }

//    public T removeFirst(): Removes and returns the item at the front of the deque.
//    If no such item exists, returns null.
    @Override
    public T removeFirst() {
        return remove(0);
    }



//    public T removeLast(): Removes and returns the item at the back of the deque.
//    If no such item exists, returns null.
    @Override
    public T removeLast() {
        return  remove(size - 1);
    }

//    public T get(int index): Gets the item at the given index, where 0 is the front,
//    1 is the next item, and so forth. If no such item exists, returns null.
//    Must not alter the deque!
    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return array[index];
    }

}
