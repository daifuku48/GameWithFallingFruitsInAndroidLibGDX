package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class EndTextState extends State{

    private Texture back;
    private Texture text;

    public EndTextState(com.games.first.danilkharytonovuaaaa.game.states.StateManager stm) {
        super(stm);

        back = new Texture("back.jpg");
        text = new Texture("gameover.png");
    }

    @Override
    public void update(float kadr) {
        touchHandler();
    }

    @Override
    public void touchHandler() {
        if(Gdx.input.justTouched()){
            Vector3 tmp=new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
            Rectangle textureBounds=new Rectangle((Gdx.graphics.getWidth() / 2) - 400,
                    (Gdx.graphics.getHeight() / 2) - 210,
                    800, 420);
            if(textureBounds.contains(tmp.x,tmp.y))
            {
                this.StateManager.push(new GameBirdState(this.StateManager));
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(back, 0, 0, Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        batch.draw(text, (Gdx.graphics.getWidth() / 2) - 400,
                (Gdx.graphics.getHeight() / 2) - 210,
                800, 420);
        batch.end();
    }

    @Override
    public void dispose() {
        back.dispose();
        text.dispose();
    }
}
