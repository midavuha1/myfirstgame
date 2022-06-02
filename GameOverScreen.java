package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class GameOverScreen implements Screen {

    final Start game;
    Texture gob, img;
    int xSpeed, ySpeed;
    OrthographicCamera camera;
    private static final int BANNER_WIDTH = 350;
    private static final int BANNER_Height = 450;
    private BitmapFont scoreFont;

    public GameOverScreen(final Start game, Texture img, int xSpeed, int ySpeed){
        this.game = game;
        this.img = img;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        gob = new Texture(Gdx.files.internal("ret.jpg"));
        scoreFont = new BitmapFont(Gdx.files.internal("font/score.fnt"));


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(gob, 0, 0, Gdx.graphics.getWidth() / 2 - 85, Gdx.graphics.getHeight() - BANNER_Height);


        GlyphLayout tryAgainLayout = new GlyphLayout(scoreFont,"TRY AGAIN");
        GlyphLayout mainMenuLayout = new GlyphLayout(scoreFont,"MAIN MENU");

        float tryAgainX = Gdx.graphics.getWidth() / 2 - tryAgainLayout.width /2;
        float tryAgainY = Gdx.graphics.getHeight() / 2 - tryAgainLayout.height / 2;
        float mainMenux = Gdx.graphics.getWidth() / 2 - mainMenuLayout.width /2;
        float mainMenuY = Gdx.graphics.getHeight() / 2 - mainMenuLayout.height / 2 - tryAgainLayout.height - 15;
        float touchX = Gdx.input.getX(), touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

        if(Gdx.input.isTouched()){
            System.out.print(Gdx.input.isTouched());
            if (touchX > 650 && touchX < 1800 && touchY > 270 && touchY < 350){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game, img, xSpeed, ySpeed));
                return;
            }
        }

        if(Gdx.input.isTouched()){
            if (touchX > 650 && touchX < 1800 && touchY > 50 && touchY < 100){
                this.dispose();
                game.batch.end();
                game.setScreen(new MainMenuScreen(game));
                return;
            }
        }

        scoreFont.draw(game.batch, tryAgainLayout, 300, 150);
        scoreFont.draw(game.batch, mainMenuLayout, 300, 50);
        game.batch.end();
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
    public void dispose(){
    }
}
