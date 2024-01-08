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
		String input = "1+1+1";
		Parser parser = new Parser ( input );

		parser.ast.print();
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
