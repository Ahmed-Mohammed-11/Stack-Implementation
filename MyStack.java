import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {

  public Object pop();
  public Object peek();
  public void push(Object element);
  public boolean isEmpty();
  public int size();
}

public class MyStack implements IStack{
    public class Node{ //node class with data and next
        Object data;
        Node next;
        public Node(Object elem , Node nxt){
            data = elem ;
            next = nxt;
        }
    }
    public Node top; 
    public int size;
    public MyStack(){
        top = null ;
        size = 0 ;
    }
    public Object pop(){
        //tmp to store top data to return it at the end of the method 
        Object tmp = top.data;
        top = top.next ; 
        size -- ;
        return tmp;
    }
    public Object peek(){
        return top.data;
    }
    public void push(Object element){
        //method to push element to the top of the stack 
        Node n = new Node(element , top);
        top = n ;
        size ++;
    }
    public void print(){
        Node n = top;
        System.out.print("[");
        while(n != null){
            System.out.print(n.data);
            if(n.next != null){
                System.out.print(", ");
            }
            n = n.next;
        }
        System.out.print("]");
    }
    public boolean isEmpty(){return top == null;}
    public int size(){return size;}
    public static void main(String[] args){
        //taking input array without the size 
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        MyStack Stack = new MyStack();
        //adding array elements to the stack 
        if(arr.length != 0 ){
            for(int counter = 0 ; counter < arr.length ; counter++){
                Stack.push((Object) arr[arr.length - 1 - counter]);
            }
        }
        String operation = sc.nextLine();
        //if statement to check which operation we should perform
        if(operation.equals("pop")){
            try{
                Stack.pop();
            }catch(Exception stackEmptyException){
                System.out.println("Error");
                System.exit(0);
            }
            Stack.print();
        }else if(operation.equals("peek")){
            try{
                Stack.peek();
            }catch(Exception stackEmptyException){
                System.out.println("Error");
                System.exit(0);
            }
            Object topNode = Stack.peek();
            System.out.println(topNode);
        }else if(operation.equals("push")){
            Object newElem = sc.nextLine();
            Stack.push(newElem);
            Stack.print();
        }else if(operation.equals("isEmpty")){
            boolean res = Stack.isEmpty();
            if(res){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }else if(operation.equals("size")){
            int sizeMe = Stack.size();
            System.out.println(sizeMe);
        }else{
            System.out.println("Error");
        }
    }
}
