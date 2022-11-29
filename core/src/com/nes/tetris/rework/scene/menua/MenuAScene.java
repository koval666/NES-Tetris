package com.nes.tetris.rework.scene.menua;

import com.nes.tetris.rework.root.graphics.Graphics;
import com.nes.tetris.rework.root.input.ControlAction;
import com.nes.tetris.rework.root.input.Controls;
import com.nes.tetris.rework.root.scene.Scene;
import com.nes.tetris.rework.scene.menu.MusicType;
import com.nes.tetris.rework.utils.Point;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class MenuAScene extends Scene {

    private final MenuAGraphics graphics = new MenuAGraphics();
    private final MenuASound sound = new MenuASound();

    private final MenuASceneFinishHandler finishHandler;
    private final MusicType musicType;

    private final List<Row> levelRows;

    private Point levelPoint = new Point(0, 0);

    public MenuAScene(@NonNull MusicType musicType,
                      MenuASceneFinishHandler finishHandler) {
        this.musicType = musicType;
        this.finishHandler = finishHandler;

        List<Row> levels = new ArrayList<>();
        levels.add(new Row().setLevels(asList(0, 1, 2, 3, 4)));
        levels.add(new Row().setLevels(asList(5, 6, 7, 8, 9)));

        levelRows = Collections.unmodifiableList(levels);

        graphics.setHighlightingPoint(levelPoint);
    }

    @Override
    protected void sceneTik(Controls controls) {
        if (controls.getButton(ControlAction.ROTATE_LEFT).isJustPressed()) {
            sound.playBackSound();
            backToPreviousScene();
            return;
        }

        if (controls.getButton(ControlAction.PAUSE).isJustPressed()) {
            sound.playChooseSound();

            int level = getValue(levelPoint, levelRows);
            if (controls.getButton(ControlAction.ROTATE_RIGHT).isPressed()) {
                level += 10;
            }
            finishScene(level);
            return;
        }

        if (isNavigationKeyJustPressed(controls)) {
            sound.playBeep();
            Point newPoint = levelPoint;

            if (controls.getButton(ControlAction.UP).isJustPressed()) {
                newPoint = new Point(newPoint.getX(), newPoint.getY() - 1);
            }

            if (controls.getButton(ControlAction.DOWN).isJustPressed()) {
                newPoint = new Point(newPoint.getX(), newPoint.getY() + 1);
            }

            if (controls.getButton(ControlAction.LEFT).isJustPressed()) {
                newPoint = new Point(newPoint.getX() - 1, newPoint.getY());
            }

            if (controls.getButton(ControlAction.RIGHT).isJustPressed()) {
                newPoint = new Point(newPoint.getX() + 1, newPoint.getY());
            }

            if (inBounds(newPoint, levelRows)) {
                levelPoint = newPoint;
            }
            graphics.setHighlightingPoint(levelPoint);
        }

    }

    private int getValue(Point point, List<Row> rows) {
        return rows.get(point.getY())
                .getLevels()
                .get(point.getX());
    }

    private boolean inBounds(Point point, List<Row> rows) {
        return point.getY() >= 0
                && point.getY() < rows.size()
                &&
                point.getX() >= 0
                && point.getX() <
                rows.get(point.getY())
                        .getLevels()
                        .size();
    }

    private boolean isNavigationKeyJustPressed(Controls controls) {
        return controls.getButton(ControlAction.UP).isJustPressed()
                || controls.getButton(ControlAction.DOWN).isJustPressed()
                || controls.getButton(ControlAction.LEFT).isJustPressed()
                || controls.getButton(ControlAction.RIGHT).isJustPressed();
    }


    @Override
    protected Graphics getGraphics() {
        return graphics;
    }

    private void finishScene(int level) {
        dispose();
        finishHandler.handleMenuASceneFinish(level, musicType);
    }

    private void backToPreviousScene() {
        dispose();
        finishHandler.handleMenuASceneBack();
    }


    @Data
    @Accessors(chain = true)
    static class Row {
        List<Integer> levels;
    }

}

