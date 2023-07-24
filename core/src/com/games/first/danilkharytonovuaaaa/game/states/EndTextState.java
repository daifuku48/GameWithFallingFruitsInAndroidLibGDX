package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndTextState extends State{

    private Texture back;
    private Texture text;

    public EndTextState(com.games.first.danilkharytonovuaaaa.game.states.StateManager stm) {
        super(stm);

        back = new Texture("background.jpg");
        text = new Texture("gameover.png");
    }

    @Override
    public void update(float kadr) {

    }

    @Override
    public void touchHandler() {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();

        batch.end();
    }

    @Override
    public void dispose() {
        back.dispose();
        text.dispose();
    }
}
