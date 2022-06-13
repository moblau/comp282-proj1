public class StringLinkedList{
    private Node head, tail;
    private int size;
    
    public StringLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    //Inserts a string at the tail of the linked list.
    public void insert(String word){
       if (head == null){
          head = new Node(word);
          tail = head;
       }
       else{
          tail.setNext(new Node(word));
          tail = tail.getNext();
       }
       size++;
    }
    
    //Removes all strings matching the arguement.
    public void remove(String word){
       if (head == null){
          return;
       }
       while (head.getString() == word){
          if (head == tail){
             head = null;
             tail = null;
             return;
          }
          head=head.getNext();
          size--;
       }
       Node currNode = head.getNext();
       Node prevNode = head;    
       while (currNode != null){
          if (currNode.getString() == word){
             if ( currNode == tail){
                 tail = prevNode;
             }
             prevNode.setNext(currNode.getNext());
             currNode = currNode.getNext();
             size--;
          }
          else{
             prevNode = currNode;
             currNode = currNode.getNext();
          }
       }
    }
    
    //Returns the string at the index.
    public String getStringAtIndex(int index){
        if (index > size-1 || index < 0){
            return null;
        }
        Node tempNode = head;
        while (index > 0){
            tempNode = tempNode.getNext();
            index--;
        }
        return tempNode.getString();
    }
    
    //Removes the string at the index.
    public String removeStringAtIndex(int index){
        if (index > size-1 || index < 0){
            return null;
        }
        if (size == 1){
            String word = head.getString();
            head = null;
            tail = null;
            size--;
            return word;
        }
        if (index == 0){
            String word = head.getString();
            head = head.getNext();
            size--;
            return word;
        }
        Node prevNode = head;
        while (index > 1){
            prevNode = prevNode.getNext();
            index--;
        }
        Node currNode = prevNode.getNext();
        prevNode.setNext(currNode.getNext());
        size--;
        if (currNode == tail){
            tail=prevNode;
        }
        return currNode.getString();
    }
    
    //Reverses the linked list.
    public void reverse(){
        Node currTail = tail;
        while (currTail != head){
            Node thisNd = head;
            Node nextNd = thisNd.getNext();
            while (nextNd != currTail){
                thisNd = nextNd;
                nextNd= nextNd.getNext();
            }
            nextNd.setNext(thisNd);
            currTail = thisNd;
        }
        head.setNext(null);
        Node tempNd = head;
        head = tail;
        tail = tempNd;
    }
    
    //Returns the size of the linked list.
    public int getSize(){
        return size;
    }
    
    //Returns true if the linked list is empty.
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
    
    //Prints the contents of the linked list.
    public void print(){
        Node tempNode = head;
        while (tempNode != null){
           System.out.println(tempNode.getString());
           tempNode = tempNode.getNext();
        }
    }
    
    //Class declaration for a node of the linked list.
    private class Node{
        String word;
        Node next;
        
        public Node(String word){
           next = null;
           this.word = word;         
        }
        
        public String getString(){
           return word;
        }
        
        public Node getNext(){
           return next;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
    }
}