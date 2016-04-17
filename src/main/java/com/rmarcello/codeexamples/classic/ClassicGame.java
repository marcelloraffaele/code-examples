package com.rmarcello.codeexamples.classic;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rmarcello
 */
public class ClassicGame {
    
    private static final int MINIMUM_EXPLOSION_BALL=3;
    
    private static boolean checkAndExplodeBalls( Ball b ) {
        
        Set<Ball> connectedSameColor = connectedSameColor(b, null);
        
        if( connectedSameColor!=null && connectedSameColor.size()>=MINIMUM_EXPLOSION_BALL ) {

            Set<Ball> explodeddBall = calculateExplodedBall( b, connectedSameColor );

            return true;
        }
        return false;
    }
    
    public static Set<Ball> connectedSameColor(Ball b, Set<Ball> visited) {
        if( visited==null ) {
            visited = new HashSet<Ball>();
        }
        visited.add(b);
        if( b.getNeighbours()==null || b.getNeighbours().size()<1 )
            return visited;
        for(Ball next: b.getNeighbours()) {
            if( !visited.contains(next) && next.getColor()==b.getColor() )
                connectedSameColor(next, visited);
        }

        return visited;
    }
    
    /**
     * Return the set of Ball that must explode.
     * A ball explode if forms a group of at lease 3 balls of the same color or if is connected only to a set of exploding balls.
     * @param b
     * @param connectedSameColor
     * @return 
     */
    public static Set<Ball> calculateExplodedBall(Ball b, Set<Ball> connectedSameColor) {
        Set<Ball> res = new HashSet<Ball>();
        res.addAll(connectedSameColor);

        Set<Ball> connected = connected(b, null);   //connected components without color check

        for(Ball bx: connectedSameColor) {          //remove from all connected components the balls that are exploding
            connected.remove(bx);
        }

        for(Ball bc: connected) {                   //remove also all the edges between this two sets
            for(Ball bsc: connectedSameColor)
                bc.removeNeighbour(bsc);
        }

        for(Ball bx: connected) {                   //add to resultset all the balls that are not connected to the base
            if( !connectedToBase( connected(bx, null) ) )
                res.add(bx);
        }

        return res;
    }
    
    public static Set<Ball> connected(Ball n, Set<Ball> visited) {
//        System.out.println("connected(" +n.id +", "+toString(visited));
        Set<Ball> res = new HashSet<Ball>();
        if(visited!=null && visited.size()>0) {
            res.addAll(visited);
        } else {
            visited = new HashSet<Ball>();
        }
        res.add(n);
        visited.add(n);

        if( n.getNeighbours()==null || n.getNeighbours().size()<1 )
            return res;
        for(Ball next: n.getNeighbours()) {
            if( !visited.contains(next) )
                res.addAll( connected(next, visited) );
        }

        return res;

    }
    
    //explosion management
    public static boolean connectedToBase( Set<Ball> s ) {
        for(Ball n: s)
            if(n.isAttachedToBase())
                return true;
        return false;
    }
    
}
