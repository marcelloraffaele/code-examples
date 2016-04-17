package com.rmarcello.codeexamples.matrix;

import java.util.LinkedList;
import java.util.Set;

/**
 * Class used to represent the move results.
 * This object will be used by UI to make animations.
 * 
 * @author rmarcello
 */
public class MatrixMoveResult {
    boolean explosion;
    Set<Element> explodedBall;
    Set<Element> newBalls;
    LinkedList<MatrixElementMovement> movements;

    public MatrixMoveResult() {
        
    }
    
    public MatrixMoveResult( boolean e) {
        this.explosion=e;
    }
    
    public boolean isExplosion() {
        return explosion;
    }

    public Set<Element> getExplodedBall() {
        return explodedBall;
    }

    public Set<Element> getNewBalls() {
        return newBalls;
    }

    public void setExplodedBall(Set<Element> explodedBall) {
        this.explodedBall = explodedBall;
    }

    public void setNewBalls(Set<Element> newBalls) {
        this.newBalls = newBalls;
    }

    public void setExplosion(boolean explosion) {
        this.explosion = explosion;
    }

    public LinkedList<MatrixElementMovement> getMovements() {
        return movements;
    }

    public void setMovements(LinkedList<MatrixElementMovement> movements) {
        this.movements = movements;
    }
    

    @Override
    public String toString() {
        return "MatrixMoveResult{" 
                + "explosion=" + explosion 
                + ", explodedBall=" + explodedBall 
                + ", newBalls=" + newBalls 
                + ", movements=" + movements
                + '}';
    }

}
