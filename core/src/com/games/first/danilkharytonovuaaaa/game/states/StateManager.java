package com.games.first.danilkharytonovuaaaa.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

interface Manager{
    void push(State state);
    void pop();
    void set(State state);
    void update(float dot);
    void render(SpriteBatch batch);
}

public class StateManager implements Manager{
    private Stack<State> states;


    public StateManager(){
        states = new Stack<State>();
    }

    @Override
    public void push(State state){
        states.push(state);
    }

    @Override
    public void pop(){
        states.pop();
    }
    @Override
    public void set(State state){
        states.pop();
        states.push(state);
    }

    @Override
    public void update(float dot) {
        states.peek().update(dot);
    }

    @Override
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }

}
