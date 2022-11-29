package com.nes.tetris.rework.root;

import com.nes.tetris.rework.root.input.Input;
import com.nes.tetris.rework.root.scene.Scene;
import com.nes.tetris.rework.scene.legal.LegalScene;
import com.nes.tetris.rework.scene.legal.LegalSceneFinishHandler;
import com.nes.tetris.rework.scene.menu.MenuScene;
import com.nes.tetris.rework.scene.menu.MenuSceneFinishHandler;
import com.nes.tetris.rework.scene.menu.MusicType;
import com.nes.tetris.rework.scene.menua.MenuAScene;
import com.nes.tetris.rework.scene.menua.MenuASceneFinishHandler;
import com.nes.tetris.rework.scene.title.TitleScene;
import com.nes.tetris.rework.scene.title.TitleSceneFinishHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game implements
        LegalSceneFinishHandler,
        TitleSceneFinishHandler,
        MenuSceneFinishHandler,
        MenuASceneFinishHandler {

    private final Input input;

    private Scene currentScene;

    public void init() {
        currentScene = new LegalScene(this);
    }

    public void tik() {
        currentScene.tik(input.getControls());
    }

    public void afterTik() {
        input.afterTik();
    }

    @Override
    public void handleLegalSceneFinish() {
        currentScene = new TitleScene(this);
    }

    @Override
    public void handleTitleSceneFinish() {
        currentScene = new MenuScene(this);
    }

    @Override
    public void handleMenuSceneFinish(MusicType musicType) {
        currentScene = new MenuAScene(musicType, this);
    }

    @Override
    public void handleMenuSceneBack() {
        currentScene = new TitleScene(this);
    }

    @Override
    public void handleMenuASceneFinish(int level, MusicType musicType) {
        System.out.println(level);
        currentScene = new MenuAScene(musicType, this);
    }

    @Override
    public void handleMenuASceneBack() {
        currentScene = new MenuScene(this);
    }
}
