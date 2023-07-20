package com.myprojectheroes.game.projectHeroes.units;

import com.myprojectheroes.game.projectHeroes.Interface.CharacterInterface;
import com.myprojectheroes.game.projectHeroes.view.AnsiColors;

import java.util.ArrayList;


public abstract class BaseCharacter implements CharacterInterface {

    protected String name;
    protected String type;
    protected boolean isAlive;
    protected int maxHp = 300;
    protected int hp;

    protected int minDmg;
    protected int maxDmg;
    protected int damage;
    protected int baseFP = 1;
    protected int forcePoint;
    protected Coord point;


    public BaseCharacter(String name, int x, int y) {
        this.name = name;
        this.isAlive = true;
        this.hp = maxHp;
        this.minDmg = 40;
        this.maxDmg = 50;
        this.damage = (minDmg + maxDmg) / 2;
        this.forcePoint = baseFP;
        this.point = new Coord(x, y);
    }

    public void getDamage(int dmg) {
        if((this.hp - dmg) <= 0){
            this.hp = 0;
            this.isAlive = false;
        } else {
            this.hp -= dmg;
        }
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }

    public void setCordX(int x) {
        this.point.x += x;
    }

    public boolean isAlive(){
        return this.isAlive;
    }
    public void setCordY(int y) {
        this.point.y += y;
    }
    public void setCords(int x, int y){
        this.point.x = x;
        this.point.y = y;
    }

    public Coord getPoint() {
        return this.point;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int HP) {
        this.hp = HP + this.hp > maxHp ? maxHp : this.hp + HP;
    }

    public int getFP() {
        return this.forcePoint;
    }

    public int[] getCoord() {
        return new int[]{this.point.x, this.point.y};
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getInfo() {
        return this.name + " - " + AnsiColors.ANSI_RED +
                this.hp +  "\u2661 " + AnsiColors.ANSI_RESET + " - " +
                this.forcePoint + "\u2694 ";
    }


    protected BaseCharacter getTarget(ArrayList<BaseCharacter> enemy) {

        int dist = 10000;
        int index = 0;
        for (int i = 0; i < enemy.size(); i++) {
            if (dist > point.getDistance(enemy.get(i).point) && (enemy.get(i).isAlive())) {
                dist = Math.round(point.getDistance(enemy.get(i).point));
                index = i;
            }
        }

        return enemy.get(index);
    }
}
