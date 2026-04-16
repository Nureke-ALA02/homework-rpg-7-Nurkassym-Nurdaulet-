package com.narxoz.rpg.strategy;

public class DefensiveStrategy implements CombatStrategy {

    @Override
    public int calculateDamage(int basePower) {
        return basePower - 3;
    }

    @Override
    public int calculateDefense(int baseDefense) {
        return baseDefense + 10;
    }

    @Override
    public String getName() {
        return "Defensive";
    }
}