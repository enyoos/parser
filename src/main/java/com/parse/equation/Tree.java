package com.parse.equation;

import com.parse.equation.Node;
import com.parse.equation.Token;
import java.lang.StringBuilder ;
import java.util.HashMap;

// our class Tree will help
// us to parse inputs
// there's a rootNode ( like the base of a tree )
// that can have multiple childrens
public final class Tree 
{
	// char ( op ) priority of the op
	private static final HashMap<Character, Integer> priorityMap;
	static {

		// PEMDAS -> parenth, exp, mult, div, add, sub
		// for now we're not involving the parenth
		priorityMap = new HashMap<>();
		priorityMap.put (
			'+', 5
		);
		priorityMap.put (
			'-', 5
		);
		priorityMap.put (
			'^', 2
		);
		priorityMap.put (
			'*', 3
		);
		priorityMap.put (
			'/', 3
		);

	}

	public Node root;
	public Tree ()            {}
	public Tree ( Node root ) { this.root = root; }
	
	public static void main ( String... args ) 
	{

		// 1 * 6 + 6
		// 6 + 1 * 6
		// root node
		Node root = new Node ( '6' );


		// Create a new tree
		Tree tree = new Tree ( root );
		tree.add ( new Node ( '+' ) );
		tree.add ( new Node ( '1' ) );
		tree.add ( new Node ( '*' ) );
		tree.add ( new Node ( '6' ) );

		tree.print();
	}


	private boolean checkIfFirstNodeHasBiggerPriority ( Node n1, Node n2 )
	{ 
		int value1 = priorityMap.get ( n1.value ).intValue(); 
		int value2 = priorityMap.get ( n2.value ).intValue() ; 
		return  value1 < value2; 
	}

	// 'appending' node to the tree
	private Node pushNode ( Node node, Node current )
	{

		if ( isOP ( current.value ) )
		{


			if ( current.l == null ) current.l = node;	
			else if ( current.r == null ) current.r = node;	
			else {
				boolean isNodeOP = isOP ( node.value );

				if ( isNodeOP )
				{
					if ( checkIfFirstNodeHasBiggerPriority( current, node ) )
					{
						root = node;
						root.r = current;
						current = root;
					}
					else
					{
						current.r = pushNode( current.r, node );
					}
				}
				else { current.r = pushNode ( current.r, node); }
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
