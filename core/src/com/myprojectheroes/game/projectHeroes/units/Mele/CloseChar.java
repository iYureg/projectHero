package com.myprojectheroes.game.projectHeroes.units.Mele;

import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;
import com.myprojectheroes.game.projectHeroes.units.Coord;

import java.util.ArrayList;

public abstract class CloseChar extends BaseCharacter {
    protected int rage;

    public CloseChar(String name, int x, int y) {
        super(name, x, y);
        this.rage = 50;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " \u265E";
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemy, ArrayList<BaseCharacter> allys) {
        if (this.hp <= 0) return;
        BaseCharacter target = getTarget(enemy);

        if (this.point.getDistance(target.getPoint()) < 2 && target.isAlive()) {
            target.getDamage(super.maxDmg);
            return;
        }

        Coord dest = new Coord(this.getCoord()[0], this.getCoord()[1]);

        if(Math.abs(this.getCoord()[0] - target.getCoord()[0]) > Math.abs(this.getCoord()[1] - target.getCoord()[1])) {
            if (this.getCoord()[0] > target.getCoord()[0]) {
                dest.x -= 1;
            } else {
                dest.x += 1;
            }

        } else {
            if (this.getCoord()[1] > target.getCoord()[1]) {
                dest.y -= 1;
            } else {
                dest.y += 1;
            }
        }

        boolean path = true;
        for(BaseCharacter ch: allys){
            if((ch.getCoord()[0] == dest.x) && (ch.getCoord()[1] == dest.y) && ch.isAlive()){
                path = false;
            }
        }

        if(!path) return;
        this.setCords(dest.x, dest.y);
    }
}