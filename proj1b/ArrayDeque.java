public class ArrayDeque<T> implements Deque<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int maxSize;
    public int FACTOR = 2;  //数组扩展倍数
    public int minLoadRatio = 4; //最小负载比例，1/4 .


    public ArrayDeque() {
        array = (T[]) new Object[8];
        maxSize = array.length; size = 0; front = 0; rear = 0;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size();
        array = (T[]) new Object[size + 8];
        for (int i=0; i < size; i++) {
            array[i] = other.get(i);
        }
        front = 0; rear = size; maxSize = array.length;
    }

    public void resize() {
        if (front == rear && size != 0) {
            T[] A = (T[]) new Object[size * FACTOR];
            System.arraycopy(array, front, A, 0, array.length-front);
            System.arraycopy(array, 0, A, array.length-front,rear);
            front = 0; rear = array.length; array = A; maxSize = array.length;
        } else if (size <= array.length / minLoadRatio && array.length > 8) {
            T[] A = (T[]) new Object[array.length / FACTOR];
            if (rear >= front) {
                System.arraycopy(array, front, A, 0, rear - front);
                front = 0; rear = size; array = A;
            } else {
                System.arraycopy(array, front, A, 0, array.length-front);
                System.arraycopy(array, 0, A, array.length-front,rear);
                front = 0; rear = array.length; array = A;
            }
            maxSize = array.length;
        } else {
            return;
        }
    }

    @Override
    public void addFirst(T item) {
        resize();
        size++;
        front = (front - 1 + array.length) % array.length;
        array[front] = item;
    }

    @Override
    public void addLast(T item) {
        resize();
        size++;
        array[rear] = item;
        rear = (rear + 1 + array.length) % array.length;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i=front; i != rear; i = (i+1) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;

        resize();
        size--;
        T P = array[front];
        array[front] = null;
        front = (front + 1 + array.length) % array.length;
        return P;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;

        resize();
        size--;
        rear = (rear - 1 + array.length) % array.length;
        T P = array[rear];
        array[rear] = null;
        return P;
    }

    @Override
    public T get(int index) {
        int i = (front + index) % array.length;
        return array[i];
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getMaxSize() {
        return  maxSize;
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for (int i=0; i < 100; i++) {
            L.addFirst(i);
            L.addLast(i);
        }
        System.out.println(L.size());

        ArrayDeque<Integer> P = new ArrayDeque<>(L);
        P.addLast(23);
        P.addFirst(999);
        System.out.println(P.size());
        P.removeLast();
        System.out.println(P.removeFirst());
        P.printDeque();
        System.out.println(P.get(4));
    }
}

