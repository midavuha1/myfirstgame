package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

    int x,y,width,height;
    public boolean destroyed;
    public Block(int x, int y, int width, int height, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.destroyed = destroyed;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }


}
