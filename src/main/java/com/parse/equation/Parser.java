package com.parse.equation;

import com.parse.equation.Token;


public final class Parser {

	public static void main( String... args )
	{
		System.out.println ( "hello world" );	
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
					break;
			}
		}
	}


	// we can create a parser
	public Parser () {}
	public Parser ( String content ) { parse ( content ); }

}
