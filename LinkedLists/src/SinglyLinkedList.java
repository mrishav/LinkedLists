import java.util.*;

//Rishav Mitra
//March 6,2018
//This is SinglyLinkedList class that contains several different methods to get items in a linked list as well as manipulate them

public class SinglyLinkedList {
	private ListNode first; // first element
	private ListNode last; // last element

	/**
	 * Constructor for the SinglyLinkedList object Generates an empty list.
	 */
	public SinglyLinkedList() {
		first = null;
	}

	/**
	 * Returns the first element in this list.
	 *
	 * @return the first element in the linked list.
	 */
	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		} else
			return first.getValue();
	}

	/**
	 * Returns the last element in this list.
	 *
	 * @return the last element in the linked list.
	 */
	public Object getLast() {
		if (last == null) {
			throw new NoSuchElementException();
		} else
			return last.getValue();
	}

	// inserts value at the beginning of the linked list
	public void addFirst(int value) {
		// creates a new list node with the (value, the item after)-so says
		// first is located after this list node(shifting first) then it
		// reassigns the new list node to the reference first
		first = new ListNode(value, first);

		if (first.getNext() == null)
			last = first;
	}

	// inserts an element at the end of a linked list
	public void addLast(int value) {

		// if no items in the list
		if (first == null) {
			first = new ListNode(value, null);
			last = first;
		} else {

			ListNode temp = new ListNode(value, null);
			last.setNext(temp);
			last = temp;
		}
	}

	// returns entire size of the linked list by iterating through all the nodes
	public int size() {
		ListNode currentNode = first;
		int count = 0;

		while (currentNode != null) {
			count++;
			if (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			} else {
				return count;
			}
		}
		return -1;
	}

	// toString method to print out the linked list components
	public void printList() {
		ListNode currentNode = first;
		System.out.print("[");
		if (first == null && last == null) {
			System.out.print("]");
		}
		while (currentNode != null) {
			System.out.print(currentNode.getValue());

			if (currentNode.getNext() != null) {
				System.out.print(", ");
				currentNode = currentNode.getNext();
			} else {
				System.out.println("]");
				return;
			}

		}
	}

	// insert an integer in a sorted list at the proper location
	public void insertInOrder(int value) {
		if (first == null) {
			addFirst(value);
		}

		// If the passed value is the lowest value
		if (((Integer) (first.getValue())) > value) {
			addFirst(value);
		}
		// If the passed value is the highest value
		else if (((Integer) last.getValue()) < value) {
			addLast(value);
		}
		// If passed value is in between
		else {
			ListNode currentNode = first;
			while (currentNode.getNext() != null) {
				// If the node is bigger than the value, then insert here

				// you must do get next because you if u look at current node
				// and realize that the value is smaller than current node there
				// is no set previous method
				if (((Integer) currentNode.getNext().getValue()) > value) {
					ListNode temp = new ListNode(value, currentNode.getNext());
					currentNode.setNext(temp);
					return;
				}
				// If the node is smaller than the value, continue
				else {
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	// remove element from linked list and return it
	public int remove(int x) {
		if (first == null) {
			return -999;
		}

		ListNode currentNode = first;
		if (currentNode.getValue() == x) {
			return (Integer) currentNode.getValue();
		}

		// Loop until the end
		while (currentNode.getNext() != null) {
			// If int is found

			// must do get next because no way to override value of current
			// node, only the next node
			if (currentNode.getNext().getValue() == x) {
				ListNode removingNode = currentNode.getNext();
				// sets next node to the next next node(the node after the next
				// node)

				currentNode.setNext(removingNode.getNext());
				return (Integer) removingNode.getValue();
			}
			// Not found, continue looping
			else {
				currentNode = currentNode.getNext();
			}
		}
		// Got through all of it and didn't find it
		return -999;

	}

	/* User provides an int num and a sorted list input. The output list contains only elements from input less 
	 * than or equal too
	 * num
	 */

	public SinglyLinkedList copy(SinglyLinkedList input, int num) {
		ListNode current = input.first;
		
		SinglyLinkedList output = new SinglyLinkedList();
		while(current!=null&&current.getValue()<=num){
			output.insertInOrder(current.getValue());
			current=current.getNext();
			
		}
			
		current.setNext(null);
		last= current;
			
			
			
			return output;

	}
/* Sorted list is inserted
 * if the value in the next node is bigger than num 
 * end the list at current so the list should only contain values less than num
 
 */
	public void cut(SinglyLinkedList input, int num) {

		ListNode current = input.first;
		
		while(current.getNext()!=null&&current.getNext().getValue()<=num){
			current=current.getNext();
		}
		current.setNext(null);
last= current;
		
	}
}