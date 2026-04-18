package com.narxoz.rpg.observer;

import com.narxoz.rpg.combatant.DungeonBoss;
import com.narxoz.rpg.strategy.AggressiveStrategy;
import com.narxoz.rpg.strategy.DefensiveStrategy;

public class BossPhaseObserver implements GameObserver {

    private final DungeonBoss boss;

    public BossPhaseObserver(DungeonBoss boss) {
        this.boss = boss;
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.BOSS_PHASE_CHANGED) {

            if (boss.getHp() < boss.getMaxHp() * 0.3) {
                boss.setStrategy(new AggressiveStrategy());
            } else {
                boss.setStrategy(new DefensiveStrategy());
            }
        }
    }
}