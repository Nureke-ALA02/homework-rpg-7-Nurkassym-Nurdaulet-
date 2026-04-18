package com.narxoz.rpg.observer;

public class DeathObserver implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.HERO_DIED) {
            System.out.println(event.getSourceName() + " has fallen!");
        }
    }
}