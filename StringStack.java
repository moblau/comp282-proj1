public class StringStack{
    private StringLinkedList stack;
    private int size;
    
    public StringStack(){
        stack = new StringLinkedList();
        size = 0;
    }
    
    //Deletes the string at the top of the stack and returns its value.
    public String pop(){
        if (stack.isEmpty() == true){
            return null;
        }
        size--;
        return stack.removeStringAtIndex(size);
    }
    
    //Inserts a string at the top of the stack.
    public void push(String word){
        size++;
        stack.insert(word);
    }
    
    //Returns the value at the top of the stack.
    public String peek(){
        if (stack.isEmpty() == true){
            return null;
        }
        return stack.getStringAtIndex(size-1);
    }
    
    //Prints the contents of the stack.
    public void print(){
        stack.print();
    }
    
    //Returns the size of the stack.
    public int getSize(){
        return size;
    }
}