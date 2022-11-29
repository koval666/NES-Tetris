package com.nes.tetris.rework.scene.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.nes.tetris.rework.root.DisposableAll;

class TitleSound implements DisposableAll {

    private final Sound beep = Gdx.audio.newSound(Gdx.files.internal("sfx/menuSelect.mp3"));

    public void playBeep() {
        beep.play();
    }

}
