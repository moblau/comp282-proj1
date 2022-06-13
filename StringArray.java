public class StringArray {
    private String[] stringArray;
    private int capacity, size;
    
    public StringArray() {
       capacity = 10;
       stringArray = new String[capacity];     
       size = 0;
    }
    
    //Inserts a string at the end of the array. If there is no more space in the array,
    //it will double in size.
    public void insert(String word){
       if ( size == capacity ) {
           capacity*=2;
           String[] tempArray = new String[capacity];
           for ( int i = 0; i < size; i ++ ) {
               tempArray[i] = stringArray[i];
           }
           stringArray = tempArray;
           stringArray[size] = word;
       }
       else{
           stringArray[size] = word;       
       }
       size++;
    }
    
    //Deletes all words in the array matching the argument.
    public void delete (String del){
       for ( int i = 0; i < size; i ++ ){
           if (stringArray[i] == del){
               for ( int j = i; j < size; j++ ){
                   stringArray[j]=stringArray[j+1];
               }
               size--;
           }
       }
    }
    
    //Reverse the array in-place.
    public void reverse(){
        for ( int i = 0, j = size-1; i < size/2; i ++, j--){
            String temp = stringArray[i];
            stringArray[i]=stringArray[j];
            stringArray[j]=temp;
        }
    }
    
    //Returns the size of the array.
    public int getSize(){
        return size;
    }  
    
    //Prints the contents of the array.
    public void print() {
        for ( int i = 0; i < size; i ++) {
            System.out.println(stringArray[i]);
        }
    }
    
   
}
