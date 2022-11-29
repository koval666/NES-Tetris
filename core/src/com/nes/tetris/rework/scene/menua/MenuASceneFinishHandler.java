package com.nes.tetris.rework.scene.menua;

import com.nes.tetris.rework.scene.menu.MusicType;

public interface MenuASceneFinishHandler {

    void handleMenuASceneFinish(int level, MusicType musicType);

    void handleMenuASceneBack();
}
