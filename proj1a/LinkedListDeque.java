public class LinkedListDeque<T> {

    private StuffNode sentinel;
    private int size;

    private class StuffNode {
        private T item;
        private StuffNode previous;
        private StuffNode next;

        public StuffNode(T x, StuffNode p, StuffNode n) {
            item = x;
            previous = p;
            next = n;
        }

        public T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }
    }
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

/*    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new StuffNode(null, null, null);
        StuffNode P = sentinel;
        size = other.size();

        for (int i = 0; i < size; i++) {
            P.next = new StuffNode(other.get(i), P, null);
            P = P.next;
        }
        P.next = sentinel;
        sentinel.previous = P;
    }*/

    public void addFirst(T item) {
        size++;
        StuffNode P = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.previous = P;
        sentinel.next = P;
    }

    public void addLast(T item) {
        size++;
        StuffNode P = new StuffNode(item, sentinel.previous, sentinel);
        sentinel.previous.next = P;
        sentinel.previous = P;
    }

    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode P = sentinel.next;
        while (P != sentinel) {
            System.out.print(P.item + " ");
            P = P.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T P = sentinel.next.item;
        size--;
        sentinel.next.next.previous = sentinel;
        sentinel.next = sentinel.next.next;
        return P;
    }

    public T removeLast() {
        if (sentinel.previous == sentinel) {
            return null;
        }
        T P = sentinel.previous.item;
        size--;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
        return P;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        StuffNode P = sentinel;
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                P = P.next;
            }
            return P.item;
        } else {
            index = size - index - 1;
            for (int i = 0; i <= index; i++) {
                P = P.previous;
            }
            return P.item;
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return sentinel.getRecursive(index + 1);
    }
}
