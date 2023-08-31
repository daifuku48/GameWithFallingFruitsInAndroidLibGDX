package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.games.first.danilkharytonovuaaaa.game.model.CatcherBox;
import com.games.first.danilkharytonovuaaaa.game.model.Food;

public class GameBirdState extends State{

    private Texture back;
    private boolean isOver;
    private Food food;
    private CatcherBox box;
    private StateManager stateManager;
    public GameBirdState(StateManager stm) {
        super(stm);
        stateManager = stm;
        box = new CatcherBox(Gdx.graphics.getPpcX() - 70,100f,0f);
        food = new Food(Gdx.graphics.getWidth());
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

        // Check collision between box and food
        if (box.bounds.overlaps(food.bounds)) {
            // Handle collision, you can increase score, remove the food, etc.
        }

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

        if (isCollision()){
            food = new Food(Gdx.graphics.getWidth());
        }

        if (food.isOver){
           stateManager.push(new EndTextState(stateManager));
        }

        // Render food
        batch.draw(food.getTexture(), food.getPosition().x, food.getPosition().y,
                200, 200);

        //Render box
        batch.draw(box.box, box.position.x, box.position.y, 380, 270);

        batch.end();
    }

    private boolean isCollision(){
        return box.collidesWithItem(food.bounds);
    }

    @Override
    public void dispose() {
        back.dispose();
        food.dispose();
        box.box.dispose();
    }
}
