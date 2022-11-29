package com.nes.tetris.rework.scene.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.nes.tetris.rework.root.BatchNotDrawingException;
import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.utils.Point;
import lombok.NonNull;

class MenuGraphics extends Graphics implements Disposable {

    private final SpriteBatch batch = new SpriteBatch();
    private final Texture menuImage = new Texture("menu.png");
    private final TextureAtlas textureAtlas = new TextureAtlas("sprites.txt");
    private final Sprite musicSelector = textureAtlas.createSprite("musicSelector");
    private final Sprite typeSelector = textureAtlas.createSprite("typeSelector");

    private GameType gameType = GameType.A_TYPE;
    private MusicType musicType = MusicType.MUSIC_1;

    public void selectGameType(@NonNull GameType gameType) {
        this.gameType = gameType;
    }

    public void selectMusicType(@NonNull MusicType musicType) {
        this.musicType = musicType;
    }

    @Override
    protected void graphicsTik() {
        batch.begin();
        batch.draw(menuImage, 0, 0);

        drawGameTypeSelection();
        drawMusicTypeSelection();

        batch.end();
    }

    private void drawGameTypeSelection() {
        if (!batch.isDrawing()) {
            throw new BatchNotDrawingException();
        }

        Point spritePoint = gameType.getSelectionSpritePoint();
        typeSelector.setPosition(spritePoint.getX(), spritePoint.getY());
        typeSelector.draw(batch);
    }

    private void drawMusicTypeSelection() {
        if (!batch.isDrawing()) {
            throw new BatchNotDrawingException();
        }

        Point spritePoint = musicType.getSelectionSpritePoint();
        musicSelector.setPosition(spritePoint.getX(), spritePoint.getY());
        musicSelector.draw(batch);
    }

}
