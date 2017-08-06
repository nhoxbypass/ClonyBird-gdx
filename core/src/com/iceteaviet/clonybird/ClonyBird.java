package com.iceteaviet.clonybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClonyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bg;
	Texture[] bird;

	private int flapState = 0;
	
	@Override
	public void create () {
		bird = new Texture[2];
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		bird[0] = new Texture("bird.png");
		bird[1] = new Texture("bird2.png");
	}

	@Override
	public void render () {
		flapState = 1 - flapState;

		batch.begin();
		batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(bird[flapState], Gdx.graphics.getWidth()/2 - bird[flapState].getWidth()/2, Gdx.graphics.getHeight()/2 - bird[flapState].getWidth()/2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
	}
}
