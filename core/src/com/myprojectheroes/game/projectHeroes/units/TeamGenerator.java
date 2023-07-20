package com.myprojectheroes.game.projectHeroes.units;

import com.myprojectheroes.game.projectHeroes.units.Magic.Mage;
import com.myprojectheroes.game.projectHeroes.units.Magic.Priest;
import com.myprojectheroes.game.projectHeroes.units.Mele.Guardian;
import com.myprojectheroes.game.projectHeroes.units.Mele.Rogue;
import com.myprojectheroes.game.projectHeroes.units.Rengers.Crossbowman;
import com.myprojectheroes.game.projectHeroes.units.Rengers.Sniper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamGenerator <T extends BaseCharacter> {
    private static Random r = new Random();
    private static String[] types = {"Mage","Priest","Rogue","Guardian","Sniper","Crossbowman","Worker"};




   public ArrayList<T> getTeam(int side, int size) {
        List<T> team = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String value = types[r.nextInt(7)];

            switch (value) {
                case "Mage": {
                    team.add((T) new Mage(value + "_" + i, side, i));
                    break;
                }
                case "Priest": {
                    team.add((T) new Priest(value + "_" + i, side, i));
                    break;
                }
                case "Rogue": {
                    team.add((T) new Rogue(value + "_" + i, side, i));
                    break;
                }
                case "Guardian": {
                    team.add((T) new Guardian(value + "_" + i, side, i));
                    break;
                }
                case "Sniper": {
                    team.add((T) new Sniper(value + "_" + i, side, i));
                    break;
                }
                case "Crossbowman": {
                    team.add((T) new Crossbowman(value + "_" + i, side, i));
                    break;
                }
                case "Worker": {
                    team.add((T) new Worker(value + "_" + i, side, i));
                    break;
                }
            }
        }
        return (ArrayList<T>) team;
    }
}
