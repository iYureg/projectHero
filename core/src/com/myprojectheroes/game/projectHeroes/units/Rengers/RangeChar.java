package com.myprojectheroes.game.projectHeroes.units.Rengers;

import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;
import com.myprojectheroes.game.projectHeroes.units.Worker;

import java.util.ArrayList;

public abstract class RangeChar extends BaseCharacter {
     protected int ammo;

    public RangeChar(String name,int x, int y) {
        super(name, x, y);
        this.ammo = 50;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + this.ammo + "\u27BC ";
    }
    @Override
    public void step(ArrayList<BaseCharacter> enemy, ArrayList<BaseCharacter> allys) {
        if( this.hp <= 0 ) return;
        if ( this.ammo == 0 ) return;

        BaseCharacter target = getTarget(enemy);
        if(target.isAlive()) target.getDamage(this.damage);
        for(BaseCharacter ch : allys) {
            if(ch.getType().equals("support") && !((Worker)(ch)).getBusy() && ch.getHp() > 0){
                ((Worker)(ch)).setBusy();
                return;
            }
        }
        this.ammo--;
    }
}
