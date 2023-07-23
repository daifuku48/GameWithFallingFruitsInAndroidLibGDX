package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.w3c.dom.Text;

public class StartTextState extends State{

    SpriteBatch batch;
    BitmapFont font;

    public StartTextState(com.games.first.danilkharytonovuaaaa.game.states.StateManager stm) {
        super(stm);
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void update(float kadr) {

    }

    @Override
    public void touchHandler() {

    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
