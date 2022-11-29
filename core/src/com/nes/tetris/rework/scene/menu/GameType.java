package com.nes.tetris.rework.scene.menu;

import com.nes.tetris.rework.utils.Point;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GameType {
    A_TYPE(new Point(186, 482)),
    B_TYPE(new Point(474, 482));

    private final Point selectionSpritePoint;
}
