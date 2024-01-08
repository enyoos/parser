package com.parse.equation;

import com.parse.equation.GenericToken;

public enum Token implements GenericToken{
	
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
