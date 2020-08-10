// Name: Salam Fazil
// Student number: v00935894

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}

	public void addFront(String s) {

		A3Node newString = new A3Node(s);

		if (head == null){
			head = newString;
			newString.prev = null;
			tail = newString;
			length++;
		}else{
			head.prev = newString;
			newString.next = head;
			head = newString;
			length++;
		}

	}

	public void addBack(String s) {

		A3Node newString = new A3Node(s);

		if(head == null){
			head = newString;
			tail = newString;
			length++;
		}else{
			tail.next = newString;
			newString.prev = tail;
			newString.next = null;
			tail = newString;
		}
	}

	public int size() {
		A3Node curr = head;

		int count = 0;

		while(curr != null){
			count++;
			curr = curr.next;
		}

		length = count;

		return length;
	}

	public boolean isEmpty() {
		if(head == null && length == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void removeFront() {
		if(head == null){

		}else if(head.next == null) {
			head = null;
		}else{
			head.next.prev = null;
			head = head.next;
			length--;
		}
	}
	
	public void removeBack() {
		if (head == null) {

		} else if (head.next == null) {
			head = null;
		} else {
			tail.prev.next = null;
			tail = tail.prev;
			length--;
		}
	}

	public void rotate(int n) {
		head.prev = tail;
		tail.next = head;
		for (int i = 0; i < n; i++) {
			head = head.prev;
			tail = tail.prev;
		}
		head.prev = null;
		tail.next = null;

	}

	public void interleave(A3LinkedList other) {

		A3Node curr = head;
		A3Node currOther = other.head;
		A3Node temp;

		if(curr != null && currOther != null){
			while (curr.next != null && currOther.next != null) {
				temp = curr.next;
				curr.next = currOther.next;
				currOther.next = temp;

				curr = curr.next;
				currOther = currOther.next;
			}
		}
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/* Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	