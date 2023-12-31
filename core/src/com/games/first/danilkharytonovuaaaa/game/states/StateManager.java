package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;


public class StateManager {
    private Stack<State> states;


    public StateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dot) {
        states.peek().update(dot);
    }


    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }


}
