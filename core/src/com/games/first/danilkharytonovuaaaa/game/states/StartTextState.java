package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.games.first.danilkharytonovuaaaa.game.states.StateManager;
import org.w3c.dom.Text;

public class StartTextState extends State{

    Texture btn;
    Texture back;
    public StartTextState(StateManager stm) {
        super(stm);
        btn = new Texture("start.png");
        back = new Texture("background.jpg");
    }

    @Override
    public void update(float kadr) {
        touchHandler();
    }

    @Override
    public void touchHandler() {
        if(Gdx.input.justTouched()){
            Vector3 tmp=new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
            //camera.unproject(tmp);
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
        batch.draw(btn, (Gdx.graphics.getWidth() / 2) - 400,
                (Gdx.graphics.getHeight() / 2) - 210,
                800, 420);

        batch.end();
    }

    @Override
    public void dispose() {
        btn.dispose();
        back.dispose();
    }
}
