package com.games.first.danilkharytonovuaaaa.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.games.first.danilkharytonovuaaaa.game.model.Bird;
import com.games.first.danilkharytonovuaaaa.game.states.MenuScreen;
import com.games.first.danilkharytonovuaaaa.game.states.StateManager;

public class GameClass extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture birdSprite;
	private Texture phon;
	private Bird bird;

	private int spaceTube = 400;
	private Texture pipeTop;
	private Texture pipeBottom;

	private StateManager stateManager;

	@Override
	public void create () {
		stateManager = new StateManager();
		stateManager.push(new MenuScreen(stateManager));
		batch = new SpriteBatch();
		birdSprite = new Texture("bird.png");
		phon = new Texture("background.jpg");
		bird = new Bird();
		bird.flyheight = Gdx.graphics.getHeight() / 2 - 125;
		pipeTop = new Texture("tube_top.png");
		pipeBottom = new Texture("tube_bottom.png");

	}

	@Override
	public void render () {

		if (Gdx.input.justTouched()){
			bird.flyheight = bird.flyheight + 200;
			bird.fallingHeight = -20;
		}

		bird.fallingHeight++;
		bird.flyheight -= bird.fallingHeight / 2;
		batch.begin();
		batch.draw(phon, 0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		batch.draw(birdSprite, Gdx.graphics.getWidth() / 2 - 400,
				bird.flyheight,
				bird.width, bird.height);

		batch.end();
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		birdSprite.dispose();
		phon.dispose();
	}
}
