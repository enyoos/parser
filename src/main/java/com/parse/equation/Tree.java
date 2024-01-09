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
	public Node root;
	public Tree ()            {}
	public Tree ( Node root ) { this.root = root; }
	
	public static void main ( String... args ) 
	{

		// 1 + 1 + 1 + 1
		// root node
		Node root = new Node ( '1' );


		// Create a new tree
		Tree tree = new Tree ( root );
		tree.add ( new Node ( '+' ) );
		tree.add ( new Node ( '1' ) );
		tree.add ( new Node ( '+' ) );
		tree.add ( new Node ( '1' ) );
		tree.add ( new Node ( '+' ) );
		tree.add ( new Node ( '1' ) );

		tree.print();
	}

	// 'appending' node to the tree
	private Node pushNode ( Node node, Node current )
	{
		if ( isOP ( current.value ) )
		{
			if ( current.l == null ) current.l = node;	
			else if ( current.r == null ) current.r = node;	
			else {
				current.r = pushNode ( current.r, node);
			}
		}
		else
		{
			if ( isOP ( node.value ))
			{
				Node tp = current;
				current = node;
				if ( current.l == null ) current.l = tp;
				else if ( current.r == null ) current.r = tp;
				else current.r = pushNode ( tp, current );
			}
		}

		return current;
	}


	public void add ( Node node ) { this.root = pushNode ( node, root); }


	public static boolean isOP ( char value )
	{
		boolean return_ = true;
		switch ( value )
		{
			case '+':
				break;
			case '^':
				break;
			case '/':
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

	public static boolean isComputeOp ( char ch )
	{
		boolean return_ = true;

		switch ( ch )
		{
			case '+':
				break;
			case '^':
				break;
			case '/':
				break;
			case '-':
				break;
			case '*':
				break;
			default :
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
