class MinStack {
    int[] arr;
    int[] min;
    int n;
    int lastIndex=-1;
    public MinStack() {
        arr=new int[30000];
        min=new int[30000];
        n=30000;
    }
    
    public void push(int val) {
        lastIndex++;
        arr[lastIndex]=val;
        if(lastIndex==0)min[lastIndex]=val;
        else min[lastIndex] = Math.min(val,min[lastIndex-1]);
    }
    
    public void pop() {
        lastIndex--;
    }
    
    public int top() {
        return arr[lastIndex];
    }
    
    public int getMin() {
        return min[lastIndex];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */