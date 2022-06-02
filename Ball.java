package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball implements Screen{

    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    public int help = 0;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x <= size || x >= Gdx.graphics.getWidth() - size) {
            xSpeed = -xSpeed;
        }
        if (y >= Gdx.graphics.getHeight() - size) {
            ySpeed = -ySpeed;
        } else if(y == 0) {
            help = 1;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Block block) {
        if(collidesWith(block)){
            ySpeed = - ySpeed;
            block.destroyed = true;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        int u = 0;
        if (y - 70 <= size) {
            if (x > paddle.paddlex && x < paddle.paddlex + paddle.Widthx) {
                u = 1;
            }
        } else{
            u = 0;
        }
        if(u == 0){
            return false;
        } else{
            return true;
        }
    }

    private boolean collidesWith(Block block) {
        int u = 0;
        if (y + 40 >= block.y) {
            if (x > block.x + 5 && x < block.x + block.width + 5) {
                u = 1;
            }
        } else{
            u = 0;
        }
        if(u == 0){
            return false;
        } else{
            return true;
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
