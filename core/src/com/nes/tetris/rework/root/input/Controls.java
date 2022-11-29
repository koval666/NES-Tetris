package com.nes.tetris.rework.root.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class Controls {

    private final Map<ControlAction, Button> buttons;

    Controls() {
        Map<ControlAction, Button> buttonMap =
                stream(ControlAction.values())
                        .collect(toMap(o -> o, o -> new Button()));

        buttons = Collections.unmodifiableMap(buttonMap);
    }

    public Button getButton(ControlAction controlAction) {
        return buttons.get(controlAction);
    }

    void releaseJustPressed() {
        buttons.values()
                .forEach(Button::releaseJustPressed);
    }

    @Getter
    @Setter(AccessLevel.PACKAGE)
    public static class Button {
        private boolean justPressed;
        private boolean pressed;

        private void releaseJustPressed() {
            setJustPressed(false);
        }
    }
}
