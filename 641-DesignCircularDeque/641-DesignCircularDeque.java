// Last updated: 11/09/2026, 09:29:10
class MyCircularDeque {
    int[] queue;
    int frontPtr;
    int endPtr;
    int size;
    int capacity;
    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.frontPtr = 0;
        this.endPtr = 0;
        this.size = 0;
        this.capacity = k;
    }
    private int getPrev(int ptr) {
        if(ptr == 0) return this.capacity - 1;
        else return ptr-1;
    }
    private int getNext(int ptr) {
        if(ptr == this.capacity - 1) return 0;
        return ptr+1;
    }
    public boolean insertFront(int value) {
        if(this.size == this.capacity) return false;
        this.queue[frontPtr] = value;
        this.frontPtr = getPrev(this.frontPtr);
        if(this.size == 0) this.endPtr = getNext(this.endPtr);
        this.size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(this.size == this.capacity) return false;
        this.queue[endPtr] = value;
        this.endPtr = getNext(this.endPtr);
        if(this.size == 0) this.frontPtr = getPrev(this.frontPtr);
        this.size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(this.size == 0) return false;
        this.frontPtr = getNext(this.frontPtr);
        if(this.size == 1) this.endPtr = getPrev(this.endPtr);
        this.size--;
        return true; 
    }
    
    public boolean deleteLast() {
        if(this.size == 0) return false;
        this.endPtr = getPrev(this.endPtr);
        if(this.size == 1) this.frontPtr = getNext(this.frontPtr);
        this.size--;
        return true;
    }
    
    public int getFront() {
        if(this.size == 0) return -1;
        return this.queue[getNext(this.frontPtr)];
    }
    
    public int getRear() {
        if(this.size == 0) return -1;
        return this.queue[getPrev(this.endPtr)];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}