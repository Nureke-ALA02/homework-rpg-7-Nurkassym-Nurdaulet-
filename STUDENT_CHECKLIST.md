# Student Checklist — Homework 7

Use this checklist to track your progress. Work through the phases in order — each phase builds on the previous one.

---

## Phase 1: Understand the Patterns

- [ ] Read `ASSIGNMENT.md` from start to finish
- [ ] In your own words, write down what Strategy does and what Observer does
- [ ] Identify the connection between the two patterns in this assignment
- [ ] Read `FAQ.md` sections on Strategy and Observer
- [ ] Review the provided source files: `CombatStrategy.java`, `GameObserver.java`, `GameEvent.java`, `GameEventType.java`

---

## Phase 2: Design on Paper First

- [ ] Sketch a class diagram showing all Strategy implementations (hero + boss) and how Hero/DungeonBoss use them
- [ ] Sketch a class diagram showing your publisher, all 5 observers, and the event classes
- [ ] Identify: which class fires each event type?
- [ ] Identify: how does DungeonBoss both publish events AND subscribe to them?
- [ ] Decide your publisher design: single event bus, or per-object observer lists?

---

## Phase 3: Implement the Strategy Pattern

- [ ] Create strategy implementations for heroes (minimum 3)
- [ ] Verify each strategy returns measurably different values for `calculateDamage` and `calculateDefense`
- [ ] Add a `CombatStrategy` field to `Hero` (extend the provided skeleton)
- [ ] Implement strategy switching on `Hero` (a setter or constructor parameter)
- [ ] Create the 3 boss phase strategies

---

## Phase 4: Implement the Observer Pattern Infrastructure

- [ ] Design and implement your publisher/subject mechanism
- [ ] Implement `BattleLogger` — verify it handles all event types
- [ ] Implement `AchievementTracker` — define at least 3 achievements
- [ ] Implement `PartySupport` — ensure it has access to the hero list for healing
- [ ] Implement `HeroStatusMonitor` — ensure it tracks all heroes, not just event sources
- [ ] Implement `LootDropper` — vary loot between phase changes and boss defeat

---

## Phase 5: Implement DungeonBoss

- [ ] Create `DungeonBoss` with HP, maxHp, attackPower, defense, and current phase
- [ ] Add a `CombatStrategy` field — set to the Phase 1 strategy in the constructor
- [ ] Implement the publisher side: a method to register observers and a method to fire events
- [ ] Implement the observer side: `onEvent()` that reacts to `BOSS_PHASE_CHANGED` and switches strategy
- [ ] Implement the HP damage method that checks thresholds and fires `BOSS_PHASE_CHANGED`

---

## Phase 6: Implement DungeonEngine

- [ ] Create `DungeonEngine` with a round-based combat loop
- [ ] Implement hero attack → boss defend → fire `ATTACK_LANDED`
- [ ] Implement boss HP threshold check → fire `BOSS_PHASE_CHANGED` when crossed
- [ ] Implement boss attack → hero defend → fire `ATTACK_LANDED`, `HERO_LOW_HP`, `HERO_DIED` as needed
- [ ] Implement win/loss condition checks
- [ ] Implement `BOSS_DEFEATED` event on boss death
- [ ] Add a max-round safeguard
- [ ] Return a filled `EncounterResult`

---

## Phase 7: Wire Everything in Main.java

- [ ] Create at least 3 heroes with different starting strategies
- [ ] Create `DungeonBoss` with stats high enough that all 3 phases appear in output
- [ ] Instantiate all 5 observers
- [ ] Register all observers with the publisher
- [ ] Switch at least one hero's strategy during the battle
- [ ] Run the encounter and print the `EncounterResult`

---

## Phase 8: Verify Output

- [ ] Boss transitions through at least 2 phases visibly in the console output
- [ ] All 5 observers produce output at some point during the run
- [ ] `BOSS_PHASE_CHANGED` triggers a visible strategy name change in the battle log
- [ ] `AchievementTracker` unlocks at least one achievement
- [ ] `LootDropper` drops loot at least once
- [ ] `PartySupport` fires at least once (adjust hero/boss stats if needed)
- [ ] Final `EncounterResult` is printed with correct values

---

## Phase 9: Draw UML Diagrams

- [ ] **Diagram 1 — Strategy:** Interface + all implementations + Hero and DungeonBoss (showing the field and usage)
- [ ] **Diagram 2 — Observer:** Observer interface + your publisher + all 5 observer classes + GameEvent + GameEventType
- [ ] Both diagrams show all relationships (implements, uses, contains) clearly and are legible at submission size

---

## Phase 10: Final Review and Submission

- [ ] All Java files compile without errors or warnings
- [ ] `Main.java` demonstrates all 7 required behaviors listed in ASSIGNMENT.md
- [ ] You have not modified any of the provided scaffold files
- [ ] Both UML diagrams are included
- [ ] ZIP your submission — source files + diagrams, no `.class` files
