package com.parse.equation;

import com.parse.equation.Tree;
import com.parse.equation.Node;
import java.lang.Character    ;
import java.util.Queue;
import java.util.LinkedList;


public final class Parser {

	public Queue<Character> tokens;
	public Tree ast                      ;

	public static void main( String... args )
	{
		String input = "1+1+1+1";
		Parser parser = new Parser ( input );

		parser.ast.print();
		double result = parser.eval();
		System.out.println( result );
	}

	// parsing
	public void parse ( String input ) 
	{
		// what is parsing
		// you check each char
		// according to the char you're going to do different things
		// we'll need a tree an ast.

		for ( char ch : input.toCharArray() )
		{
			// the switch statement is more efficient
			switch ( ch )
			{
				case '+':
					this.tokens.add ( '+' );
					break;
				case '-':
					this.tokens.add ( '-' );
					break;
				case '*':
					this.tokens.add ( '*' );
					break;
				case '(':
					this.tokens.add ( '(' );
					break;
				case ')':
					this.tokens.add ( ')' );
					break;
				case ',':
					this.tokens.add ( ',' );
					break;
				case '.':
					this.tokens.add ( '.' );
					break;
				case ' ':
					break;
				default:
					this.tokens.add ( ch ); 
					break;
			}
		}

		makeTree();
	}



	public double eval ( )
	{
		return eval (  this.ast.root );	
	}

	// evaluates the expression
	private double eval( Node current )
	{

		System.out.println( current );

		// we need to eval the ast
		if ( Tree.isOP ( current.value ) )
		{
			Node l = current.l;
			Node r = current.r;


			if ( ! ( Tree.isOP ( l.value ) || Tree.isOP ( r.value ) ) )
			{
				double n1 = Double.parseDouble ( String.valueOf ( l.value ) );
				double n2 = Double.parseDouble ( String.valueOf ( r.value ) );

				return compute (n1, n2, current.value );
			}

			else 
			{
				double n1 = eval ( l );
				double n2 = eval ( r );

				return compute ( n1, n2 , current.value ); 
			}
	
		}
		else
		{
			double ret = Double.parseDouble( String.valueOf ( current.value ) );
			System.out.println( "ret : " + ret );
			return ret;
		}
	}

	private double compute ( double n1, double n2, char op )
	{

		switch ( op )
		{
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
			case '(':
				return 0;
			case ')':
				return 0;
			case ',':
				return 0;
			case '.':
				return 0;
			case ' ':
				return 0;
			default:
				return 0;
		}
	}

	private void makeTree ( )
	{

		Character rooToken = this.tokens.poll ( );

		if ( rooToken == null ) return;
		this.ast = new Tree( new Node ( rooToken ));

		boolean polling = true;

		while ( polling )
		{
			Character token = this.tokens.poll ();
			if ( token == null ) break;
			else this.ast.add ( new Node ( token ));
		}
	}

	// we can create a parser
	public Parser () {}
	public Parser ( String content ) { 
		this.tokens = new LinkedList<>();
		parse ( content ); 

	}

}
