package scripts.data.presets;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Quests {
    COOKS_ASSISTANT("Cook's Assistant"),
    DEMON_SLAYER("Demon Slayer"),
    THE_RESTLESS_GHOST("The Restless Ghost"),
    ROMEO_AND_JULIET("Romeo & Juliet"),
    SHEEP_SHEARER("Sheep Shearer"),
    SHIELD_OF_ARRAV("Shield of Arrav"),
    ERNEST_THE_CHICKEN("Ernest the Chicken"),
    VAMPYRE_SLAYER("Vampyre Slayer"),
    IMP_CATCHER("Imp Catcher"),
    PRINCE_ALI_RESCUE("Prince Ali Rescue"),
    DORICS_QUEST("Doric's Quest"),
    BLACK_KNIGHTS_FORTRESS("Black Knights' Fortress"),
    WITCHS_POTION("Witch's Potion"),
    THE_KNIGHTS_SWORD("The Knight's Sword"),
    GOBLIN_DIPLOMACY("Goblin Diplomacy"),
    PIRATES_TREASURE("Pirate's Treasure"),
    DRAGON_SLAYER_I("Dragon Slayer I"),
    RUNE_MYSTERIES("Rune Mysteries"),
    MISTHALIN_MYSTERY("Misthalin Mystery"),
    THE_CORSAIR_CURSE("The Corsair Curse"),
    X_MARKS_THE_SPOT("X Marks the Spot"),
    BELOW_ICE_MOUNTAIN("Below Ice Mountain"),
    DRUIDIC_RITUAL("Druidic Ritual"),
    LOST_CITY("Lost City"),
    WITCHS_HOUSE("Witch's House"),
    MERLINS_CRYSTAL("Merlin's Crystal"),
    HEROES_QUEST("Heroes' Quest"),
    SCORPION_CATCHER("Scorpion Catcher"),
    FAMILY_CREST("Family Crest"),
    TRIBAL_TOTEM("Tribal Totem"),
    FISHING_CONTEST("Fishing Contest"),
    MONKS_FRIEND("Monk's Friend"),
    TEMPLE_OF_IKOV("Temple of Ikov"),
    CLOCK_TOWER("Clock Tower"),
    HOLY_GRAIL("Holy Grail"),
    TREE_GNOME_VILLAGE("Tree Gnome Village"),
    FIGHT_ARENA("Fight Arena"),
    HAZEEL_CULT("Hazeel Cult"),
    SHEEP_HERDER("Sheep Herder"),
    PLAGUE_CITY("Plague City"),
    SEA_SLUG("Sea Slug"),
    WATERFALL_QUEST("Waterfall Quest"),
    BIOHAZARD("Biohazard"),
    JUNGLE_POTION("Jungle Potion"),
    THE_GRAND_TREE("The Grand Tree"),
    SHILO_VILLAGE("Shilo Village"),
    UNDERGROUND_PASS("Underground Pass"),
    OBSERVATORY_QUEST("Observatory Quest"),
    THE_TOURIST_TRAP("The Tourist Trap"),
    WATCHTOWER("Watchtower"),
    DWARF_CANNON("Dwarf Cannon"),
    MURDER_MYSTERY("Murder Mystery"),
    THE_DIG_SITE("The Dig Site"),
    GERTRUDES_CAT("Gertrude's Cat"),
    LEGENDS_QUEST("Legends' Quest"),
    BIG_CHOMPY_BIRD_HUNTING("Big Chompy Bird Hunting"),
    ELEMENTAL_WORKSHOP_I("Elemental Workshop I"),
    PRIEST_IN_PERIL("Priest in Peril"),
    NATURE_SPIRIT("Nature Spirit"),
    DEATH_PLATEAU("Death Plateau"),
    TROLL_STRONGHOLD("Troll Stronghold"),
    TAI_BWO_WANNAI_TRIO("Tai Bwo Wannai Trio"),
    REGICIDE("Regicide"),
    EADGARS_RUSE("Eadgar's Ruse"),
    SHADES_OF_MORTTON("Shades of Mort'ton"),
    THE_FREMENNIK_TRIALS("The Fremennik Trials"),
    HORROR_FROM_THE_DEEP("Horror from the Deep"),
    THRONE_OF_MISCELLANIA("Throne of Miscellania"),
    MONKEY_MADNESS_I("Monkey Madness I"),
    HAUNTED_MINE("Haunted Mine"),
    TROLL_ROMANCE("Troll Romance"),
    IN_SEARCH_OF_THE_MYREQUE("In Search of the Myreque"),
    CREATURE_OF_FENKENSTRAIN("Creature of Fenkenstrain"),
    ROVING_ELVES("Roving Elves"),
    GHOSTS_AHOY("Ghosts Ahoy"),
    ONE_SMALL_FAVOUR("One Small Favour"),
    MOUNTAIN_DAUGHTER("Mountain Daughter"),
    BETWEEN_A_ROCK("Between a Rock..."),
    THE_FEUD("The Feud"),
    THE_GOLEM("The Golem"),
    DESERT_TREASURE("Desert Treasure"),
    ICTHLARINS_LITTLE_HELPER("Icthlarin's Little Helper"),
    TEARS_OF_GUTHIX("Tears of Guthix"),
    ZOGRE_FLESH_EATERS("Zogre Flesh Eaters"),
    THE_LOST_TRIBE("The Lost Tribe"),
    THE_GIANT_DWARF("The Giant Dwarf"),
    RECRUITMENT_DRIVE("Recruitment Drive"),
    MOURNINGS_END_PART_I("Mourning's End Part I"),
    FORGETTABLE_TALE("Forgettable Tale..."),
    GARDEN_OF_TRANQUILLITY("Garden of Tranquillity"),
    A_TAIL_OF_TWO_CATS("A Tail of Two Cats"),
    WANTED("Wanted!"),
    MOURNINGS_END_PART_II("Mourning's End Part II"),
    RUM_DEAL("Rum Deal"),
    SHADOW_OF_THE_STORM("Shadow of the Storm"),
    MAKING_HISTORY("Making History"),
    RATCATCHERS("Ratcatchers"),
    SPIRITS_OF_THE_ELID("Spirits of the Elid"),
    DEVIOUS_MINDS("Devious Minds"),
    THE_HAND_IN_THE_SAND("The Hand in the Sand"),
    ENAKHRAS_LAMENT("Enakhra's Lament"),
    CABIN_FEVER("Cabin Fever"),
    FAIRYTALE_I_GROWING_PAINS("Fairytale I - Growing Pains"),
    RECIPE_FOR_DISASTER("Recipe for Disaster"),
    RECIPE_FOR_DISASTER_ANOTHER_COOKS_QUEST("Recipe for Disaster/Another Cook's Quest"),
    RECIPE_FOR_DISASTER_DEFEATING_THE_CULINAROMANCER("Recipe for Disaster/Defeating the Culinaromancer"),
    RECIPE_FOR_DISASTER_FREEING_THE_MOUNTAIN_DWARF("Recipe for Disaster/Freeing the Mountain Dwarf"),
    RECIPE_FOR_DISASTER_FREEING_THE_GOBLIN_GENERALS("Recipe for Disaster/Freeing the Goblin generals"),
    RECIPE_FOR_DISASTER_FREEING_PIRATE_PETE("Recipe for Disaster/Freeing Pirate Pete"),
    RECIPE_FOR_DISASTER_FREEING_THE_LUMBRIDGE_GUIDE("Recipe for Disaster/Freeing the Lumbridge Guide"),
    RECIPE_FOR_DISASTER_FREEING_EVIL_DAVE("Recipe for Disaster/Freeing Evil Dave"),
    RECIPE_FOR_DISASTER_FREEING_KING_AWOWOGEI("Recipe for Disaster/Freeing King Awowogei"),
    RECIPE_FOR_DISASTER_FREEING_SIR_AMIK_VARZE("Recipe for Disaster/Freeing Sir Amik Varze"),
    RECIPE_FOR_DISASTER_FREEING_SKRACH_UGLOGWEE("Recipe for Disaster/Freeing Skrach Uglogwee"),
    IN_AID_OF_THE_MYREQUE("In Aid of the Myreque"),
    A_SOULS_BANE("A Soul's Bane"),
    RAG_AND_BONE_MAN_I("Rag and Bone Man I"),
    RAG_AND_BONE_MAN_II("Rag and Bone Man II"),
    SWAN_SONG("Swan Song"),
    ROYAL_TROUBLE("Royal Trouble"),
    DEATH_TO_THE_DORGESHUUN("Death to the Dorgeshuun"),
    FAIRYTALE_II__CURE_A_QUEEN("Fairytale II - Cure a Queen"),
    LUNAR_DIPLOMACY("Lunar Diplomacy"),
    THE_EYES_OF_GLOUPHRIE("The Eyes of Glouphrie"),
    DARKNESS_OF_HALLOWVALE("Darkness of Hallowvale"),
    THE_SLUG_MENACE("The Slug Menace"),
    ELEMENTAL_WORKSHOP_II("Elemental Workshop II"),
    MY_ARMS_BIG_ADVENTURE("My Arm's Big Adventure"),
    ENLIGHTENED_JOURNEY("Enlightened Journey"),
    EAGLES_PEAK("Eagles' Peak"),
    ANIMAL_MAGNETISM("Animal Magnetism"),
    CONTACT("Contact!"),
    COLD_WAR("Cold War"),
    THE_FREMENNIK_ISLES("The Fremennik Isles"),
    TOWER_OF_LIFE("Tower of Life"),
    THE_GREAT_BRAIN_ROBBERY("The Great Brain Robbery"),
    WHAT_LIES_BELOW("What Lies Below"),
    OLAFS_QUEST("Olaf's Quest"),
    ANOTHER_SLICE_OF_HAM("Another Slice of H.A.M."),
    DREAM_MENTOR("Dream Mentor"),
    GRIM_TALES("Grim Tales"),
    KINGS_RANSOM("King's Ransom"),
    MONKEY_MADNESS_II("Monkey Madness II"),
    CLIENT_OF_KOUREND("Client of Kourend"),
    BONE_VOYAGE("Bone Voyage"),
    THE_QUEEN_OF_THIEVES("The Queen of Thieves"),
    THE_DEPTHS_OF_DESPAIR("The Depths of Despair"),
    DRAGON_SLAYER_II("Dragon Slayer II"),
    TALE_OF_THE_RIGHTEOUS("Tale of the Righteous"),
    A_TASTE_OF_HOPE("A Taste of Hope"),
    MAKING_FRIENDS_WITH_MY_ARM("Making Friends with My Arm"),
    THE_FORSAKEN_TOWER("The Forsaken Tower"),
    THE_ASCENT_OF_ARCEUUS("The Ascent of Arceuus"),
    SONG_OF_THE_ELVES("Song of the Elves"),
    THE_FREMENNIK_EXILES("The Fremennik Exiles"),
    SINS_OF_THE_FATHER("Sins of the Father"),
    A_PORCINE_OF_INTEREST("A Porcine of Interest"),
    GETTING_AHEAD("Getting Ahead"),
    A_NIGHT_AT_THE_THEATRE("A Night at the Theatre"),
    A_KINGDOM_DIVIDED("A Kingdom Divided");
    private String name;

    Quests(String name) {
        this.name = name;
    }

    public static List<String> getQuests(){
        return Stream.of(Quests.values())
                .map(Quests::getName)
                .collect(Collectors.toList());
    }

}
