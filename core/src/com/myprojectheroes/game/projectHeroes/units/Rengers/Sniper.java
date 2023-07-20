package com.myprojectheroes.game.projectHeroes.units.Rengers;

public class Sniper extends RangeChar {
    public Sniper(String name, int x, int y) {
        super(name, x, y);
        this.type = "sniper";
        this.ammo -= 10;
        this.forcePoint = 2;
    }
}
