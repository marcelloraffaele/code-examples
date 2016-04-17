package com.rmarcello.codeexamples.classic;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rmarcello
 */
public class Ball {
    
    String id;
    Set<Ball> neighbours;
    int color;
    boolean attachedToBase=false;
    
    public Ball(String id, int color) {
        this.id = id;
        this.color=color;
        this.neighbours = new HashSet<>();
    }
    
    public Ball(String id, int color, boolean attachedToBase) {
        this.id = id;
        this.color=color;
        this.attachedToBase=attachedToBase;
        this.neighbours = new HashSet<>();
    }

    public Set<Ball> getNeighbours() {
        return neighbours;
    }
    
    public void addNeighbour(Ball b) {
        this.neighbours.add(b);
        b.neighbours.add(this);
    }
    
    public void removeNeighbour(Ball b) {
        this.neighbours.remove(b);
        b.neighbours.remove(this);
    }

    public String getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public boolean isAttachedToBase() {
        return attachedToBase;
    }
    
    @Override
    public String toString() {
        String s= "Ball("+id +", "+ (attachedToBase?"1":"0") +" )";
        return s;
    }
}
