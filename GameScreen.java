package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class GameScreen implements Screen {

    final Start game;

    SpriteBatch batch;
    Texture img;
    Music rainMusic;
    OrthographicCamera camera;
    ShapeRenderer shape;
    int x = 50, y = 50;
    int xSpeed, ySpeed;
    Ball ball;
    Paddle paddle;
    ArrayList<Block> blocks = new ArrayList<>();
    int LOSE = 0;
    boolean music;



    public GameScreen(final Start game, Texture img, int xSpeed, int ySpeed) {
        this.game = game;
        this.img = img;
        batch = new SpriteBatch();

        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);

        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 50, this.xSpeed = xSpeed, this.ySpeed = ySpeed);
        paddle = new Paddle(250, 50, 180, 30);

        int blockWidth = 150;
        int blockHeight = 40;
        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 15) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 15) {
                blocks.add(new Block(x, y, blockWidth, blockHeight, false));
            }
        }

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();

        ball.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();

        paddle.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        paddle.draw(shape);
        shape.end();
        ball.checkCollision(paddle);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (Block b : blocks) {
            b.draw(shape);
            ball.checkCollision(b);
        }
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.destroyed) {
                blocks.remove(b);
                i--;
            }
        }
        shape.end();

        if(ball.y <= 0){
            rainMusic.stop();
            game.setScreen(new GameOverScreen(game, img, xSpeed, ySpeed));
        }
    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        rainMusic.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        img.dispose();
        rainMusic.dispose();
    }
}
