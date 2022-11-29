package com.nes.tetris.rework.scene.title;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.nes.tetris.rework.root.graphics.Graphics;

class TitleGraphics extends Graphics implements Disposable {

    private final SpriteBatch batch = new SpriteBatch();
    private final Texture titleImage = new Texture("Title.png");

    @Override
    protected void graphicsTik() {
        batch.begin();
        batch.draw(titleImage, 0, 0);
        batch.end();
    }

}
