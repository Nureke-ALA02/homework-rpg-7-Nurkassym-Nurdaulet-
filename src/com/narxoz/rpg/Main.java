package com.narxoz.rpg;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.engine.*;
import com.narxoz.rpg.observer.*;
import com.narxoz.rpg.strategy.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Hero> heroes = List.of(
                new Hero("Knight", 100, 20, 10),
                new Hero("Archer", 80, 25, 5),
                new Hero("Mage", 70, 30, 3)
        );
        DungeonBoss boss = new DungeonBoss(
                "Dragon",
                200,
                25,
                8,
                new BalancedStrategy()
        );
        EventManager manager = new EventManager();
        manager.subscribe(new LoggerObserver());
        manager.subscribe(new HealObserver(heroes));
        manager.subscribe(new AchievementObserver());
        manager.subscribe(new DeathObserver());
        manager.subscribe(new BossPhaseObserver(boss));
        DungeonEngine engine = new DungeonEngine(manager);
        EncounterResult result = engine.run(heroes, boss);
        System.out.println("\n=== RESULT ===");
        System.out.println("Heroes won: " + result.isHeroesWon());
        System.out.println("Rounds: " + result.getRoundsPlayed());
        System.out.println("Survivors: " + result.getSurvivingHeroes());
    }
}