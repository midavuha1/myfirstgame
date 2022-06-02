package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Start extends Game {

	SpriteBatch batch;
	BitmapFont font;


	public void create() {
		batch = new SpriteBatch();
		// libGDX по умолчанию использует Arial шрифт.
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // важно!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
