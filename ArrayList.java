/*
 Operations on list:
 1. determine whether the array is empty 
 2. determine whether the array is full
 3. find the size of list
 4. clear the list
 5. determine whether the item is the same as a given list element
 6. insert an item in the list at the specified location
 7. remove an item from the list at the specified location
 8. replace an item at the specified location with another item
 9. retrieve an item from the list from the specified location
 10 search the list for a given item.
*/

public class ArrayList{
 //instance variables
 protected int count;//monitor the number of elements
 protected int items[];//storage of elements
 protected int move[];
 protected int count2;
 
 
 public ArrayList (int size){
  items = new int[size];
  count = 0;
  move = new int[size];
  count2 = 0;
 }
 
 public ArrayList(){
  this(10);
 }
 

public boolean isEmpty(){
 return count == 0;
}

public void clear(){

 for(int i = 0; i < count ; i++)
  items[i]  = 0;
 count = 0;
}

public boolean isFull(){
 return count == items.length;
}

public void doubleTheArray(){
 int temp[] = new int[items.length * 2];
 //transfer all elements from the old array
 for(int i = 0; i < items.length; i++)
  temp[i ] = items[i];
 items = temp;
}

public int getFirstElement(){
 if(items != null)
  return items[0];
 else return 0;
}

public int getLastElement(){
 if(items != null)
  return items[count-1];
 else return 0;
}

public void insertAt(int pos, int item){
 if(pos >= 0 && pos <= count)
    shiftRight(pos);
  items[pos] = item;
 count++;
}

private void shiftRight(int pos){
 int c = count;
 while(c > pos){
  items[c] = items[--c];
 }
}

public int getCount(){
 return count;
}
 
public void addFirst(int item){
   if(count>0)
   insertAt(0,item);
   else
      items[count++] = item;
}

public void addLast(int item){
 items[count++] = item;
}

public void removeFirst(){
   if(!isEmpty()){
      move[count2++] = items[0];
      for(int i=0; i<count; i++){
         int temp = items[i];
         items[i] = items[i+1];
         items[i+1] = temp;
      }
      count--;
   }
}

public void removeLast(){
   if(!isEmpty()){
   move[count2++]=items[count-1];
   items[count-1]=0;
   count--;
   }
}

public void retrieve(int item){
   for(int i=0; i<count2; i++){
      if(move[i]==item){
      addFirst(item);
      }
      
   }   
}
//for display
public String toString(){
 StringBuffer sb = new StringBuffer();
 sb.append("{");
 for(int i = 0; i < count; i++)
  sb.append(items[i] + " ");
 sb.append("}");
return sb.toString();
}

 //for testing purposes
 public static void main(String [] args){
  ArrayList list = new ArrayList();
  list.addFirst(6);
  list.addFirst(2);
  list.addFirst(1);
  list.removeLast();
  list.retrieve(6);
  list.removeLast();
  list.retrieve(2);
  System.out.println("list = " + list);
 }

}