package com.nes.tetris.rework.scene.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.nes.tetris.rework.root.DisposableAll;

class MenuSound implements DisposableAll {

    private final Sound beep = Gdx.audio.newSound(Gdx.files.internal("sfx/menu.mp3"));
    private final Sound chooseSound = Gdx.audio.newSound(Gdx.files.internal("sfx/menuSelect-alt.mp3"));
    private final Sound backSound = Gdx.audio.newSound(Gdx.files.internal("sfx/menuSelect.mp3"));

    private final Music music1 = Gdx.audio.newMusic(Gdx.files.internal("1-music.ogg"));
    private final Music music2 = Gdx.audio.newMusic(Gdx.files.internal("2-music.ogg"));
    private final Music music3 = Gdx.audio.newMusic(Gdx.files.internal("3-music.ogg"));


    public MenuSound() {
        music1.setLooping(true);
        music2.setLooping(true);
        music3.setLooping(true);
    }

    public void playBeep() {
        beep.play();
    }

    public void playChooseSound() {
        chooseSound.play();
    }

    public void playBackSound() {
        backSound.play();
    }

    public void playMusic1() {
        music1.play();
    }

    public void playMusic2() {
        music2.play();
    }

    public void playMusic3() {
        music3.play();
    }

    public void stopAllMusic() {
        music1.stop();
        music2.stop();
        music3.stop();
    }

}
