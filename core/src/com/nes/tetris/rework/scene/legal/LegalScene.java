package com.nes.tetris.rework.scene.legal;

import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.root.input.ControlAction;
import com.nes.tetris.rework.root.input.Controls;
import com.nes.tetris.rework.root.scene.Scene;

public class LegalScene extends Scene {

    private final long legalTimer = getCurrentTimeMillis();
    private final LegalGraphics graphics = new LegalGraphics();

    private final LegalSceneFinishHandler finishHandler;

    public LegalScene(LegalSceneFinishHandler finishHandler) {
        this.finishHandler = finishHandler;
    }

    @Override
    protected void sceneTik(Controls controls) {

        long timeDiff = getCurrentTimeMillis() - legalTimer;

        if (timeDiff >= 4250) {
            if (controls.getButton(ControlAction.PAUSE).isJustPressed()) {
                finishScene();
                return;
            }
        }

        if (timeDiff >= 8500) {
            finishScene();
            return;
        }
    }

    @Override
    protected Graphics getGraphics() {
        return graphics;
    }

    private void finishScene() {
        dispose();
        finishHandler.handleLegalSceneFinish();
    }

    private long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

}
