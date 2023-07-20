package com.myprojectheroes.game.projectHeroes.units.Mele;

public class Guardian extends CloseChar {

    public Guardian(String name, int x, int y) {
        super(name,x, y);
        this.type = "guardian";
        this.forcePoint = 5;
    }
}
