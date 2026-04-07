package com.narxoz.rpg.observer;

/**
 * Represents a single game event fired during a dungeon encounter.
 * Passed to all registered observers when something significant occurs.
 */
public class GameEvent {

    private final GameEventType type;
    private final String sourceName;
    private final int value;

    /**
     * Constructs a new GameEvent with the given type, source, and associated value.
     *
     * @param type       the type of event that occurred
     * @param sourceName the name of the entity that triggered the event
     * @param value      a relevant numeric value (damage dealt, HP remaining, phase number, etc.)
     */
    public GameEvent(GameEventType type, String sourceName, int value) {
        this.type = type;
        this.sourceName = sourceName;
        this.value = value;
    }

    public GameEventType getType() { return type; }
    public String getSourceName() { return sourceName; }
    public int getValue() { return value; }
}
