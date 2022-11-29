package com.nes.tetris.rework.root.input;

import com.badlogic.gdx.controllers.ControllerMapping;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@Getter
public enum ControlAction {

    RIGHT(mapping -> mapping.buttonDpadRight),
    LEFT(mapping -> mapping.buttonDpadLeft),
    UP(mapping -> mapping.buttonDpadUp),
    DOWN(mapping -> mapping.buttonDpadDown),
    SHOW_NEXT(mapping -> mapping.buttonBack),//TODO RENAME TO "SELECT"
    PAUSE(mapping -> mapping.buttonStart),
    ROTATE_RIGHT(mapping -> mapping.buttonB),
    ROTATE_LEFT(mapping -> mapping.buttonA);

    private final Function<ControllerMapping, Integer> buttonIndexFunction;

}
