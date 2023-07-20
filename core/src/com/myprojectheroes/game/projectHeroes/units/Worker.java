package com.myprojectheroes.game.projectHeroes.units;

import com.myprojectheroes.game.projectHeroes.Interface.CharacterInterface;

import java.util.ArrayList;

public class Worker extends BaseCharacter implements CharacterInterface {

    protected boolean busy;
    public Worker(String name, int x, int y) {
        super(name, x ,y);
        this.damage = 0;
        this.type = "worker";
        this.forcePoint = 10;
        this.busy = false;

    }
    @Override
    public String getInfo() {
        return super.getInfo() + this.showStatus();
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemy,ArrayList<BaseCharacter> allys) {
        if( this.hp <= 0 ) return;
    }

    public void setBusy(){this.busy = !this.busy;}
    public boolean getBusy(){return this.busy;}
    public String showStatus(){
        return this.busy ? "\u274C" : "\u2705";
    }
}
