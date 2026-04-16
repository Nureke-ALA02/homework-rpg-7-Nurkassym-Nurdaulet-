package com.narxoz.rpg.observer;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class HealObserver implements GameObserver {

    private final List<Hero> heroes;

    public HealObserver(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.HERO_LOW_HP) {
            for (Hero h : heroes) {
                if (h.getName().equals(event.getSourceName())) {
                    h.heal(10);
                    System.out.println("Healed " + h.getName());
                }
            }
        }
    }
}