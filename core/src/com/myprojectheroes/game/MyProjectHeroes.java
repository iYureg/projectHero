package com.myprojectheroes.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.myprojectheroes.game.projectHeroes.Program;
import com.myprojectheroes.game.projectHeroes.units.BaseCharacter;

import java.util.ListIterator;
import java.util.Random;

public class MyProjectHeroes extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon , crossbowman, mage, priest, worker, rogue, guardian, sniper;

	Program game;
	Music music;

	private boolean clk = true;
	
	@Override
	public void create () {
		game = new Program();
		batch = new SpriteBatch();
		fon = new Texture("fons/"+fons.values()[new Random().nextInt(fons.values().length)] +".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0"+(new Random().nextInt(4)+1) +".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();

		crossbowman = new Texture("chars/CrossBowMan.png");
		mage = new Texture("chars/Mage.png");
		priest = new Texture("chars/Monk.png");
		worker =new Texture("chars/Peasant.png");
		rogue = new Texture("chars/Rouge.png");
		guardian = new Texture("chars/Sniper.png");
		sniper = new Texture("chars/SpearMan.png");
	}

	@Override
	public void render () {


		if(Gdx.input.isTouched() & clk)	{
			clk = false;
			game.step();
		}

		if(!Gdx.input.isTouched() & !clk) clk = true;

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		int dx = Gdx.graphics.getWidth()/12;
		int dy = Gdx.graphics.getHeight()/15;
		final int X = 0;
		final int Y = 1;

		ListIterator<BaseCharacter> iterator = game.reds.listIterator(game.reds.size());
		while (iterator.hasPrevious()){
			BaseCharacter ch = iterator.previous();


			if(!ch.isAlive()) continue;

			int m = 1;
			if(ch.getType().equals("crossbowman")) { batch.draw(crossbowman, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, crossbowman.getWidth()*m, crossbowman.getHeight()); }
			if(ch.getType().equals("mage")) { batch.draw(mage, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, mage.getWidth()*m, mage.getHeight()); }
			if(ch.getType().equals("priest")) { batch.draw(priest, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, priest.getWidth()*m, priest.getHeight()); }
			if(ch.getType().equals("worker")) { batch.draw(worker, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, worker.getWidth()*m, worker.getHeight()); }
			if(ch.getType().equals("rogue")) { batch.draw(rogue, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, rogue.getWidth()*m, rogue.getHeight()); }
			if(ch.getType().equals("guardian")) { batch.draw(guardian, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, guardian.getWidth()*m, guardian.getHeight()); }
			if(ch.getType().equals("sniper")) { batch.draw(sniper, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, sniper.getWidth()*m, sniper.getHeight()); }
		}

		iterator = game.blues.listIterator(game.blues.size());
		while (iterator.hasPrevious()){
			BaseCharacter ch = iterator.previous();

			if(!ch.isAlive()) continue;

			int m = -1;
			if(ch.getType().equals("crossbowman")) { batch.draw(crossbowman, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, crossbowman.getWidth()*m, crossbowman.getHeight()); }
			if(ch.getType().equals("mage")) { batch.draw(mage, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, mage.getWidth()*m, mage.getHeight()); }
			if(ch.getType().equals("priest")) { batch.draw(priest, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, priest.getWidth()*m, priest.getHeight()); }
			if(ch.getType().equals("worker")) { batch.draw(worker, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, worker.getWidth()*m, worker.getHeight()); }
			if(ch.getType().equals("rogue")) { batch.draw(rogue, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, rogue.getWidth()*m, rogue.getHeight()); }
			if(ch.getType().equals("guardian")) { batch.draw(guardian, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, guardian.getWidth()*m, guardian.getHeight()); }
			if(ch.getType().equals("sniper")) { batch.draw(sniper, ch.getCoord()[X]*dx, ch.getCoord()[Y]*dy, sniper.getWidth()*m, sniper.getHeight()); }
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		music.dispose();
		crossbowman.dispose();
		mage.dispose();
		priest.dispose();
		worker.dispose();
		rogue.dispose();
		guardian.dispose();
		sniper.dispose();

	}
}
