class MyCircularQueue {
    int arr[];
    int front,rear,cnt , k;
    public MyCircularQueue(int k) {
        this.k = k;
        this.front = 0;
        this.rear = -1;
        this.arr = new int[k];
        // Arrays.fill(arr,-1);
        this.cnt = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        rear = (rear+1)%k;
        arr[rear]=value;
        cnt++;
        if(front == -1) front = 0;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1)%k;
        cnt--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        else return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        else return arr[rear];
    }
    
    public boolean isEmpty() {
        if(cnt == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(cnt == k) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */