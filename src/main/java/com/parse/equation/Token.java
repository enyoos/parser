package com.parse.equation;

public enum Token {
	
	COMMA( ',' ),
	ADDITION ( '+' ),
	MULTIPLICATION ( '*' ),
	SUBSTRACTION   ( '-' ),
	LPARENTHESIS   ( '(' ),
	RPARENTHESIS   ( ')' );

	private final char value;
	private Token ( char value ){ this.value = value; }
	public char value () { return this.value; }
}
