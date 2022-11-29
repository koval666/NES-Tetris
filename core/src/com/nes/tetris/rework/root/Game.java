package com.nes.tetris.rework.root;

import com.nes.tetris.rework.root.input.Controls;
import com.nes.tetris.rework.root.input.Input;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {

    private final State state;
    private final Input input;

    public void tik() {
        Controls controls = input.getControls();
        controls.getButton(ControlAction.LEFT).isJustPressed();

        input.afterTik();
    }
}
