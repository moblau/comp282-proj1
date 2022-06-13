
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       String inputFilename = "input.txt";
       if (args.length > 0){
           inputFilename = args[0];
       }
       
       Scanner sc = null;
       
       try {
           sc = new Scanner (new java.io.File(inputFilename));
       }
       catch (java.io.FileNotFoundException f){
           System.out.println("No such file: " + inputFilename);
           return;
       }
       
       StringArray array = new StringArray();
       StringLinkedList linkedlist = new StringLinkedList();
       StringQueue queue = new StringQueue();
       int numWords = 0;
       
       if (sc != null){
           String word = null;
           while (sc.hasNext()){
               numWords++;
               word = sc.next();
               array.insert(word);
               linkedlist.insert(word);
               queue.enqueue(word); 
           }
       }
       
       long startTime = System.nanoTime();
       array.reverse();
       long elapsedTimeArray = System.nanoTime() - startTime;
       startTime = System.nanoTime();
       linkedlist.reverse();
       long elapsedTimeLinkedList = System.nanoTime() - startTime;
       startTime = System.nanoTime();
       queue.reverse();
       long elapsedTimeQueue = System.nanoTime() - startTime;
       
       array.print();
       linkedlist.print();
       queue.print();
       System.out.println("Number of Words: " + numWords);
       System.out.println("Time for Array Reversal (in seconds): " + elapsedTimeArray/Math.pow(10,9));
       System.out.println("Time for Linked List Reversal (in seconds): " + elapsedTimeLinkedList/Math.pow(10,9));
       System.out.println("Time for Queue/Stack Reversal (in seconds): " + elapsedTimeQueue/Math.pow(10,9));
    }
}