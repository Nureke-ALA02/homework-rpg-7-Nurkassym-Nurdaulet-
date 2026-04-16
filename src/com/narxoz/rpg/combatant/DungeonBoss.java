package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.CombatStrategy;

public class DungeonBoss {

    private final String name;
    private int hp;
    private final int maxHp;
    private final int baseAttack;
    private final int baseDefense;

    private CombatStrategy strategy;
    public DungeonBoss(String name, int hp, int attack, int defense, CombatStrategy strategy) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.strategy = strategy;
    }
    public int attack() {
        return strategy.calculateDamage(baseAttack);
    }
    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }
    public int getDefense() {
        return strategy.calculateDefense(baseDefense);
    }
    public int getHp() {
        return hp; }
    public int getMaxHp() {
        return maxHp; }
    public String getName() {
        return name; }
    public void setStrategy(CombatStrategy strategy) {
        System.out.println("Boss switched to " + strategy.getName());
        this.strategy = strategy;
    }
}