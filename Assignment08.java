
package assignment08;
import java.util.*;

public class Assignment08
{ 
    Node root;//the root of the bst
     
    void deleteKey(int value)
    {
        root = deleteNode(root, value); //goes to deleteNode function
    }
 
    
    Node deleteNode(Node root, int value)// recursively can delete nodes from bst
    {
        if (value < root.value)//starts to look down left of bst
        {    
            root.left = deleteNode(root.left, value);
        }
        else if (value > root.value)//if there is no key in left nodes then go right
        {
            root.right = deleteNode(root.right, value);
        }    
        
        else// if node has no children
        {
            
            if (root.left == null)
            {    
                return root.right;
            }    
            else if (root.right == null)
            {    
                return root.left;
            }        
            
            root.value = min(root.right);//if node had 2 children then go to function to find minimum
             
            root.right = deleteNode(root.right, root.value);//delete the node
        }
 
        return root;
    }
 
    int min(Node root)// find the minumum value 
    {
        int min = root.value;
        
        while (root.left != null) 
        {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }
 
    
    void fill(int value)
    {
        root = fillBST(root, value); 
    }// goes to function to fill in bst with the values
 
    
    Node fillBST(Node root, int value)// fills in all nodes
    {
        if (root == null) // if null then return a new root node
        {
            root = new Node(value);
            return root;
        }
        if (value < root.value)//since we have root we can fill out the rest
        { 
            root.left = fillBST(root.left, value);
        }
        else if (value > root.value)// fills right side if no more left side
        {
            root.right = fillBST(root.right, value);
        }
 
        
        return root;
    }
 
    void print()// goes to the function to print the bst
    {
        printBST(root); 
    }
 
    
    void printBST(Node root)//prints out the bst 
    {
        if (root != null) 
        {
            printBST(root.left);
            System.out.print(root.value + " ");
            printBST(root.right);
            
        }
        
    }
 
    
    public static void main(String[] args)
    {
        Assignment08 bst = new Assignment08();//create bst

        bst.fill(5);//fill out the bst with the values
        bst.fill(3);
        bst.fill(2);
        bst.fill(4);
        bst.fill(7);
        bst.fill(6);
        
        
        System.out.println("Inital BST");//end menu that shows before and after deleting node 3
        bst.print();
        System.out.println();
        
        bst.deleteKey(3);
        System.out.println("\nBST after deleting key '3'");
        bst.print();
        System.out.println();
    }
    
    
}    
    

