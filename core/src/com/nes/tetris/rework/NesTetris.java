package com.nes.tetris.rework;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controllers;
import com.nes.tetris.rework.root.Game;
import com.nes.tetris.rework.root.input.Input;

public class NesTetris extends ApplicationAdapter {

    private Game game;

    @Override
    public void create() {
        Input input = new Input(Controllers.getControllers().get(0));
        game = new Game(input);
        game.init();
    }

    @Override
    public void render() {
        game.tik();
        game.afterTik();
    }
}
