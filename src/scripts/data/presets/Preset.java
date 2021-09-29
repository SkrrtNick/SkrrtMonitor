package scripts.data.presets;

import lombok.Getter;
import org.tribot.script.sdk.Skill;
import scripts.api.Logger;
import scripts.data.ItemID;
import scripts.data.MethodItem;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Preset {
    GDK("Green Dragons", List.of(new MethodItem(ItemID.EXTENDED_ANTIFIRE4, 1.25), new MethodItem(ItemID.BURNING_AMULET5, 1)), List.of(new MethodItem(ItemID.DRAGON_BONES, 100), new MethodItem(ItemID.GREEN_DRAGONHIDE, 100)), List.of(Quests.DRAGON_SLAYER_I.getName()), List.of(new SkillRequirement(Skill.ATTACK, 60), new SkillRequirement(Skill.STRENGTH, 60), new SkillRequirement(Skill.DEFENCE, 60))),
    CHARGING_AIR_ORBS("Charging air orbs", List.of(new MethodItem(ItemID.UNPOWERED_ORB, 475), new MethodItem(ItemID.COSMIC_RUNE, 1425), new MethodItem(ItemID.AMULET_OF_GLORY6, 2.9)), List.of(new MethodItem(ItemID.AIR_ORB, 475)), List.of(), List.of(new SkillRequirement(Skill.MAGIC, 66))),
    CRAFTING_CLOCKWORKS("Crafting Clockworks", List.of(new MethodItem(ItemID.STEEL_BAR, 1040), new MethodItem(ItemID.COINS_995, 55000)), List.of(new MethodItem(ItemID.CLOCKWORK, 1040)), List.of(), List.of(new SkillRequirement(Skill.CONSTRUCTION, 50),new SkillRequirement(Skill.CRAFTING,8))),
    CRAFTING_GOLD_BRACELETS("Crafting Gold Bracelets", List.of(new MethodItem(ItemID.GOLD_BAR, 1400)), List.of(new MethodItem(ItemID.GOLD_BRACELET_11069, 1400)), List.of(), List.of(new SkillRequirement(Skill.CRAFTING, 7))),
    ENCHANTING_SAPPHIRE_RINGS("Enchanting Sapphire Rings", List.of(new MethodItem(ItemID.SAPPHIRE_RING, 1600), new MethodItem(ItemID.COSMIC_RUNE, 1600)), List.of(new MethodItem(ItemID.RING_OF_RECOIL, 1600)), List.of(), List.of(new SkillRequirement(Skill.MAGIC, 7))),
    HIGH_ALCHING_WATER_BATTLESTAVES("High Alching Water Battlestaves", List.of(new MethodItem(ItemID.NATURE_RUNE, 1200), new MethodItem(ItemID.WATER_BATTLESTAFF, 1200)), List.of(new MethodItem(ItemID.COINS_995, 11160000)), List.of(), List.of(new SkillRequirement(Skill.MAGIC, 55))),
    HIGH_ALCHING_AIR_BATTLESTAVES("High Alching Air Battlestaves", List.of(new MethodItem(ItemID.NATURE_RUNE, 1200), new MethodItem(ItemID.AIR_BATTLESTAFF, 1200)), List.of(new MethodItem(ItemID.COINS_995, 11160000)), List.of(), List.of(new SkillRequirement(Skill.MAGIC, 55))),
    HIGH_ALCHING_EARTH_BATTLESTAVES("High Alching Earth Battlestaves", List.of(new MethodItem(ItemID.NATURE_RUNE, 1200), new MethodItem(ItemID.EARTH_BATTLESTAFF, 1200)), List.of(new MethodItem(ItemID.COINS_995, 11160000)), List.of(), List.of(new SkillRequirement(Skill.MAGIC, 55))),
    MUD_RUNES_DIGSITE_LARGE_POUCH("Runecrafting Mud Runes (Large Pouch)", List.of(new MethodItem(ItemID.PURE_ESSENCE, 3200), new MethodItem(ItemID.WATER_RUNE, 3200), new MethodItem(ItemID.ASTRAL_RUNE, 160), new MethodItem(ItemID.BINDING_NECKLACE, 10), new MethodItem(ItemID.RING_OF_DUELING8, 10),new MethodItem(ItemID.RUBY_NECKLACE, 20),new MethodItem(ItemID.COSMIC_RUNE, 20)), List.of(new MethodItem(ItemID.MUD_RUNE, 3200)), List.of(), List.of(new SkillRequirement(Skill.RUNECRAFT, 50))),
    SMITHING_RUNE_PLATESKIRTS("Smithing Rune Plateskirts", List.of(new MethodItem(ItemID.RUNITE_BAR, 2700)), List.of(new MethodItem(ItemID.RUNE_PLATESKIRT, 900)), List.of(), List.of(new SkillRequirement(Skill.SMITHING, 99))),
    ZULRAH("Killing Zulrah", List.of(new MethodItem(ItemID.ZULANDRA_TELEPORT, 10),new MethodItem(ItemID.PRAYER_POTION4, 10),new MethodItem(ItemID.DIVINE_RANGING_POTION4, 3),new MethodItem(ItemID.ANTIVENOM4_12913, 5),new MethodItem(ItemID.RING_OF_RECOIL, 10),new MethodItem(ItemID.MONKFISH, 200),new MethodItem(ItemID.ADAMANT_DART, 130),new MethodItem(ItemID.ZULRAHS_SCALES, 910),new MethodItem(ItemID.FIRE_RUNE, 2600),new MethodItem(ItemID.CHAOS_RUNE, 520),new MethodItem(ItemID.DEATH_RUNE, 520)), List.of(new MethodItem(ItemID.ZULRAHS_SCALES, 4392),new MethodItem(ItemID.TANZANITE_FANG, 0.039),new MethodItem(ItemID.MAGIC_FANG, 0.039),new MethodItem(ItemID.SERPENTINE_VISAGE, 0.039), new MethodItem(ItemID.UNCUT_ONYX, 0.039),new MethodItem(ItemID.DRAGON_MED_HELM, 0.32),new MethodItem(ItemID.DRAGON_HALBERD,0.32),new MethodItem(ItemID.LAW_RUNE,386),new MethodItem(ItemID.DEATH_RUNE,578),new MethodItem(ItemID.CHAOS_RUNE,964),new MethodItem(ItemID.PURE_ESSENCE,2410),new MethodItem(ItemID.TOADFLAX,8.03),new MethodItem(ItemID.SNAPDRAGON,3.21),new MethodItem(ItemID.DWARF_WEED,9.64),new MethodItem(ItemID.TORSTOL,3.21),new MethodItem(ItemID.FLAX,1606),new MethodItem(ItemID.SNAKESKIN,61.85),new MethodItem(ItemID.DRAGONSTONE_BOLT_TIPS,15.42),new MethodItem(ItemID.YEW_LOGS,56.22),new MethodItem(ItemID.COAL,257),new MethodItem(ItemID.RUNITE_ORE,3.53),new MethodItem(ItemID.MAGIC_SEED,0.64),new MethodItem(ItemID.CALQUAT_TREE_SEED,1.93),new MethodItem(ItemID.PAPAYA_TREE_SEED,2.89),new MethodItem(ItemID.PALM_TREE_SEED,0.96),new MethodItem(ItemID.TOADFLAX_SEED,0.64),new MethodItem(ItemID.SNAPDRAGON_SEED,0.32),new MethodItem(ItemID.DWARF_WEED_SEED,0.64),new MethodItem(ItemID.TORSTOL_SEED,0.32),new MethodItem(ItemID.ZULANDRA_TELEPORT,9.64),new MethodItem(ItemID.DRAGON_BONES,15.42),new MethodItem(ItemID.COCONUT,16.06),new MethodItem(ItemID.SWAMP_TAR,803),new MethodItem(ItemID.GRAPES,241),new MethodItem(ItemID.BATTLESTAFF,16.06),new MethodItem(ItemID.ANTIDOTE4_5952,14.46),new MethodItem(ItemID.MANTA_RAY,67.47),new MethodItem(ItemID.MAHOGANY_LOGS,64.26),new MethodItem(ItemID.JAR_OF_SWAMP,0.0067)), List.of(), List.of(new SkillRequirement(Skill.DEFENCE, 70), new SkillRequirement(Skill.RANGED,80),new SkillRequirement(Skill.MAGIC,80), new SkillRequirement(Skill.PRAYER,45)));


    private String name;
    private List<MethodItem> inputItems;
    private List<MethodItem> outputItems;
    private List<String> questRequirements;
    private List<SkillRequirement> skillRequirements;

    Preset(String name, List<MethodItem> inputItems, List<MethodItem> outputItems, List<String> questRequirements, List<SkillRequirement> skillRequirements) {
        this.name = name;
        this.inputItems = inputItems;
        this.outputItems = outputItems;
        this.questRequirements = questRequirements;
        this.skillRequirements = skillRequirements;
    }

    public static List<Preset> getAllPresets() {
        return List.of(Preset.values());
    }

    public static List<Preset> getViablePresets(List<String> completedQuests, List<SkillRequirement> skillLevels) {
        List<Preset> viablePresets = new ArrayList<>();
        for (Preset p : Preset.values()) {
            if (p.getSkillRequirements().size() == 0 && p.getQuestRequirements().size() == 0) {
                viablePresets.add(p);
                continue;
            }
            if (!completedQuests.containsAll(p.getQuestRequirements())) {
                continue;
            }
            if (!skillLevels.containsAll(p.getSkillRequirements())) {
                continue;
            }
            viablePresets.add(p);
        }
        return viablePresets;
    }

    @Override
    public String toString() {
        return name;
    }
}
