package com.myprojectheroes.game.projectHeroes.units;

public class Coord {

    public int x;
    public int y;

    public Coord( int x, int y) {

        this.x = x;
        this.y = y;
    }
    public float getDistance(Coord point){
        int dx = point.x - x;
        int dy = point.y - y;
        return (float) Math.sqrt((dx * dx) + (dy * dy));
    }
}
