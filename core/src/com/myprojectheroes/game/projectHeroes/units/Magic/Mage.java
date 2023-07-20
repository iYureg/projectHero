package com.myprojectheroes.game.projectHeroes.units.Magic;

public class Mage extends MagicChar {
    public Mage(String name, int x, int y) {
        super(name, x, y);
        this.type = "mage";
        this.forcePoint = 7;
    }
}
