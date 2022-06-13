public class StringQueue{
    private StringLinkedList queue;
    private int size;
    
    public StringQueue(){
        queue = new StringLinkedList();
        size = 0;
    }
    
    //Removes the string at the front of the queue and returns its value.
    public String dequeue(){
        if (queue.isEmpty() == true){
            return null;
        }
        size--;
        return queue.removeStringAtIndex(0);
    }
    
    //Inserts a string at the end of the queue.
    public void enqueue(String word){
        size++;
        queue.insert(word);
    }
    
    //Returns the value of the front of the queue.
    public String peek(){
        if (queue.isEmpty() == true){
            return null;
        }
        return queue.getStringAtIndex(0);
    }
    
    //Reverses the strings in the queue.
    public void reverse(){
        StringStack stack = new StringStack();
        while ( getSize() > 0 ){
            stack.push(dequeue());
        }
        while ( stack.getSize() > 0){
            enqueue(stack.pop());
        }
    }
    
    //Prints the contents of the queue.
    public void print(){
        queue.print();
    }
    
    //Returns the size of the queue.
    public int getSize(){
        return size;
    }
}