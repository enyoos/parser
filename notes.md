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







