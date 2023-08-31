package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.games.first.danilkharytonovuaaaa.game.model.CatcherBox;
import com.games.first.danilkharytonovuaaaa.game.model.Food1;
import com.games.first.danilkharytonovuaaaa.game.model.Food2;
import com.games.first.danilkharytonovuaaaa.game.model.Food3;
import com.games.first.danilkharytonovuaaaa.game.model.Food5;

public class GameBirdState extends State{

    private Texture back;

    private Integer count = 0;
    private boolean isOver;
    private Food1 food;
    private Food2 food2;
    private Food3 food3;
    private Food5 food4;
    private CatcherBox box;
    private StateManager stateManager;
    public GameBirdState(StateManager stm) {
        super(stm);
        stateManager = stm;
        box = new CatcherBox(Gdx.graphics.getPpcX() - 70,100f,0f);
        food = new Food1(Gdx.graphics.getWidth());
        food2 = new Food2(Gdx.graphics.getWidth());
        food3 = new Food3(Gdx.graphics.getWidth());
        food4 = new Food5(Gdx.graphics.getWidth());
        back = new Texture("s222.jpg");
        isOver = false;
    }

    @Override
    public void touchHandler() {
        if (Gdx.input.justTouched()){
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            touchPos = camera.unproject(touchPos); // Convert screen coordinates to world coordinates

            Rectangle textureBounds = new Rectangle((Gdx.graphics.getWidth() / 2) - 400,
                    (Gdx.graphics.getHeight() / 2) - 210,
                    800, 420);
        }
        if (Gdx.input.isTouched()){
            Rectangle boxBounds = new Rectangle(box.position.x, box.position.y - 170, box.box.getWidth() - 100,box.box.getHeight() - 150);
            box.bounds = boxBounds;
            box.position.x = Gdx.input.getX() - 150;
        }
    }

    @Override
    public void update(float delta) {
        touchHandler();

        // Update food
        food.update(delta);

        food2.update(delta);

        food3.update(delta);

        food4.update(delta);

        this.camera.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();

        // Render background
        batch.draw(back, 0, 0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );

        BitmapFont font = new BitmapFont(); // You can adjust font settings as needed
        font.getData().setScale(7f);
        // Draw the score text
        font.draw(batch, "Score: " + count.toString(), 100, Gdx.graphics.getHeight() - 100);

        if (isCollisionFood1()){
            count = count + 1;
            food = new Food1(Gdx.graphics.getWidth());
        }

        if (isCollisionFood2()){
            count = count + 1;
            food2 = new Food2(Gdx.graphics.getWidth());
        }

        if (isCollisionFood3()){
            count = count + 1;
            food3 = new Food3(Gdx.graphics.getWidth());
        }

        if (isCollisionFood5()){
            count = count + 1;
            food4 = new Food5(Gdx.graphics.getWidth());
        }


        if (food.isOver){
           stateManager.push(new EndTextState(stateManager));
        }

        if (food2.isOver){
            stateManager.push(new EndTextState(stateManager));
        }
        if (food3.isOver){
            stateManager.push(new EndTextState(stateManager));
        }
        if (food4.isOver){
            stateManager.push(new EndTextState(stateManager));
        }


        // Render food
        batch.draw(food.getTexture(), food.getPosition().x, food.getPosition().y,
                200, 200);

        batch.draw(food2.getTexture(), food2.getPosition().x, food2.getPosition().y,
                200, 200);

        batch.draw(food3.getTexture(), food3.getPosition().x, food3.getPosition().y,
                200, 200);

        batch.draw(food4.getTexture(), food4.getPosition().x, food4.getPosition().y,
                200, 200);

        //Render box
        batch.draw(box.box, box.position.x, box.position.y, 380, 270);

        batch.end();
    }

    private boolean isCollisionFood1(){
        return box.collidesWithItem(food.bounds);
    }

    private boolean isCollisionFood2(){
        return box.collidesWithItem(food2.bounds);
    }

    private boolean isCollisionFood3(){
        return box.collidesWithItem(food3.bounds);
    }

    private boolean isCollisionFood5(){
        return box.collidesWithItem(food4.bounds);
    }


    @Override
    public void dispose() {
        back.dispose();
        food.dispose();
        box.box.dispose();
    }
}
