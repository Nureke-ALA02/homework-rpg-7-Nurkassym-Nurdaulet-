package com.narxoz.rpg.observer;

/**
 * Implemented by any object that wants to be notified of game events
 * during a dungeon encounter.
 */
public interface GameObserver {

    /**
     * Called by the publisher whenever a game event occurs.
     *
     * @param event the event that was fired
     */
    void onEvent(GameEvent event);
}
