class MyCircularQueue {
    int[] arr;
    int front, rear, cnt, k;

    public MyCircularQueue(int k) {
        this.k = k;
        this.arr = new int[k]; // FIXED: Initializing the instance variable
        this.front = 0;        // Points to the first element
        this.rear = -1;        // Points to the last inserted element
        this.cnt = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // Move rear forward circularly, THEN insert
        rear = (rear + 1) % k; 
        arr[rear] = value;
        cnt++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // Move front forward circularly
        front = (front + 1) % k; 
        cnt--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return cnt == 0;
    }
    
    public boolean isFull() {
        return cnt == k;
    }
}