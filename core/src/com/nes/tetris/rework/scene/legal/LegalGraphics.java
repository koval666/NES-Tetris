package com.nes.tetris.rework.scene.legal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nes.tetris.rework.root.graphics.Graphics;

class LegalGraphics extends Graphics {

    private final SpriteBatch batch = new SpriteBatch();
    private final Texture legalImage = new Texture("law.png");

    @Override
    protected void graphicsTik() {
        batch.begin();
        batch.draw(legalImage, 0, 0);
        batch.end();
    }
}
