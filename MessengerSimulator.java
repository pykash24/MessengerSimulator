import java.util.*;

//import java.io.*;
public class MessengerSimulator {
	Node head;
	class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static int searchlist(Node head,int searchnode){
		int count=1;
		Node current = head;
		while(current!=null){
			if(current.data == searchnode)
				return count;
			current = current.next;
			count++;
		}
		return count;
	}
	public void push(int new_data){
		Node new_node=  new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	public void delete(int key)
	{
        Node temp = head, prev = null; 
        if (temp != null && temp.data == key) 
        { 
            head = temp.next; 
            return; 
        } 
  
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        if (temp == null) return; 
  
        prev.next = temp.next; 
	}
	public void showlist(){
		Node tnode= head;
		while(tnode!=null){
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}
	public void show(int n,int min[],int max[]){
		for(int j=1;j<=n;j++){
			 System.out.println(min[j]+" "+max[j]);
			  }
	}

public void addlist(Node h,int n,int min[],int max[]){
	Node temp= h;
	int loc;
	for(int i=1;i<=n;i++){
  loc = searchlist(temp,i);  
  if(loc>max[i]){
	  max[i]=loc;
  }
  else if(loc<=min[i])
  {
	  min[i]=loc;
  }
	}  
}
	public static void main(String []args){
		Scanner obj = new Scanner(System.in); 
		int n = obj.nextInt();
		  int m= obj.nextInt();
		 int min[] = new int[n+1];
	      int max[] = new int[n+1];
	      for(int i=1;i<=n;i++){
	    	  min[i] = i;
	    	  max[i]= i;
	      }
		MessengerSimulator list = new MessengerSimulator();

		int mn=n;
		for(int i=0;i<n;i++){		
			list.push(mn);
			mn--;
		}
		int arr[] = new int[m];
		for(int i=0;i<m;i++){	
			arr[i]= obj.nextInt();
		}
		System.out.println();
		   list.addlist(list.head,n,min,max);
		for(int i=0;i<m;i++){
			list.delete(arr[i]);	
			list.push(arr[i]);	
          list.addlist(list.head,n,min,max);
		}
        list.show(n,min,max);
        obj.close();
	}
}
