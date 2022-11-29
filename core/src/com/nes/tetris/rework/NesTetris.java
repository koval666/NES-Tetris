package com.nes.tetris.rework;

import com.badlogic.gdx.ApplicationAdapter;
import com.nes.tetris.rework.root.Game;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NesTetris extends ApplicationAdapter {

    private final Game game;

    @Override
    public void create() {
    }

    @Override
    public void render() {
        game.tik();
    }
}
