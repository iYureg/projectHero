package com.myprojectheroes.game.projectHeroes.Interface;

import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;

import java.util.ArrayList;

/**
 * CharacterInterface
 */
public interface CharacterInterface {
    void step(ArrayList<BaseCharacter> enemy, ArrayList<BaseCharacter> allys);

    String getInfo();
}