package com.rmarcello.codeexamples.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author rmarcello
 */
public class MatrixGame {

    Element[][] matrix;
    int rows, cols;

    public MatrixGame(int n, int m) {
        this.rows=n;
        this.cols=m;
    }

    public void init() {
        matrix = new Element[this.rows][this.cols];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                matrix[i][j] = MatrixGameUtil.createElement( i, j );
                matrix[i][j].setPosition(i, j);
            }
        }
    }

    public Element getElement(int i, int j) {
        return matrix[i][j];
    }

    /**
     * Returns a MatrixMoveResult object that represents exploded elements and new created balls. 
     * @param i
     * @param j
     * @return
     */
    public MatrixMoveResult move(int i, int j) {
        
        Set<Element> sameColorNeighbours = getSameColorNeighbours(i,j, matrix, null);
        
        if( sameColorNeighbours.size() >= MatrixConstants.MIN_COLOR_NEIGHBOURS ) {
            return collapse(sameColorNeighbours, matrix);
        }
        
        return new MatrixMoveResult(false);
    }

    /**
     * Elements connected with same colors.
     *
     * @param i
     * @param j
     * @param visited
     * @return
     */
    private static Set<Element> getSameColorNeighbours(int i, int j, Element[][] m, Set<Element> visited) {
        Element curr = m[i][j];
        Set<Element> res = new HashSet<>();
        res.add(curr);

        if( visited != null)
            res.addAll(visited);

        Set<Element> neighbours = neighbours(i,j, m);
        for( Element e: neighbours ) {
            if( e.getColor().equals(curr.getColor()) && !res.contains(e) ) {
                res.addAll( getSameColorNeighbours(e.getRow(), e.getCol(), m, res) );
            }
        }

        return res;
    }

    /**
     * Returns the Set of neighbours elements
     * @param i
     * @param j
     * @param m
     * @return 
     */
    private static Set<Element> neighbours(int i, int j, Element[][] m) {
        Set<Element> res = new HashSet<Element>();
        if( i>=1 )
            res.add( m[i-1][j] );
        if( i<m.length-1 )
            res.add( m[i+1][j] );
        if( j>=1 )
            res.add( m[i][j-1] );
        if( j<m[i].length-1 )
            res.add( m[i][j+1] );

        return res;
    }

    /**
     * Remove exploded elements, Collapse all the elements on the exploded elements and create new elements.
     * @param toDelete
     * @param m
     * @return 
     */
    private MatrixMoveResult collapse(Set<Element> toDelete, Element[][] m) {
        MatrixMoveResult result = new MatrixMoveResult();
        result.setExplosion(true);
        result.setExplodedBall(toDelete);
        result.setNewBalls(new HashSet<>());
        result.setMovements( new LinkedList<>());

        //step 1 delete exploded elements
        for(Element e: toDelete) {
            int i= e.getRow();
            int j= e.getCol();
            m[i][j] = null;
        }
        
//        System.out.println( "STEP 1:\n" + this.toString() +"\n" );
        
        //step 2: collapse elements
        for (int j = 0; j < m[0].length; j++) {
            int firstNull = m.length-1;
            while(firstNull>0) {
                while( firstNull>=0 && m[firstNull][j]!=null ) {
                    firstNull--;
                }
                int firstNotNull = firstNull-1;
                while( firstNotNull>=0 ) {
                    if( m[firstNotNull][j]!=null ) {
                        m[firstNull][j]=m[firstNotNull][j];
                        m[firstNull][j].setPosition(firstNull, j);
                        m[firstNotNull][j] = null;
                        result.getMovements().add( new MatrixElementMovement(firstNotNull, j, firstNull, j));
                        break;
                    }
                    firstNotNull--;
                }
                if(firstNotNull<0)
                    break;
            }
            firstNull--;
        }
//        System.out.println( "STEP 2:\n" + this.toString()  +"\n" );
        
        
        //step 3: create new balls
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(m[i][j]==null) {
                    m[i][j]= MatrixGameUtil.createElement( );
                    m[i][j].setPosition(i, j);
                    result.getNewBalls().add( m[i][j] );
                }
            }
        }
//        System.out.println( "STEP 3:\n" + this.toString()  +"\n" );

        return result;
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                s+= matrix[i][j];
                if(j<matrix[i].length-1)
                    s+= "\t";
            }
            if(i<matrix.length-1)
                s+= "\n";
        }
        return s;
    }
    
}
