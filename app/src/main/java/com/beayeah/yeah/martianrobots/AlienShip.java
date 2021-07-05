package com.beayeah.yeah.martianrobots;

public class AlienShip {

    private Integer id;
    private Integer x;
    private Integer y;
    private String name;
    private Integer resID;

    public AlienShip() {
    }

    public AlienShip(Integer id, Integer x, Integer y, Integer resID) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.resID = resID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getName() {
        return "Ship " + getId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResID() {
        return resID;
    }

    public void setResID(Integer resID) {
        this.resID = resID;
    }

}
