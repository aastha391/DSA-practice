class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
        int el;
        if(!s2.isEmpty()){
            el=s2.peek();
            s2.pop();
        }
        else{
            while(s1.size()!=0){
                s2.push(s1.pop());
            }
            el=s2.peek();
            s2.pop();
        }
        return el;
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        else{
            while(s1.size()!=0){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
      if(s1.isEmpty() && s2.isEmpty()){
        return true;
      }
      else{
        return false;
      }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */