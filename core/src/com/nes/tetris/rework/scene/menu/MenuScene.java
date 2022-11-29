package com.nes.tetris.rework.scene.menu;

import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.root.input.ControlAction;
import com.nes.tetris.rework.root.input.Controls;
import com.nes.tetris.rework.root.scene.Scene;

public class MenuScene extends Scene {

    private final MenuGraphics graphics = new MenuGraphics();
    private final MenuSound sound = new MenuSound();

    private final MenuSceneFinishHandler finishHandler;

    private GameType gameType = GameType.A_TYPE;
    private MusicType musicType = MusicType.MUSIC_1;

    public MenuScene(MenuSceneFinishHandler finishHandler) {
        this.finishHandler = finishHandler;
        sound.playMusic1();
    }

    @Override
    protected void sceneTik(Controls controls) {
        if (controls.getButton(ControlAction.RIGHT).isJustPressed()) {
            sound.playBeep();
            gameType = GameType.B_TYPE;
            graphics.selectGameType(gameType);
        }
        if (controls.getButton(ControlAction.LEFT).isJustPressed()) {
            sound.playBeep();
            gameType = GameType.A_TYPE;
            graphics.selectGameType(gameType);
        }

//todo remove code duplication
        if (controls.getButton(ControlAction.DOWN).isJustPressed()) {

            sound.playBeep();
            MusicType nextMusicType = musicType.getNext();

            if (nextMusicType != musicType) {
                sound.stopAllMusic();
                musicType = nextMusicType;
                musicType.getPlayMusicFunction().accept(sound);
                graphics.selectMusicType(musicType);
            }
        }

        if (controls.getButton(ControlAction.UP).isJustPressed()) {

            sound.playBeep();
            MusicType previousMusicType = musicType.getPrevious();

            if (previousMusicType != musicType) {
                sound.stopAllMusic();
                musicType = previousMusicType;
                musicType.getPlayMusicFunction().accept(sound);
                graphics.selectMusicType(musicType);
            }
        }


        if (controls.getButton(ControlAction.PAUSE).isJustPressed()
                && gameType == GameType.A_TYPE) {
            sound.stopAllMusic();
            sound.playChooseSound();
            finishScene();
            return;
        }

        if (controls.getButton(ControlAction.ROTATE_LEFT).isJustPressed()) {
            sound.stopAllMusic();
            sound.playBackSound();
            backToPreviousScene();
            return;
        }
    }

    @Override
    protected Graphics getGraphics() {
        return graphics;
    }

    private void finishScene() {
        dispose();
        finishHandler.handleMenuSceneFinish(musicType);
    }

    private void backToPreviousScene() {
        dispose();
        finishHandler.handleMenuSceneBack();
    }

}
