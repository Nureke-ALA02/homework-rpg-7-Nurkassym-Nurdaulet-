package com.narxoz.rpg.strategy;

public class AggressiveStrategy implements CombatStrategy {

    @Override
    public int calculateDamage(int basePower) {
        return basePower + 10;
    }

    @Override
    public int calculateDefense(int baseDefense) {
        return baseDefense - 2;
    }

    @Override
    public String getName() {
        return "Aggressive";
    }
}