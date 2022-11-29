package com.nes.tetris.rework.root.graphics;

import com.badlogic.gdx.utils.ScreenUtils;
import com.nes.tetris.rework.root.DisposableAll;

public abstract class Graphics implements DisposableAll {

    public final void tik() {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        graphicsTik();
    }

    protected abstract void graphicsTik();

}
