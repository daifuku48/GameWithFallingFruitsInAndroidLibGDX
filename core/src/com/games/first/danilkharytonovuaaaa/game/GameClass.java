package com.games.first.danilkharytonovuaaaa.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.first.danilkharytonovuaaaa.game.model.Bird;
import com.games.first.danilkharytonovuaaaa.game.states.GameBirdState;
import com.games.first.danilkharytonovuaaaa.game.states.StartTextState;
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
	public void create() {
		stateManager = new StateManager();
		stateManager.push(new StartTextState(stateManager));
	}

	@Override
	public void render() {
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
	}

}
