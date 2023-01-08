/**
 * @author Thor Long
 * Date: 10/26/2022
 * CSE017
 * Heap implimentation 
 */
import java.util.ArrayList;
public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list;
	public Heap(){
		list = new ArrayList<>();
	}
 public int size(){ 
  return list.size(); 
}
  public boolean isEmpty(){
		return list.isEmpty();
  }
  public void clear(){ 
     list.clear(); 
  }
  public String toString(){
		return list.toString();
  }
  public int contains(E item) {
    int iter = 0;
    for(int i=0; i<list.size(); i++) {
        iter++;
        if(list.get(i).equals(item))
            return iter;}
    return iter;}	
    public int add(E item) {
        int iter = 0;
		list.add(item); //append item to the heap
		int currentIndex = list.size()-1; 
    //index of the last element
		while(currentIndex > 0) {
            iter++;
			int parentIndex = (currentIndex-1)/2;
			//swap if current is greater than its parent
        E current = list.get(currentIndex);
        E parent = list.get(parentIndex);
			if(current.compareTo(parent) > 0) {
				list.set(currentIndex, parent);
				list.set(parentIndex, current);}
			else
				break; // the tree is a heap
			currentIndex = parentIndex;}
        return iter;}

            public int remove() {
                int iter = 0;
                if(list.size() == 0) return iter;
             //copy the value of the last node to root
                list.set(0, list.get(list.size()-1));
             //remove the last node from the heap
                list.remove(list.size()-1);
                int currentIndex = 0;
                while (currentIndex < list.size()) {
                    iter++;
                    int left = 2 * currentIndex + 1;
                    int right = 2 * currentIndex + 2;
                    //find the maximum of the left and right nodes
                    if (left >= list.size()) 
                   break; // no left child
                    int maxIndex = left;
                E max = list.get(maxIndex);
                    if (right < list.size()) // right child exists
                        if(max.compareTo(list.get(right)) < 0)
                                maxIndex = right;
            //continued on next slide
            //continued from previous slide
	// swap if current is less than max
  E current = list.get(currentIndex);
  max = list.get(maxIndex);			 
  if(current.compareTo(max) < 0){
		list.set(maxIndex, current);
		list.set(currentIndex, max);
		currentIndex = maxIndex;
	}
	else
		break; // the tree is a heap
 }
 return iter;
}
/**
 * O(n)
 * @return
 */
public int height(){
    return height(0);
}
/**
 * O(n^)
 * @param node
 * @return
 */
public int height(int node){//index of node in arraylist
    if(node < list.size()){
        int leftHeight = height(2 * node + 1);
        int rightHeight = height(2 * node + 2);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    return 0;
}
/**
 * O(n^2)
 * @return
 */
public boolean isBalanced(){
    return isBalanced(0);
}
/**
 * O(n^2)
 * @param node
 * @return
 */
public boolean isBalanced(int node){
    if(node >= list.size())
    return true;
    int leftHeight = height(2 * node + 1);
    int rightHeight = height(2 * node + 2);
    int diff = Math.abs(leftHeight - rightHeight);
    if(diff > 1)
        return false;
    return isBalanced(2 * node + 1) && isBalanced(2 * node + 2);
}
}