package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.first.danilkharytonovuaaaa.game.model.Bird;
import com.games.first.danilkharytonovuaaaa.game.states.StateManager;

public class GameBirdState extends State{

    private Texture birdTexture;
    private Texture back;
    private Texture topTube;
    private Texture bottomTube;

    private boolean isOver;
    private Bird bird;

    private StateManager stateManager;
    public GameBirdState(StateManager stm) {
        super(stm);
        stateManager = stm;
        int flyHeight = Gdx.graphics.getHeight() / 2 - bird.height / 2;
        bird = new Bird(Gdx.graphics.getWidth() / 2 - 400,
                flyHeight);
        birdTexture = new Texture("bird.png");
        back = new Texture("background.jpg");
        topTube = new Texture("tube_top.png");
        bottomTube = new Texture("tube_bottom.png");
        bird.flyheight = flyHeight;
    }

    public void input(){
        if (Gdx.input.justTouched()){
            if (isOver){
                stateManager.push(new EndTextState(stateManager));
            } else{
                bird.jump();
            }
        }
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

        if (Gdx.input.justTouched()){
			bird.flyheight = bird.flyheight + 200;
			bird.fallingHeight = -20;
		}

        batch.draw(back, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(birdTexture, Gdx.graphics.getWidth() / 2 - 400,
                bird.flyheight,
                bird.width, bird.height);

		bird.fallingHeight++;
		bird.flyheight -= bird.fallingHeight / 2;


        batch.end();
    }

    @Override
    public void dispose() {
        back.dispose();
        birdTexture.dispose();
        topTube.dispose();
        bottomTube.dispose();
    }
}
