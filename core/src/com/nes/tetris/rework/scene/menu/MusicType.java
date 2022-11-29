package com.nes.tetris.rework.scene.menu;

import com.nes.tetris.rework.utils.Point;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

/***
 * The order should be the same as in the menu.png
 */
@RequiredArgsConstructor
@Getter
public enum MusicType {

    MUSIC_1(
            MenuSound::playMusic1,
            new Point(307, 237)),

    MUSIC_2(
            MenuSound::playMusic2,
            new Point(307, 189)),

    MUSIC_3(
            MenuSound::playMusic3,
            new Point(307, 141)),

    OFF(
            menuSound -> {//do nothing
            },
            new Point(307, 93));

    private final Consumer<MenuSound> playMusicFunction;
    private final Point selectionSpritePoint;

    public MusicType getNext() {
        int ordinal = this.ordinal();

        if (ordinal == values().length - 1) {
            return this;
        } else {
            return values()[ordinal + 1];
        }
    }

    public MusicType getPrevious() {
        int ordinal = ordinal();

        if (ordinal == 0) {
            return this;
        } else {
            return values()[ordinal - 1];
        }
    }

}
