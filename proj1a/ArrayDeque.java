public class ArrayDeque<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int maxSize;
    private int FACTOR = 2;  //数组扩展倍数
    private int minLoadRatio = 4; //最小负载比例，1/4 .


    public ArrayDeque() {
        array = (T[]) new Object[8];
        maxSize = array.length; size = 0; front = 0; rear = 0;
    }

/*    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size();
        array = (T[]) new Object[size + 8];
        for (int i = 0; i < size; i++) {
            array[i] = other.get(i);
        }
        front = 0; rear = size; maxSize = array.length;
    }*/

    private void resize() {
        if (front == rear && size != 0) {
            T[] A = (T[]) new Object[size * FACTOR];
            System.arraycopy(array, front, A, 0, array.length - front);
            System.arraycopy(array, 0, A, array.length - front, rear);
            front = 0; rear = array.length; array = A; maxSize = array.length;
        } else if (size <= array.length / minLoadRatio && array.length > 8) {
            T[] A = (T[]) new Object[array.length / FACTOR];
            if (rear >= front) {
                System.arraycopy(array, front, A, 0, rear - front);
                front = 0; rear = size; array = A;
            } else {
                System.arraycopy(array, front, A, 0, array.length - front);
                System.arraycopy(array, 0, A, array.length - front, rear);
                front = 0; rear = size; array = A;
            }
            maxSize = array.length;
        } else {
            return;
        }
    }

    public void addFirst(T item) {
        resize();
        size++;
        front = (front - 1 + array.length) % array.length;
        array[front] = item;
    }

    public void addLast(T item) {
        resize();
        size++;
        array[rear] = item;
        rear = (rear + 1 + array.length) % array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        resize();
        size--;
        T P = array[front];
        array[front] = null;
        front = (front + 1 + array.length) % array.length;
        return P;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        resize();
        size--;
        rear = (rear - 1 + array.length) % array.length;
        T P = array[rear];
        array[rear] = null;
        return P;
    }

    public T get(int index) {
        int i = (front + index) % array.length;
        return array[i];
    }

    private int getFront() {
        return front;
    }

    private int getRear() {
        return rear;
    }

    private int getMaxSize() {
        return  maxSize;
    }
}
