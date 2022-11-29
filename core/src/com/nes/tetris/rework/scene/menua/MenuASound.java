package com.nes.tetris.rework.scene.menua;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.nes.tetris.rework.root.DisposableAll;

class MenuASound implements DisposableAll {

    private final Sound beep = Gdx.audio.newSound(Gdx.files.internal("sfx/menu.mp3"));
    //todo возможно звуки при смене сцены не проигрываются из-за dispose
    private final Sound chooseSound = Gdx.audio.newSound(Gdx.files.internal("sfx/menuSelect-alt.mp3"));
    private final Sound backSound = Gdx.audio.newSound(Gdx.files.internal("sfx/menuSelect.mp3"));

    public void playBeep() {
        beep.play();
    }

    public void playChooseSound() {
        chooseSound.play();
    }

    public void playBackSound() {
        backSound.play();
    }

}
