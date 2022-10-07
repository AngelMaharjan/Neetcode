//Done by Angel
package linked_list;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//Done by Jesis
package linked_list;

public class ReorderList {
	Node head = null;
	
	class Node{
		int data = 0;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void createNodes(int[] arr) {
		
		if(arr.length == 0) return;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			Node newNode = new Node(arr[i]);
			if(head == null) {
				head = newNode;
			}else {
				newNode.next = head;
				head = newNode;
				
			}
		}
	}
	
	public void printNodes() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data +" -> ");
			node = node.next;
		}
		
		System.out.println("null");
	}
	
	public void reorderList(Node node) {
		if(node.next.next == null) {
			System.out.println("Must contain 3 or more nodes");
			return;
		}
		
		Node prev = node;
		Node curr = node.next;
		
		while(true) {
			prev = prev.next; //track node that is before last node
			curr = curr.next; //track last node
			if(curr.next == null) {
				break; //terminate loop when reached null
			}
		}
		
		Node store = node.next; //storing node's next node to another node called "store"
		node.next = curr; //storing last node to next of first node;
		curr.next = store; //connecting stored node with recently added second node
		prev.next = null; //pointing new last node's next address to null
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		
		ReorderList RL = new ReorderList();
		RL.createNodes(arr);
		System.out.println("Before");
		RL.printNodes();
		System.out.println("After");
		RL.reorderList(RL.head);
		RL.printNodes();
	}

}

