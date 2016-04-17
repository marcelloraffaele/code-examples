package com.rmarcello.codeexamples.matrix;

public class MatrixElementMovement {

    private int row,col;
    private int rowTo,colTo;

    public MatrixElementMovement() {

    }

    public MatrixElementMovement(int row, int col, int rowTo, int colTo) {
        this.row = row;
        this.col = col;
        this.rowTo = rowTo;
        this.colTo = colTo;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRowTo() {
        return rowTo;
    }

    public void setRowTo(int rowTo) {
        this.rowTo = rowTo;
    }

    public int getColTo() {
        return colTo;
    }

    public void setColTo(int colTo) {
        this.colTo = colTo;
    }

    @Override
    public String toString() {
        return "MatrixElementMovement{" +

                "{" 
                + row + ", " + col
                + "-> +" + (rowTo-row)
                + "}"
                +

                '}';
    }
}
