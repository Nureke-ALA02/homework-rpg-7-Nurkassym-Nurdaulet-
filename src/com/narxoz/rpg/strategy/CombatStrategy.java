package com.narxoz.rpg.strategy;

/**
 * Defines the combat algorithm a combatant uses when attacking and defending.
 * Implementations determine how base stats are modified during battle.
 */
public interface CombatStrategy {

    /**
     * Calculates the actual damage to deal given the combatant's base attack power.
     *
     * @param basePower the combatant's raw attack power
     * @return the effective damage to apply to the target
     */
    int calculateDamage(int basePower);

    /**
     * Calculates the effective defense given the combatant's base defense stat.
     *
     * @param baseDefense the combatant's raw defense value
     * @return the effective defense to subtract from incoming damage
     */
    int calculateDefense(int baseDefense);

    /**
     * Returns the name of this strategy (used in battle logs).
     *
     * @return the display name of this strategy
     */
    String getName();
}
