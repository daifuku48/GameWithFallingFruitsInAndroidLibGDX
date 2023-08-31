package com.games.first.danilkharytonovuaaaa.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CatcherBox {
    public Texture box;
    public Rectangle bounds;
    public Vector2 position;
    public float movementSpeed;

    public CatcherBox(float initialX, float initialY, float movementSpeed) {
        box = new Texture("box.png");
        position = new Vector2(initialX, initialY);
        bounds = new Rectangle(position.x, position.y - 170, box.getWidth() - 100,box.getHeight() - 150);
        this.movementSpeed = movementSpeed;
    }

    public void moveLeft() {
        position.x -= movementSpeed;
        bounds.x = position.x;
    }

    public void moveRight() {
        position.x += movementSpeed;
        bounds.x = position.x;
    }

    public void updateBounds() {
        bounds.setPosition(position);
    }

    public boolean collidesWithItem(Rectangle itemBounds) {
        return bounds.overlaps(itemBounds);
    }
}
