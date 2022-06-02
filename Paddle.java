package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    int Heihgty;
    int Widthx;
    int paddlex;
    int paddley;


    public Paddle(int paddlex, int paddley, int Widthx, int Heihgty) {
        this.paddlex = paddlex;
        this.paddley = paddley;
        this.Heihgty = Heihgty;
        this.Widthx = Widthx;
    }

    public void update() {
        paddlex = Gdx.input.getX();;
    }



    public void draw(ShapeRenderer shape) {
        shape.rect(paddlex, paddley, Widthx, Heihgty);
    }
}
