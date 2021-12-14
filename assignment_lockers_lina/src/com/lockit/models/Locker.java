package com.lockit.models;


import java.time.LocalDateTime;


public class Locker {
    private String id;
    private int xAxis;
    private int yAxis;
    private boolean locked;

    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setXAxis(int x) {
        this.xAxis = x;
    }
    public void setYAxis(int y) {
        this.yAxis = y;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    //Getters
    public String getId() {
        return this.id;
    }
    public int getXAxis(){
        return this.xAxis;
    }
    public int getYAxis(){
        return this.yAxis;
    }
    public boolean getLocked(){
        return this.locked;
    }
}
