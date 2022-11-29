package com.nes.tetris.rework.scene.title;

import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.root.input.ControlAction;
import com.nes.tetris.rework.root.input.Controls;
import com.nes.tetris.rework.root.scene.Scene;

public class TitleScene extends Scene {

    private final TitleGraphics graphics = new TitleGraphics();
    private final TitleSound sound = new TitleSound();

    private final TitleSceneFinishHandler finishHandler;

    public TitleScene(TitleSceneFinishHandler finishHandler) {
        this.finishHandler = finishHandler;
    }

    @Override
    protected void sceneTik(Controls controls) {
        if (controls.getButton(ControlAction.PAUSE).isJustPressed()) {
            sound.playBeep();
            finishScene();
        }
    }

    @Override
    protected Graphics getGraphics() {
        return graphics;
    }

    private void finishScene() {
        dispose();
        finishHandler.handleTitleSceneFinish();
    }

}
