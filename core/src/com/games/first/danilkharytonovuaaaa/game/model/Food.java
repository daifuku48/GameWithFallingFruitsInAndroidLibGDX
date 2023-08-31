package com.games.first.danilkharytonovuaaaa.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Food {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    private Vector3 position;
    private Vector3 velocity;
    public Rectangle bounds;
    public boolean isOver;
    private Texture texture;
    private Random random;

    private String[] pathes = {
            "food2.png",
            "food3.png","food4.png",
            "food5.png","food6.png",
            "food7.png","food8.png",
            "food9.png","food10.png"
    };

    public Food(int screenWidth) {
        random = new Random();
        isOver = false;
        position = new Vector3(random.nextInt(screenWidth - WIDTH), Gdx.graphics.getHeight() - 300, 0);
        velocity = new Vector3(0, 3, 0);
        bounds = new Rectangle(position.x, position.y, WIDTH, HEIGHT);
        texture = new Texture(pathes[random.nextInt(pathes.length)]);
    }

    public void update(float deltaTime) {
        velocity.add(0, -20000 * deltaTime, 0); // Gravity effect, adjust as needed
        velocity.scl(deltaTime);
        position.add(velocity.x, velocity.y, 0);


        if (position.y < 0) {
            position.y = 0;
            velocity.y = 0;
            isOver = true;
        }

        bounds.setPosition(position.x, position.y);
    }

    public boolean collides(Rectangle catcherBounds) {
        return bounds.overlaps(catcherBounds);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void dispose() {
        texture.dispose();
    }
}