package com.iceteaviet.clonybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClonyBird extends ApplicationAdapter {
	private static final int STATE_IDLE = 0;
	private static final int STATE_PLAYING = 1;
	SpriteBatch batch;
	Texture bg;
	Texture[] bird;
	private int currGameState = STATE_IDLE;
	private int currBirdY = 100;
	private int gravity = 2;
	private int velocity = 0;

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
		if (currGameState == STATE_IDLE) {
			if (Gdx.input.justTouched()) {
				currGameState = STATE_PLAYING;
				currBirdY = Gdx.graphics.getHeight() / 2 - bird[flapState].getHeight() / 2;
			}
		} else {
			//Playing
			if (Gdx.input.justTouched()) {
				velocity = 30;
			}

			if (currBirdY > 0 || velocity > 0) {
				velocity -= gravity;
				currBirdY += velocity;
			}
		}

		flapState = 1 - flapState;

		batch.begin();
		batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(bird[flapState], Gdx.graphics.getWidth() / 2 - bird[flapState].getWidth() / 2, currBirdY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
	}
}
