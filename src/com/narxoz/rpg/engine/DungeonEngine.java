package com.narxoz.rpg.engine;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.observer.*;

import java.util.List;

public class DungeonEngine {

    private final EventManager eventManager;

    public DungeonEngine(EventManager manager) {
        this.eventManager = manager;
    }

    public EncounterResult run(List<Hero> heroes, DungeonBoss boss) {

        int rounds = 0;

        while (boss.getHp() > 0 && heroes.stream().anyMatch(Hero::isAlive)) {
            rounds++;

            for (Hero hero : heroes) {
                if (!hero.isAlive()) continue;

                int damage = Math.max(0, hero.getAttackPower() - boss.getDefense());
                boss.takeDamage(damage);

                eventManager.notify(new GameEvent(
                        GameEventType.ATTACK_LANDED,
                        hero.getName(),
                        damage
                ));

                // Phase change
                if (boss.getHp() < boss.getMaxHp() * 0.6) {
                    eventManager.notify(new GameEvent(
                            GameEventType.BOSS_PHASE_CHANGED,
                            boss.getName(),
                            boss.getHp()
                    ));
                }

                if (boss.getHp() <= 0) {
                    eventManager.notify(new GameEvent(
                            GameEventType.BOSS_DEFEATED,
                            boss.getName(),
                            0
                    ));
                    break;
                }
            }

            // Boss attacks
            for (Hero hero : heroes) {
                if (!hero.isAlive()) continue;

                int dmg = Math.max(0, boss.attack() - hero.getDefense());
                hero.takeDamage(dmg);

                if (hero.getHp() < hero.getMaxHp() * 0.3) {
                    eventManager.notify(new GameEvent(
                            GameEventType.HERO_LOW_HP,
                            hero.getName(),
                            hero.getHp()
                    ));
                }

                if (!hero.isAlive()) {
                    eventManager.notify(new GameEvent(
                            GameEventType.HERO_DIED,
                            hero.getName(),
                            0
                    ));
                }
            }
        }

        long alive = heroes.stream().filter(Hero::isAlive).count();

        return new EncounterResult(
                boss.getHp() <= 0,
                rounds,
                (int) alive
        );
    }
}