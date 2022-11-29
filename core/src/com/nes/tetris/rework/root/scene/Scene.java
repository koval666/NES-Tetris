package com.nes.tetris.rework.root.scene;

import com.nes.tetris.rework.root.DisposableAll;
import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.root.input.Controls;

public abstract class Scene implements DisposableAll {

    public final void tik(Controls controls) {
        sceneTik(controls);
        getGraphics().tik();
    }

    protected abstract void sceneTik(Controls controls);

    protected abstract Graphics getGraphics();
}
