/**
 * @author Thor Long
 * Date: 11/17/2022
 * CSE017
 * Binary Search Tree implimentation 
 */ 
public class BST<E extends Comparable<E>> {
	private TreeNode root;
	private int size;
	
	private class TreeNode{
		E value;
		TreeNode left;
		TreeNode right;
		TreeNode(E val){
			value = val;
			left = right = null;
		}
	}
    BST(){ 
        root = null;
        size = 0; 
     }
   public int size() { 
     return size; 
   }
       public boolean isEmpty() { 
       return (size == 0); 
     }
       public void clear() { 
       root = null; 
       size = 0;
     }
     // Search method
public int contains(E item) {
    int iter = 0;
	TreeNode node = root;
	while (node != null) {
        iter++;
		if( item.compareTo(node.value) < 0)
			node = node.left;
		else if (item.compareTo(node.value)> 0)
			node = node.right;
		else
			return iter;
	}
	return iter;
}
// Method add()
public int add(E item) {
    int iter = 0;
	if (root == null) // first node to be inserted
		root = new TreeNode(item);
	else {
		TreeNode parent, node;
		parent = null; node = root;
		while (node != null) {// Looking for a leaf node
            iter++;
       parent = node;
			if(item.compareTo(node.value) < 0) {
				node = node.left; }
			else if (item.compareTo(node.value) > 0) {
				node = node.right; }
			else
				return iter; // duplicates are not allowed
		}
		if (item.compareTo(parent.value)< 0)
			parent.left = new TreeNode(item);
		else
			parent.right = new TreeNode(item);
	}
	size++;
  return iter;}
// Method remove()
public int remove(E item) {
    int iter = 0;
	TreeNode parent, node;
	parent = null; node = root;
  // Find item first
	while (node != null) {
        iter++;
			if (item.compareTo(node.value) < 0) {
				parent = node;
				node = node.left;
			}
			else if (item.compareTo(node.value) > 0) {
				parent = node;
				node = node.right;
			}
			else
				break; // item found
	}
//method continued on next slide
if (node == null) // item not in the tree
			return iter;

// Case 1: node has no children
if(node.left == null && node.right == null){
		if(parent == null){ // delete root
			root = null;
		}
		else{
			changeChild(parent, node, null);
		}
}
//method continued on next slide
// case 2: one right child
else if(node.left == null){
    if (parent == null){ // delete root
        root = node.right;
    }
    else
        changeChild(parent, node, node.right);
}
// case 2: one left child
else if(node.right == null){
    if (parent == null){ // delete root
        root = node.left;
    }
    else
        changeChild(parent, node, node.left);
}
// Case 3: node has two children
else {
    TreeNode rightMostParent = node;
    TreeNode rightMost = node.left;
    // go right on the left subtree
    while (rightMost.right != null) {
        iter++;
        rightMostParent = rightMost;
        rightMost = rightMost.right;
    }
// copy the value of rigthMost to node
    node.value = rightMost.value;
    //delete rigthMost
     changeChild(rightMostParent, rightMost, 
              rightMost.left);
}
size--;
return iter;}
private void changeChild(TreeNode parent,
      TreeNode node, TreeNode newChild){
		if(parent.left == node)
			parent.left = newChild;
		else
			parent.right = newChild;
	}

// Recursive method inorder()
public void inorder() {
	inorder(root);
}
private void inorder(TreeNode node) {
	if (node != null) {
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
}
// Recursive method preorder()
public void preorder() {
	preorder(root);
}
private void preorder(TreeNode node) {
	if (node != null) {
		System.out.print(node.value + " ");
		preorder(node.left);
		preorder(node.right);
	}
}
// Recursive method postorder()
public void postorder() {
	postorder(root);
}
private void postorder(TreeNode node)  {
	if (node != null) {
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value + " ");	
	}
}
/**
 * O(n)
 * @return
 */
public int height(){
    return height(root);
}
/**
 * O(N)
 * @param node
 * @return
 */
public int height(TreeNode node){
    if(node != null){
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    return 0;
}
/**
 * O(n^2)
 * @return
 */
public boolean isBalanced(){
    return isBalanced(root);
}
/**
 * O(n^2)
 * @param node
 * @return
 */
public boolean isBalanced(TreeNode node){
    if(node == null)
    return true;
    int leftHeight = height(node.left);//O(n)
    int rightHeight = height(node.right);//O(n)
    int diff = Math.abs(leftHeight - rightHeight);
    if(diff > 1)
        return false;
    return isBalanced(node.left) && isBalanced(node.right);
}
}
   
