import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// Preparing the collections
		Stack<String> stack = new Stack<>();
		ArrayList<String> aList = new ArrayList<>();
		LinkedList<String> lList = new LinkedList<>();
		LinkedList<String> queue = new LinkedList<>();
		PriorityQueue<String> pqueue = new PriorityQueue<>();
		// filling the array list
		aList.add("Ohio");
		aList.add("Kansas");
		aList.add("California");
		aList.add("Washington");
		aList.add("Pennsylvania");
		// filling the linked list
		lList.addLast("New Jersey");
		lList.addLast("Vermont");
		lList.addLast("Ohio");
		lList.addLast("New Mexico");
		lList.addLast("Florida");
		lList.addLast("North Carolina");
		// filling the stack
		stack.push("New York");
		stack.push("California");
		stack.push("Montana");
		// filling the queue
		queue.offer("Pennsylvania");
		queue.offer("Texas");
		queue.offer("New York");
		queue.offer("Connecticut");
		// filling the priority queue
		pqueue.offer("Delaware");
		pqueue.offer("Wyoming");
		pqueue.offer("Utah");
		pqueue.offer("New Hampshire");
		pqueue.offer("Ohio");

		// Testing the method combineNoDuplicates
		Collection<String> c = (ArrayList<String>) aList.clone();
		combineNoDuplicates(c, lList);
		combineNoDuplicates(c, stack);
		combineNoDuplicates(c, queue);
		combineNoDuplicates(c, pqueue);
		System.out.println("Combined Collection with no duplicates (iterative):");
		System.out.println("---------------------------------------------------");
		printCollection(c);

		// Testing the method recursiveCombineNoDuplicates
		c.clear();
		c = (ArrayList<String>) aList.clone();
		recursiveCombineNoDuplicates(c, lList);
		recursiveCombineNoDuplicates(c, stack);
		recursiveCombineNoDuplicates(c, queue);
		recursiveCombineNoDuplicates(c, pqueue);
		System.out.println("\nCombined Collection with no duplicates (recursive):");
		System.out.println("---------------------------------------------------");
		printCollection(c);

		// Testing the method subCollection with start = end
		System.out.println("\nSub List from the collection (index 5 to 5):");
		System.out.println("--------------------------------------------");
		ArrayList<String> subList = new ArrayList<>();
		subCollection(c, 5, 5, subList);
		printCollection(subList);

		// Testing the method subCollection with start < end
		System.out.println("\nSub List from the collection (index 5 to 8):");
		System.out.println("--------------------------------------------");
		subCollection(c, 5, 8, subList);
		printCollection(subList);

		// Testing the method subCollection with start > end
		System.out.println("\nSub List from the collection (index 6 to 4):");
		System.out.println("--------------------------------------------");
		try {
			subCollection(c, 6, 4, subList);
			printCollection(subList);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid start and end indices.");
		}

		// Testing the method splitCollection with the delimiter in the collection
		System.out.println("\nSplit the collection (delimiter = \"Florida\"):");
		System.out.println("-----------------------------------------------");
		ArrayList<String> subL1 = new ArrayList<>();
		ArrayList<String> subL2 = new ArrayList<>();
		splitCollection(c, "Florida", subL1, subL2);
		System.out.println("First part of the collection:");
		printCollection(subL1);
		System.out.println("\nSecond part the collection:");
		printCollection(subL2);

		// Testing the method splitCollection with the delimiter not in the collection
		System.out.println("\nSplit the collection (delimiter = \"Arkansas\"):");
		System.out.println("------------------------------------------------");
		subL1.clear();
		subL2.clear();
		splitCollection(c, "Arkansas", subL1, subL2);
		System.out.println("First part of the collection:");
		printCollection(subL1);
		System.out.println("\nSecond part of the collection:");
		printCollection(subL2);
	}

	/*
	 * Generic method that prints the elements of the collection c
	 * six elements per line
	 * @param c collection of elements to print
	 * @return no return value
	 *
	*/
	public static <E> void printCollection(Collection<E> c) {
		int index = 0;
		if(c.size() == 0)
			System.out.print("Empty");
		Iterator<E> iter = c.iterator();
		while(iter.hasNext()) {
			index++;
			System.out.print("\"" + iter.next() + "\" ");
			if(index == 6) {
				index=0;
				System.out.println();
			}
		}
		System.out.println();
	}
	/*
	 * Generic method that combines the elements of two collections c1, and c2
	 * without repeating the elements that exist in c1 and c2
	 * @param c1 the first collection
	 * @param c2 the second collection
	 * @return no return  value - the result is in c1
	 *
	*/
	public static <E> void combineNoDuplicates(Collection<E> c1,
											   Collection<E> c2) {
	}
	/*
	 * Generic method that combines the elements of two collections c1, and c2
	 * without repeating the elements that exist in c1 and c2, recursively
	 * @param c1 the first collection
	 * @param c2 the second collection
	 * @return no return  value - the result is in c1
	 *
	*/
	public static <E> void recursiveCombineNoDuplicates(Collection<E> c1,
												        Collection<E> c2) {
	}
	/*
	 * Generic method that extracts the elements
	 * from index start to index end (exclusive)
	 * from c and adds them to subC
	 * @param c the first collection that stays unchanged
	 * @param subC the second collection where the extracted elements are added
	 * if start=end, subC is Empty
	 * if start > end, the method throws an exception
	 * @return no return  value - the result is in subC
	 * @throws ArrayIndexOutOfBoundsException
	*/
	public static <E> void subCollection(Collection<E> c,
								   		 int start,
								   		 int end,
								   		 Collection<E> subC) throws ArrayIndexOutOfBoundsException{
	}
	/*
	 * Generic method that splits the collection c into two sub collections
	 * using the parameter delimiter as the cut point
	 * @param c the collection that is used for splitting and stays unchanged
	 * @param c1 the collection that contains the elements
	 * from the first to delimiter (inclusive)
	 * @param c2 the collection that contains the elements
	 * from delimiter (exclusive) to the last element in c
	 * if c does not contain delimiter, c1 is equal to c and c2 is empty
	 * @return no return  value - the result is in c1 and c2
	*/
	public static <E> void splitCollection(Collection<E> c,
										   E delimiter,
										   Collection<E> c1,
										   Collection<E> c2) {

	}
}
