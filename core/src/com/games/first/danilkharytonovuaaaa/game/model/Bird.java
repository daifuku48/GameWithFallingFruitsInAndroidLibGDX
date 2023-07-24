package com.games.first.danilkharytonovuaaaa.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    public int height = 250;
    public int width = 300;
    public float flyheight = 0;
    public float fallingHeight = 0;
    public Vector3 position;
    public Vector3 V;
    public Rectangle bounds;

    public Texture texture;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        V = new Vector3(0,0,0);
        bounds = new Rectangle(x, y, width, height);
        texture = new Texture("bird.png")
    }

    public void jump(){
        fallingHeight = 200;
    }

    public void update(){
        bounds.setPosition(position.x, position.y);
    }
}
