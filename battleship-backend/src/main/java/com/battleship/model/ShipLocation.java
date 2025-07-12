package com.battleship.model;

public class ShipLocation {
    public String id;
    public int x; // Center X
    public int y; // Center Y
    public int size;

    public ShipLocation(String id, int x, int y, int size) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.size = size;
    }
} 