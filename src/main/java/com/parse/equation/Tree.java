package com.parse.equation;

import com.parse.equation.Node;
import com.parse.equation.Token;
import java.lang.StringBuilder ;

// our class Tree will help
// us to parse inputs
// there's a rootNode ( like the base of a tree )
// that can have multiple childrens
public final class Tree 
{
	private Node root;
	public Tree ()            {}
	public Tree ( Node root ) { this.root = root; }
	
	public static void main ( String... args ) 
	{

		// root node
		Node root = new Node ( 'c' );

		// Create a new tree
		Tree tree = new Tree ( root );
		tree.add ( new Node ( 't' ) ); 
		tree.add ( new Node ( 'a' ) );
		tree.add ( new Node ( 'b' ) );
		tree.add ( new Node ( 'k' ) );
		tree.add ( new Node ( 's' ) );

		tree.print();
	}

	// 'appending' node to the tree
	private Node pushNode ( Node node, Node current )
	{
		System.out.println( "the current : " + current );
		if ( current == null ) return node;
		if ( current.l == null )  current.l = pushNode ( node, current.l ) ;
		else if ( current.r == null )  current.r = pushNode ( node, current.r ) ;
		else { 
			current.l = pushNode ( node, current.l );
		}

		return current;
	}


	public void add ( Node node ) { this.root = pushNode ( node, root); }

	// shift the node place by one
	// similar to shifting the idx of an element by one in an array.
	public Node shiftNodeByOne ( Node node, Node current )
	{
		return null;
	}

	public static boolean isOP ( char value )
	{
		boolean return_ = true;
		switch ( value )
		{
			case '+':
				break;
			case '-':
				break;
			case '*':
				break;
			case '(':
				break;
			case ')':
				break;
			case ',':
				break;
			default:
				return_ = false;
				break;
		}

		return return_;
	}

	public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node current ) {
	    if (current != null) {
		sb.append(padding);
		sb.append(pointer);
		sb.append(current.value);
		sb.append("\n");

		StringBuilder paddingBuilder = new StringBuilder(padding);
		paddingBuilder.append("│  ");

		String paddingForBoth = paddingBuilder.toString();
		String pointerForRight = "└──";
		String pointerForLeft = (current.r != null) ? "├──" : "└──";

		traversePreOrder(sb, paddingForBoth, pointerForLeft, current.l  );
		traversePreOrder(sb, paddingForBoth, pointerForRight, current.r );
	    }
	}

	public void print() {
	    StringBuilder sb = new StringBuilder();
	    traversePreOrder(sb, "", "", root);
	    System.out.print(sb.toString());
	}

}
