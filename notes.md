1 + 1 + 2 


    1 --> pushNode ( new Node ( '1' ));


    + --> pushNode ( new Node ( '+' ) );
1     --> shiftNode ( new Node ( '1' ));


    +
1       1

eval ( previous )


read first Node -> +
read the left node -> 1
read the right node -> 1

1 is not op , 1 is not op, + is op -> eval ( 1 + 1 ) = 2


    +
       
1       +
        
     1     2



1 + 2

-> 1


->      +
    1       
    

->      +
    1       2

    
    
1 + 1 + 2 


    +
1       1

    +
1       +
    1       2






1 + 1 + 1 + 2


    +
1       +
    1       +
        1       2



2 * 3 / 3 + 3  -> [ 2, *, 3, /, 3, +, 3 ], this counts as a whole expression


2 + 3 / 3 + 3

// the good thing.

  
  / -> 3
  ^ -> 2

    / -> :q

    + -> 5

    
step... by stepp

    *
2       3


    /
3        *
    2        3

    +
3       /
    3       *
        2       3

there must a function that compares the priority of ops.
( make a map of the ops with there're actual prio. values );

idea : preprocess the array and form grouping ( expression ... , term ...)
idea : the pushing order ( check the operator before PEMDAS -> p, exp, mul, div, a, s)
       the s op, should be the first (root) ( in theory... ).





(1 + 2) * 3 ( A )
 1 + 2  * 3 ( B )
 
 
 
B :

    +
1       *
    2       3
 

A :


    *
3       +
    1       2
 


    +
1       2




// idea, ignore the right parenth
// just take into account the left parenth


    +
1       2

( we encouter a LParenth ), (s) means null root

   (s)
        +
    1       2


    *
3       +
    1       2

















