package com.nes.tetris.rework.scene.menua;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.utils.Point;

import static com.badlogic.gdx.graphics.Color.valueOf;

class MenuAGraphics extends Graphics {

    private final SpriteBatch batch = new SpriteBatch();
    private final Texture menuImage = new Texture("menuA.png");

    private Point highlightingPoint = new Point(0, 0);

    @Override
    protected void graphicsTik() {
        batch.begin();

        TextureData textureData = menuImage.getTextureData();
        textureData.prepare();
        Pixmap pixmap = textureData.consumePixmap();

        int startX = 156 + highlightingPoint.getX() * 48;
        int startY = 227 + highlightingPoint.getY() * 48;

        int endX = startX + 48;
        int endY = startY + 48;

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {

                if (pixmap.getPixel(x, y) == 255) {
                    pixmap.setColor(valueOf("FC9838"));
                    pixmap.drawPixel(x, y);
                }

            }
        }

        Texture imageWithSelection = new Texture(pixmap);
        batch.draw(imageWithSelection, 0, 0);
        batch.end();

        if (textureData.disposePixmap()) {
            pixmap.dispose();
        }
        imageWithSelection.dispose();
    }

    protected void setHighlightingPoint(Point point) {
        highlightingPoint = point;
    }

}
