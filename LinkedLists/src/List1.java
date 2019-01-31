//Rishav Mitra
//March 6,2018
//This is the List1 driver class to test all the methods involving linked lists


public class List1
{
  SinglyLinkedList myList;
  
  public List1()
  {
    myList = new SinglyLinkedList();
  }
  
  /**
   *  Creates a SinglyLinkedList of 5 ordered Integer nodes
   */
  public void createList()
  {
    for (int k = 1; k <= 10; k++)
    {
      myList.addLast(new Integer(k));
    }
  }
  
  //runs a series of different methods manipulating the linked lists
  public static void main(String[] args)
  {
    
    List1 sList = new List1();
    
    sList.createList();
    
  
sList.myList.copy(sList.myList, 0);    
sList.myList.printList();
    
    
  
    
  }
}