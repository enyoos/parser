package com.parse.equation;


// a node is a component making up the whole
// tree
// each node can have a left node or a right node
public final class Node
{
	char value;	
	Node l;
	Node r;
	public Node ( char value ) { this.value = value; this.l = null; this.r = null; }

	@Override
	public String toString ( ){ return "Node { value : " + this.value + " }"; }
}
