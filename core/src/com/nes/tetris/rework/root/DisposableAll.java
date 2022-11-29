package com.nes.tetris.rework.root;

import com.badlogic.gdx.utils.Disposable;

import java.util.Arrays;

public interface DisposableAll extends Disposable {

    @Override
    default void dispose() {
        disposeAll();
    }

    default void disposeAll() {
        Arrays.stream(getClass().getDeclaredFields())
                .filter(field -> Disposable.class.isAssignableFrom(field.getType()))
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                })
                .map(o -> (Disposable) o)
                .forEach(Disposable::dispose);
    }
}
