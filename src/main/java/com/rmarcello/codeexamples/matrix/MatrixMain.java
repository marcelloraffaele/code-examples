package com.rmarcello.codeexamples.matrix;

/**
 *
 * @author rmarcello
 */
public class MatrixMain {
    
    public static void main(String a[]) {
        
        MatrixGame game = new MatrixGame(5, 3);
        game.init();
        
        System.out.println( "Current state:\n" +game.toString() );
        
        MatrixMoveResult mr1 = game.move(2, 0);
        System.out.println( mr1.toString() );
        
        System.out.println( "Current state:\n" +game.toString() );
        
        MatrixMoveResult mr2 = game.move(3, 0);
        System.out.println( mr2.toString() );
        
        System.out.println( "Current state:\n" +game.toString() );
        
    }
    
}
