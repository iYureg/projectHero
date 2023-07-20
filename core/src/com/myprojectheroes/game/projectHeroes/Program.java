package com.myprojectheroes.game.projectHeroes;

import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;
import com.myprojectheroes.game.projectHeroes.units.TeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Program {
    public Program() {
        reds = new TeamGenerator<BaseCharacter>().getTeam(1, 10);
        blues = new TeamGenerator<BaseCharacter>().getTeam(10, 10);
        allChars.addAll(reds);
        allChars.addAll(blues);
        Collections.sort(allChars, new Comparator<BaseCharacter>() {
            @Override
            public int compare(BaseCharacter v1, BaseCharacter v2) {
                return v1.getFP() - v2.getFP();
            }
        });
    }

    public  List<BaseCharacter> reds = new ArrayList<>();
    public  List<BaseCharacter> blues = new ArrayList<>();
    public  List<BaseCharacter> allChars = new ArrayList<>();

    public boolean step() {

//        Scanner scanner = new Scanner(System.in);

//        View.view();

        int countBlue = 0;
        int countRed = 0;
        boolean finish = false;

//            scanner.nextLine();

            for(BaseCharacter ch : allChars) {
                if (reds.contains(ch)) {
                    ch.step((ArrayList<BaseCharacter>) blues, (ArrayList<BaseCharacter>) reds);
                    if(!ch.isAlive()) countRed++;
                } else {
                    ch.step((ArrayList<BaseCharacter>) reds, (ArrayList<BaseCharacter>) blues);
                    if(!ch.isAlive()) countBlue++;
                }
            };
            if(countRed >= reds.size() || countBlue >= blues.size()) finish = true;

//            View.view();

        return true;
    }
}
