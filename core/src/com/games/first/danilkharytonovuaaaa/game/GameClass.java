package com.games.first.danilkharytonovuaaaa.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.first.danilkharytonovuaaaa.game.model.Food;
import com.games.first.danilkharytonovuaaaa.game.states.StartTextState;
import com.games.first.danilkharytonovuaaaa.game.states.StateManager;

public class GameClass extends ApplicationAdapter {
	private SpriteBatch batch;

	private StateManager stateManager;

	@Override
	public void create() {
		batch = new SpriteBatch();
		stateManager = new StateManager();
		stateManager.push(new StartTextState(stateManager));
	}

	@Override
	public void render() {
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.render(batch);
	}

}
