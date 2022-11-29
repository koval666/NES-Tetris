package com.nes.tetris.rework;

//todo можно пока пойти по KISS и сделать вызовы напрямую
public interface EventHandler<T extends Event> {

    void handleEvent(T event);
}
