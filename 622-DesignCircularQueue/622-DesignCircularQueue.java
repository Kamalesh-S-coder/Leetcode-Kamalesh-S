// Last updated: 11/09/2026, 09:29:05
class MyCircularQueue {
    private int tail, head, size, n;
    private final int[] a;
    public MyCircularQueue(int k) {
        a = new int[n = k];
        tail = -1;
    }
    
    public boolean enQueue(int x) {
        if (size == n) return false;
        a[tail = ++tail % n] = x;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        head = ++head % n;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : a[head];
    }
    
    public int Rear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == n;
    }
}