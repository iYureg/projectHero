package com.myprojectheroes.game.projectHeroes.units.Magic;

import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;

import java.util.ArrayList;
import java.util.Random;

public abstract class MagicChar extends BaseCharacter {
    protected int mana;
    protected int heal;

    public MagicChar(String name, int x, int y) {
        super(name,x ,y);
        this.heal = 25;
        this.mana = 300;
    }

    public void healing(BaseCharacter ch){
        ch.setHp(this.heal);
        this.mana -= 10;
//        System.out.println(this.name + " лечит " + ch.getName());
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " " + this.mana + "\u2735 ";
    }
    @Override
    public void step(ArrayList<BaseCharacter> enemy, ArrayList<BaseCharacter> allys) {
        if ( hp <= 0 ) return;
        if ( mana < 10 ) return;

        int pacientIndex = allys.size() + 10;
        int minHp = super.maxHp;
        for (int i = 0; i < allys.size() ; i++) {
            if(allys.get(i).getHp() < minHp && allys.get(i).isAlive()){
                minHp = allys.get(i).getHp();
                pacientIndex = i;
            }
        }

        if (pacientIndex < allys.size()) {
            healing(allys.get(pacientIndex));
        } else {
            BaseCharacter target = getTarget(enemy);
            if (target.isAlive()){
                target.getDamage(super.minDmg);
                this.mana -= 10;
            }
        }
    }
}
