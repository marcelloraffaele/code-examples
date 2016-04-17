package com.rmarcello.codeexamples.matrix;


import java.util.Random;

/**
 * Utility class that helps to create and initialize Elements.
 * 
 * @author rmarcello
 */
public class MatrixGameUtil {

    private static final Random random= new Random();
    private static int cntMatrixElement=1;

    public static Element createElement( int i, int j ) {

        Element b = new Element( cntMatrixElement+"", i%2 );    //only for test


        cntMatrixElement++;
        return b;
    }

    public static Element createElement(  ) {

        Element b = new Element( cntMatrixElement+"", randomRangeInt(0, 5) );

        cntMatrixElement++;
        return b;
    }

    public static int randomRangeInt(int min, int max) {
        int delta = max-min+1;
        int k = random.nextInt( delta )+ min;
        return k;

    }

}
