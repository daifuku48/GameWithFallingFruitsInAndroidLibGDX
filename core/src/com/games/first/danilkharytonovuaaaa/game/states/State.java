package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected StateManager StateManager;

    public State(StateManager stm) {
        this.StateManager = stm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    public abstract void update(float kadr);
    public abstract void touchHandler();
    public abstract void render(SpriteBatch batch);

}
