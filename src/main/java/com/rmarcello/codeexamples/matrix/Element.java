package com.rmarcello.codeexamples.matrix;

/**
 *
 * @author rmarcello
 */
public class Element {
    private String id;
    private Integer color;
    private int row,col;

    private static int cnt=0;

    public Element(String id, int color) {
        this.id=id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
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

    public void setPosition(int i, int j) {
        this.row=i;
        this.col=j;
    }

    @Override
    public String toString() {
        return "["+id+"."+color+"]";
    }

    @Override
    public int hashCode() {
        return (this.row+" "+this.col).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element other = (Element) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        return true;
    }

}
