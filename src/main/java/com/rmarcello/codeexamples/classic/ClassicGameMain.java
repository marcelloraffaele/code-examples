package com.rmarcello.codeexamples.classic;

import java.util.Set;

/**
 *
 * @author rmarcello
 */
public class ClassicGameMain {
    
    public static void main(String a[]) {
        
        Ball b1 = new Ball("1", 0, true );
        Ball b2 = new Ball("2", 0, false );
        Ball b3 = new Ball("3", 0, false );
        Ball b4 = new Ball("4", 2, false );
        
        Ball b5 = new Ball("5", 2, true );
        
        
        
        b1.addNeighbour( b2 );
        b2.addNeighbour( b3 );
        b3.addNeighbour( b4 );
        b5.addNeighbour(b4);
        
        Set<Ball> connectedSameColor = ClassicGame.connectedSameColor(b2, null);
        System.out.println("connectedSameColor= " + connectedSameColor);
        
        Set<Ball> calculateExplodedBall = ClassicGame.calculateExplodedBall(b2, connectedSameColor );
        System.out.println("calculateExplodedBall = " + calculateExplodedBall );
        
        
    }
    
}
