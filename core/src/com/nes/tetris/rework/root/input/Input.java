package com.nes.tetris.rework.root.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.nes.tetris.rework.root.ControlAction;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class Input {

    private final Controls controls = new Controls();


    public Input(Controller controller) {

        Map<Integer, ControlAction> keyMapping =
                stream(ControlAction.values())
                        .collect(toMap(
                                controlAction ->
                                        controlAction.getButtonIndexFunction().apply(controller.getMapping()),
                                controlAction ->
                                        controlAction));


        controller.addListener(new ControllerAdapter() {
            @Override
            public boolean buttonDown(Controller controller, int buttonIndex) {

                ControlAction controlAction = keyMapping.get(buttonIndex);
                Controls.Button button = controls.getButton(controlAction);

                button.setJustPressed(true);
                button.setPressed(true);

                return super.buttonDown(controller, buttonIndex);
            }

            @Override
            public boolean buttonUp(Controller controller, int buttonIndex) {

                ControlAction controlAction = keyMapping.get(buttonIndex);
                Controls.Button button = controls.getButton(controlAction);

                button.setPressed(false);

                return super.buttonUp(controller, buttonIndex);
            }
        });
    }

    public Controls getControls() {
        return controls;
    }

    public void afterTik() {
        controls.releaseJustPressed();
    }

}
