package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelsScreen implements Screen {

    final Start game;
    Texture img1, img2, img3, img4;
    int xSpeed, ySpeed;
    OrthographicCamera camera;
    private BitmapFont scoreFont;

    public LevelsScreen(final Start gam) {
        game = gam;

        scoreFont = new BitmapFont(Gdx.files.internal("font/score.fnt"));
        img1 = new Texture(Gdx.files.internal("cyberpunk-street.png"));
        img2 = new Texture(Gdx.files.internal("img2.png"));
        img3 = new Texture(Gdx.files.internal("img3.png"));
        img4 = new Texture(Gdx.files.internal("img4.png"));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        GlyphLayout LevelChoose = new GlyphLayout(scoreFont,"CHOOSE THE LEVEL");
        GlyphLayout LevelOne = new GlyphLayout(scoreFont,"FIRST LEVEL");
        GlyphLayout LevelSecond = new GlyphLayout(scoreFont,"SECOND LEVEL");
        GlyphLayout LevelThird = new GlyphLayout(scoreFont,"THIRD LEVEL");
        GlyphLayout LevelFourth = new GlyphLayout(scoreFont,"FOURTH LEVEL");

        float touchX = Gdx.input.getX(), touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

        if(Gdx.input.isTouched()){
            System.out.print(Gdx.input.isTouched());
            if (touchX > 200 && touchX < 1600 && touchY > 600 && touchY < 680){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game, img1, 5, 5));
                return;
            }
        }

        if(Gdx.input.isTouched()){
            if (touchX > 200 && touchX < 1700 && touchY > 450 && touchY <530){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game,img2, 7,7));
                return;
            }
        }

        if(Gdx.input.isTouched()){
            if (touchX > 200 && touchX < 1700 && touchY > 300 && touchY <380){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game,img3,10,10));
                return;
            }
        }

        if(Gdx.input.isTouched()){
            if (touchX > 200 && touchX < 1700 && touchY > 100 && touchY <180){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game,img4, 12, 12));
                return;
            }
        }

        scoreFont.draw(game.batch, LevelChoose, 150, 400);
        scoreFont.draw(game.batch, LevelOne, 200, 300);
        scoreFont.draw(game.batch, LevelSecond, 200, 225);
        scoreFont.draw(game.batch, LevelThird, 200, 150);
        scoreFont.draw(game.batch, LevelFourth, 200, 75);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

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
    }
}
