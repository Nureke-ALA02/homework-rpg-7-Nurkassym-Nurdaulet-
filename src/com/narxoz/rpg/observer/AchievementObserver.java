package com.narxoz.rpg.observer;

public class AchievementObserver implements GameObserver {

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.BOSS_DEFEATED) {
            System.out.println("🏆 Achievement unlocked: Boss Slayer!");
        }
    }
}