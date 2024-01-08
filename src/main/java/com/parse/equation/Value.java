package com.parse.equation;

import com.parse.equation.GenericToken;

public final class Value implements GenericToken
{
	private double value;
	public Value (){}
	public Value ( char value ) { 
		String strValue = String.valueOf ( value );
		this.value = Double.parseDouble ( strValue );
	}

	public double value () { return this.value; }

	@Override
	public String toString () { return "VALUE { " + this.value + " }"; }
}
