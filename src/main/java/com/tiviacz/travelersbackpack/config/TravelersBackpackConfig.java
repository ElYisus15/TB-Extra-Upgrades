package com.tiviacz.travelersbackpack.config;

import com.google.common.collect.Multimap;
import com.tiviacz.travelersbackpack.TravelersBackpack;
import com.tiviacz.travelersbackpack.init.ModItems;
import com.tiviacz.travelersbackpack.inventory.menu.slot.BackpackSlotItemHandler;
import com.tiviacz.travelersbackpack.inventory.menu.slot.ToolSlotItemHandler;
import com.tiviacz.travelersbackpack.util.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class TravelersBackpackConfig {
    public static class Server {
        private static final String REGISTRY_NAME_MATCHER = "([a-z0-9_.-]+:[a-z0-9_/.-]+)";

        public final BackpackSettings backpackSettings;
        public final BackpackUpgrades backpackUpgrades;
        public final World world;
        public final BackpackAbilities backpackAbilities;
        public final SlownessDebuff slownessDebuff;

        Server(final ModConfigSpec.Builder builder) {
            builder.comment("Server config settings")
                    .push("server");

            //Backpack Settings
            backpackSettings = new BackpackSettings(builder, "backpackSettings");

            //Backpack Upgrades
            backpackUpgrades = new BackpackUpgrades(builder, "backpackUpgrades");

            //World
            world = new World(builder, "world");

            //Abilities
            backpackAbilities = new BackpackAbilities(builder, "backpackAbilities");

            //Slowness Debuff
            slownessDebuff = new SlownessDebuff(builder, "slownessDebuff");

            builder.pop();
        }

        public static class BackpackUpgrades {
            public final ModConfigSpec.BooleanValue enableTanksUpgrade;
            public final ModConfigSpec.BooleanValue enableCraftingUpgrade;
            public final ModConfigSpec.BooleanValue enableFurnaceUpgrade;
            public final ModConfigSpec.BooleanValue enableSmokerUpgrade;
            public final ModConfigSpec.BooleanValue enableBlastFurnaceUpgrade;
            public final FilterUpgradeSettings pickupUpgradeSettings;
            public final ModConfigSpec.BooleanValue enableJukeboxUpgrade;
            public final MagnetUpgradeSettings magnetUpgradeSettings;
            public final FeedingUpgradeSettings feedingUpgradeSettings;
            public final FilterUpgradeSettings voidUpgradeSettings;

            public BackpackUpgrades(final ModConfigSpec.Builder builder, final String path) {
                builder.push(path);

                enableTanksUpgrade = builder
                        .define("enableTanksUpgrade", true);

                enableCraftingUpgrade = builder
                        .define("enableCraftingUpgrade", true);

                enableFurnaceUpgrade = builder
                        .define("enableFurnaceUpgrade", true);

                enableSmokerUpgrade = builder
                        .define("enableSmokerUpgrade", true);

                enableBlastFurnaceUpgrade = builder
                        .define("enableBlastFurnaceUpgrade", true);

                pickupUpgradeSettings = new FilterUpgradeSettings(builder, "pickupUpgradeSettings", "PickupUpgrade");

                enableJukeboxUpgrade = builder
                        .define("enableJukeboxUpgrade", true);

                magnetUpgradeSettings = new MagnetUpgradeSettings(builder, "magnetUpgradeSettings");

                feedingUpgradeSettings = new FeedingUpgradeSettings(builder, "feedingUpgradeSettings");

                voidUpgradeSettings = new FilterUpgradeSettings(builder, "voidUpgradeSettings", "VoidUpgrade");

                builder.pop();
            }

            public static class FilterUpgradeSettings {
                public final ModConfigSpec.BooleanValue enableUpgrade;
                public final ModConfigSpec.IntValue filterSlotCount;

                public FilterUpgradeSettings(final ModConfigSpec.Builder builder, final String path, final String upgradeName) {
                    builder.push(path);

                    enableUpgrade = builder
                            .define("enable" + upgradeName, true);

                    filterSlotCount = builder
                            .defineInRange("filterSlotCount", 9, 1, 9);

                    builder.pop();
                }
            }

            public static class FeedingUpgradeSettings {
                public final ModConfigSpec.BooleanValue enableFeedingUpgrade;
                public final ModConfigSpec.IntValue filterSlotCount;
                public final ModConfigSpec.IntValue tickRate;

                public FeedingUpgradeSettings(final ModConfigSpec.Builder builder, final String path) {
                    builder.push(path);

                    enableFeedingUpgrade = builder
                            .define("enableFeedingUpgrade", true);

                    filterSlotCount = builder
                            .defineInRange("filterSlotCount", 9, 1, 9);

                    tickRate = builder
                            .defineInRange("tickRate", 100, 1, 1000);

                    builder.pop();
                }
            }

            public static class MagnetUpgradeSettings {
                public final ModConfigSpec.BooleanValue enableMagnetUpgrade;
                public final ModConfigSpec.IntValue filterSlotCount;
                public final ModConfigSpec.IntValue pullRange;
                public final ModConfigSpec.IntValue tickRate;

                public MagnetUpgradeSettings(final ModConfigSpec.Builder builder, final String path) {
                    builder.push(path);

                    enableMagnetUpgrade = builder
                            .define("enableMagnetUpgrade", true);

                    filterSlotCount = builder
                            .defineInRange("filterSlotCount", 9, 1, 9);

                    pullRange = builder
                            .defineInRange("pullRange", 5, 1, 20);

                    tickRate = builder
                            .defineInRange("tickRate", 10, 1, 1000);

                    builder.pop();
                }
            }
        }

        public static class BackpackSettings {
            public final BackpackSettings.TierConfig leather;
            public final BackpackSettings.TierConfig iron;
            public final BackpackSettings.TierConfig gold;
            public final BackpackSettings.TierConfig diamond;
            public final BackpackSettings.TierConfig netherite;
            public final BackpackSettings.TierConfig allthemodium;
            public final BackpackSettings.TierConfig vibranium;
            public final BackpackSettings.TierConfig unobtainium;
            public final ModConfigSpec.BooleanValue rightClickEquip;
            public final ModConfigSpec.BooleanValue rightClickUnequip;
            public final ModConfigSpec.BooleanValue allowOnlyEquippedBackpack;
            public final ModConfigSpec.BooleanValue allowOpeningFromSlot;
            public final ModConfigSpec.BooleanValue preventMultiplePlayersAccess;
            public final ModConfigSpec.BooleanValue invulnerableBackpack;
            public final ModConfigSpec.BooleanValue toolSlotsAcceptEverything;
            public final ModConfigSpec.ConfigValue<List<? extends String>> toolSlotsAcceptableItems;
            public final ModConfigSpec.ConfigValue<List<? extends String>> blacklistedItems;
            public final ModConfigSpec.BooleanValue allowShulkerBoxes;
            public final ModConfigSpec.BooleanValue voidProtection;
            public final ModConfigSpec.BooleanValue backpackDeathPlace;
            public final ModConfigSpec.BooleanValue backpackForceDeathPlace;
            public final ModConfigSpec.BooleanValue quickSleepingBag;
            public final ModConfigSpec.BooleanValue enableSleepingBagSpawnPoint;
            public final ModConfigSpec.BooleanValue backSlotIntegration;

            BackpackSettings(final ModConfigSpec.Builder builder, final String path) {
                builder.push(path);

                //Backpack Settings
                leather = new BackpackSettings.TierConfig(builder, "Leather", 27, 2, 2, 1000);
                iron = new BackpackSettings.TierConfig(builder, "Iron", 45, 3, 3, 1000);
                gold = new BackpackSettings.TierConfig(builder, "Gold", 63, 4, 4, 1000);
                diamond = new BackpackSettings.TierConfig(builder, "Diamond", 81, 5, 5, 1000);
                netherite = new BackpackSettings.TierConfig(builder, "Netherite", 99, 6, 6, 1000);
                allthemodium = new BackpackSettings.TierConfig(builder, "Allthemodium", 110, 6, 6, 2000);
                vibranium = new BackpackSettings.TierConfig(builder, "Vibranium", 132, 6, 6, 3000);
                unobtainium = new BackpackSettings.TierConfig(builder, "Unobtainium", 154, 7, 7, 5000);

                rightClickEquip = builder
                        .comment("Enables equipping the backpack on right-click from the ground")
                        .define("rightClickEquip", true);

                rightClickUnequip = builder
                        .comment("Enables unequipping the backpack on right-click on the ground with empty hand")
                        .define("rightClickUnequip", false);

                allowOnlyEquippedBackpack = builder
                        .comment("Allows to use only equipped backpack")
                        .define("allowOnlyEquippedBackpack", false);

                allowOpeningFromSlot = builder
                        .comment("Allows opening the backpack by pressing a keybind while hovering over the slot with backpack in the player's inventory")
                        .define("allowOpeningFromSlot", false);

                preventMultiplePlayersAccess = builder
                        .comment("Prevents more than one player from accessing the backpack at the same time when it's placed on the ground")
                        .define("preventMultiplePlayersAccess", false);

                invulnerableBackpack = builder
                        .comment("Backpack immune to any damage source (lava, fire), can't be destroyed, never disappears as floating item")
                        .define("invulnerableBackpack", true);

                toolSlotsAcceptEverything = builder
                        .comment("Tool slots accept any item")
                        .define("toolSlotsAcceptEverything", false);

                toolSlotsAcceptableItems = builder
                        .comment("List of items that can be put in tool slots (Use registry names, for example: \"minecraft:apple\", \"minecraft:flint\")")
                        .defineList("toolSlotsAcceptableItems", Collections.emptyList(), () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                blacklistedItems = builder
                        .comment("List of items that can't be put in backpack inventory (Use registry names, for example: \"minecraft:apple\", \"minecraft:flint\")")
                        .defineList("blacklistedItems", Collections.emptyList(), () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                allowShulkerBoxes = builder
                        .comment("Allows putting shulker boxes and other items with inventory in backpack")
                        .define("allowShulkerBoxes", false);

                voidProtection = builder
                        .comment("Prevents backpack disappearing in void, spawns floating backpack above minimum Y when player dies in void")
                        .define("voidProtection", true);

                backpackDeathPlace = builder
                        .comment("Places backpack at place where player died")
                        .define("backpackDeathPlace", true);

                backpackForceDeathPlace = builder
                        .comment("Places backpack at place where player died, replacing all blocks that are breakable and do not have inventory (backpackDeathPlace must be true in order to work)")
                        .define("backpackForceDeathPlace", false);

                quickSleepingBag = builder
                        .comment("Allows sleeping in a sleeping bag without the need to unequip and place the backpack on the ground")
                        .define("quickSleepingBag", true);

                enableSleepingBagSpawnPoint = builder
                        .define("enableSleepingBagSpawnPoint", false);

                backSlotIntegration = builder
                        .comment("Backpacks can only be equipped in the Curios/Accessories 'Back' slot, provided those mods are installed. If set to false, backpacks can only be equipped by clicking the button in the Backpack GUI. " +
                                "This setting can be changed without unequipping the backpack. An already equipped backpack will not disappear and can be retrieved from the player's inventory.")
                        .define("backSlotIntegration", true);

                builder.pop();
            }

            public static class TierConfig {
                public final ModConfigSpec.IntValue inventorySlotCount;
                public final ModConfigSpec.IntValue upgradeSlotCount;
                public final ModConfigSpec.IntValue toolSlotCount;
                public final ModConfigSpec.IntValue tankCapacityPerRow;

                public TierConfig(ModConfigSpec.Builder builder, String tier, int inventorySlotCountDefault, int upgradeSlotCountDefault, int toolSlotCountDefault, int tankCapacityPerRowDefault) {
                    builder.comment(tier + " Tier Backpack Settings").push(tier.toLowerCase(Locale.ENGLISH) + "TierBackpack");

                    inventorySlotCount =
                            builder.comment("Number of inventory slots for the tier")
                                    .defineInRange("inventorySlotCount", inventorySlotCountDefault, 1, 154);

                    upgradeSlotCount =
                            builder.comment("Number of upgrade slots for the tier")
                                    .defineInRange("upgradeSlotCount", upgradeSlotCountDefault, 0, 10);

                    toolSlotCount =
                            builder.comment("Number of tool slots for the tier")
                                    .defineInRange("toolSlotCount", toolSlotCountDefault, 0, 8);

                    tankCapacityPerRow =
                            builder.comment("Tank capacity per row of backpack storage, 1000 equals 1 Bucket (Leather backpack 3 rows of 9 slots = 3 * 1000")
                                    .defineInRange("tankCapacity", tankCapacityPerRowDefault, 1, 100000);

                    builder.pop();
                }
            }

            public record Tier(int inventorySlotCount, int toolSlotCount, int tankCapacity) {
            }
        }

        public static class World {
            public final ModConfigSpec.BooleanValue spawnEntitiesWithBackpack;
            public final ModConfigSpec.DoubleValue chance;
            public final ModConfigSpec.ConfigValue<List<? extends String>> possibleOverworldEntityTypes;
            public final ModConfigSpec.ConfigValue<List<? extends String>> possibleNetherEntityTypes;
            public final ModConfigSpec.ConfigValue<List<? extends String>> overworldBackpacks;
            public final ModConfigSpec.ConfigValue<List<? extends String>> netherBackpacks;

            World(final ModConfigSpec.Builder builder, final String path) {
                builder.push(path);

                spawnEntitiesWithBackpack = builder
                        .comment("Enables chance to spawn Zombie, Skeleton, Wither Skeleton, Piglin or Enderman with random backpack equipped")
                        .define("spawnEntitiesWithBackpack", true);

                chance = builder
                        .comment("Defines spawn chance of entity with a backpack")
                        .defineInRange("chance", 0.005, 0, 1);

                possibleOverworldEntityTypes = builder
                        .comment("List of overworld entity types that can spawn with equipped backpack. DO NOT ADD anything to this list, because the game will crash, remove entries if mob should not spawn with backpack")
                        .defineList("possibleOverworldEntityTypes", this::getPossibleOverworldEntityTypes, () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                possibleNetherEntityTypes = builder
                        .comment("List of nether entity types that can spawn with equipped backpack. DO NOT ADD anything to this list, because the game will crash, remove entries if mob should not spawn with backpack")
                        .defineList("possibleNetherEntityTypes", this::getPossibleNetherEntityTypes, () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                overworldBackpacks = builder
                        .comment("List of backpacks that can spawn on overworld mobs")
                        .defineList("overworldBackpacks", this::getOverworldBackpacksList, () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                netherBackpacks = builder
                        .comment("List of backpacks that can spawn on nether mobs")
                        .defineList("netherBackpacks", this::getNetherBackpacksList, () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                builder.pop();
            }

            private List<String> getPossibleOverworldEntityTypes() {
                List<String> ret = new ArrayList<>();
                ret.add("minecraft:zombie");
                ret.add("minecraft:skeleton");
                ret.add("minecraft:enderman");
                return ret;
            }

            private List<String> getPossibleNetherEntityTypes() {
                List<String> ret = new ArrayList<>();
                ret.add("minecraft:wither_skeleton");
                ret.add("minecraft:piglin");
                return ret;
            }


            private List<String> getOverworldBackpacksList() {
                List<String> ret = new ArrayList<>();
                ret.add("travelersbackpack:standard");
                ret.add("travelersbackpack:diamond");
                ret.add("travelersbackpack:gold");
                ret.add("travelersbackpack:emerald");
                ret.add("travelersbackpack:iron");
                ret.add("travelersbackpack:lapis");
                ret.add("travelersbackpack:redstone");
                ret.add("travelersbackpack:coal");
                ret.add("travelersbackpack:bookshelf");
                ret.add("travelersbackpack:sandstone");
                ret.add("travelersbackpack:snow");
                ret.add("travelersbackpack:sponge");
                ret.add("travelersbackpack:cake");
                ret.add("travelersbackpack:cactus");
                ret.add("travelersbackpack:hay");
                ret.add("travelersbackpack:melon");
                ret.add("travelersbackpack:pumpkin");
                ret.add("travelersbackpack:creeper");
                ret.add("travelersbackpack:enderman");
                ret.add("travelersbackpack:skeleton");
                ret.add("travelersbackpack:spider");
                ret.add("travelersbackpack:bee");
                ret.add("travelersbackpack:wolf");
                ret.add("travelersbackpack:fox");
                ret.add("travelersbackpack:ocelot");
                ret.add("travelersbackpack:horse");
                ret.add("travelersbackpack:cow");
                ret.add("travelersbackpack:pig");
                ret.add("travelersbackpack:sheep");
                ret.add("travelersbackpack:chicken");
                ret.add("travelersbackpack:squid");
                return ret;
            }

            private List<String> getNetherBackpacksList() {
                List<String> ret = new ArrayList<>();
                ret.add("travelersbackpack:quartz");
                ret.add("travelersbackpack:nether");
                ret.add("travelersbackpack:blaze");
                ret.add("travelersbackpack:ghast");
                ret.add("travelersbackpack:magma_cube");
                ret.add("travelersbackpack:wither");
                return ret;
            }
        }

        public static class BackpackAbilities {
            private static final String REGISTRY_NAME_MATCHER = "([a-z0-9_.-]+:[a-z0-9_/.-]+)";
            private static final String EFFECT_ABILITY_MATCHER = "([a-z0-9_.-]+:[a-z0-9_/.-]+),\\s*([a-z0-9_.-]+:[a-z0-9_/.-]+),\\s*(\\d+),\\s*(\\d+),\\s*(\\d+)";
            private static final String COOLDOWNS_MATCHER = "([a-z0-9_.-]+:[a-z0-9_/.-]+),\\s*(\\d+),\\s*(\\d+)";

            public final ModConfigSpec.BooleanValue enableBackpackAbilities;
            public final ModConfigSpec.BooleanValue forceAbilityEnabled;
            public final ModConfigSpec.ConfigValue<List<? extends String>> allowedAbilities;
            public final ModConfigSpec.ConfigValue<List<? extends String>> backpackEffects;
            public final ModConfigSpec.ConfigValue<List<? extends String>> cooldowns;

            BackpackAbilities(final ModConfigSpec.Builder builder, final String path) {
                builder.push(path);

                enableBackpackAbilities = builder
                        .define("enableBackpackAbilities", true);

                forceAbilityEnabled = builder
                        .comment("Newly crafted backpacks will have ability enabled by default")
                        .define("forceAbilityEnabled", true);

                allowedAbilities = builder
                        .comment("List of backpacks that are allowed to have an ability. DO NOT ADD anything to this list, because the game will crash, remove entries if backpack should not have ability")
                        .defineList("allowedAbilities", this::getAllowedAbilities, () -> "", mapping -> ((String)mapping).matches(REGISTRY_NAME_MATCHER));

                backpackEffects = builder
                        .comment("List of effect abilities associated with backpacks, you can modify this list as you wish. Different effects can be added to different backpacks. \n Formatting: \"<backpack_registry_name>, <status_effect_registry_name>, <min_duration_ticks>, <max_duration_ticks>, <amplifier>\"")
                        .defineList("backpackEffects", this::getBackpackEffects, () -> "", mapping -> ((String)mapping).matches(EFFECT_ABILITY_MATCHER));

                cooldowns = builder
                        .comment("List of cooldowns that are being applied after ability usage, the backpacks on the list are all that currently have cooldowns, adding additional backpack will not give it cooldown. \n Formatting: \"<backpack_registry_name>, <min_possible_cooldown_seconds>, <max_possible_cooldown_seconds>\"")
                        .defineList("cooldowns", this::getCooldowns, () -> "", mapping -> ((String)mapping).matches(COOLDOWNS_MATCHER));

                builder.pop();
            }

            private List<String> getAllowedAbilities() {
                List<String> ret = new ArrayList<>();
                ret.add("travelersbackpack:netherite");
                ret.add("travelersbackpack:diamond");
                ret.add("travelersbackpack:gold");
                ret.add("travelersbackpack:emerald");
                ret.add("travelersbackpack:iron");
                ret.add("travelersbackpack:lapis");
                ret.add("travelersbackpack:redstone");
                ret.add("travelersbackpack:bookshelf");
                ret.add("travelersbackpack:sponge");
                ret.add("travelersbackpack:cake");
                ret.add("travelersbackpack:cactus");
                ret.add("travelersbackpack:melon");
                ret.add("travelersbackpack:pumpkin");
                ret.add("travelersbackpack:creeper");
                ret.add("travelersbackpack:dragon");
                ret.add("travelersbackpack:enderman");
                ret.add("travelersbackpack:blaze");
                ret.add("travelersbackpack:ghast");
                ret.add("travelersbackpack:magma_cube");
                ret.add("travelersbackpack:spider");
                ret.add("travelersbackpack:wither");
                ret.add("travelersbackpack:warden");
                ret.add("travelersbackpack:bat");
                ret.add("travelersbackpack:bee");
                ret.add("travelersbackpack:ocelot");
                ret.add("travelersbackpack:cow");
                ret.add("travelersbackpack:chicken");
                ret.add("travelersbackpack:squid");
                ret.add("travelersbackpack:hay");
                ret.add("travelersbackpack:fox");
                return ret;
            }

            private List<String> getCooldowns() {
                List<String> ret = new ArrayList<>();
                ret.add("travelersbackpack:creeper, 1200, 1800");
                ret.add("travelersbackpack:cow, 480, 540");
                ret.add("travelersbackpack:chicken, 360, 600");
                ret.add("travelersbackpack:cake, 360, 480");
                ret.add("travelersbackpack:melon, 120, 480");
                return ret;
            }

            private List<String> getBackpackEffects() {
                List<String> ret = new ArrayList<>();
                ret.add("travelersbackpack:bat, minecraft:night_vision, 260, 300, 0");
                ret.add("travelersbackpack:magma_cube, minecraft:fire_resistance, 260, 300, 0");
                ret.add("travelersbackpack:squid, minecraft:water_breathing, 260, 300, 0");
                ret.add("travelersbackpack:dragon, minecraft:regeneration, 260, 300, 0");
                ret.add("travelersbackpack:dragon, minecraft:strength, 250, 290, 0");
                ret.add("travelersbackpack:quartz, minecraft:haste, 260, 300, 0");
                ret.add("travelersbackpack:fox, minecraft:jump_boost, 260, 300, 0");
                return ret;
            }
        }

        public static class SlownessDebuff {
            public final ModConfigSpec.BooleanValue tooManyBackpacksSlowness;
            public final ModConfigSpec.IntValue maxNumberOfBackpacks;
            public final ModConfigSpec.DoubleValue slownessPerExcessedBackpack;

            SlownessDebuff(final ModConfigSpec.Builder builder, final String path) {
                builder.push(path);

                tooManyBackpacksSlowness = builder
                        .comment("Player gets slowness effect, if carries too many backpacks in inventory")
                        .define("tooManyBackpacksSlowness", false);

                maxNumberOfBackpacks = builder
                        .comment("Maximum number of backpacks, which can be carried in inventory, without slowness effect")
                        .defineInRange("maxNumberOfBackpacks", 3, 1, 37);

                slownessPerExcessedBackpack = builder
                        .defineInRange("slownessPerExcessedBackpack", 1, 0.1, 5);

                builder.pop();
            }
        }

        public void loadItemsFromConfig(List<? extends String> configList, List<Item> targetList) {
            for(String registryName : configList) {
                ResourceLocation res = ResourceLocation.tryParse(registryName);

                if(BuiltInRegistries.ITEM.containsKey(res)) {
                    targetList.add(BuiltInRegistries.ITEM.get(res));
                }
            }
        }

        public void loadEntityTypesFromConfig(List<? extends String> configList, List<EntityType> targetList) {
            for(String registryName : configList) {
                ResourceLocation res = ResourceLocation.tryParse(registryName);

                if(BuiltInRegistries.ENTITY_TYPE.containsKey(res)) {
                    targetList.add(BuiltInRegistries.ENTITY_TYPE.get(res));
                }
            }
        }

        public void loadBackpackEffectsFromConfig(List<? extends String> configList, Multimap<Item, BackpackEffect> backpackEffects) {
            try {
                for(String entry : configList) {
                    String[] parts = entry.replace(" ", "").split(",");
                    if(parts.length == 5) {
                        ResourceLocation backpackRes = ResourceLocation.tryParse(parts[0]);
                        ResourceLocation effectRes = ResourceLocation.tryParse(parts[1]);

                        if(BuiltInRegistries.ITEM.containsKey(backpackRes) && BuiltInRegistries.MOB_EFFECT.getHolder(effectRes).isPresent()) {
                            Item backpack = BuiltInRegistries.ITEM.get(backpackRes);
                            int minDuration = Integer.parseInt(parts[2]);
                            int maxDuration = Integer.parseInt(parts[3]);
                            int amplifier = Integer.parseInt(parts[4]);

                            if(minDuration < 0 || maxDuration < 0 || amplifier < 0) {
                                TravelersBackpack.LOGGER.error("Backpack Effects: duration and amplifier must be positive integers!");
                            }

                            if(minDuration > maxDuration) {
                                TravelersBackpack.LOGGER.error("Backpack Effects: minDuration must be less than or equal to maxDuration!");
                            }

                            backpackEffects.put(backpack, new BackpackEffect(BuiltInRegistries.MOB_EFFECT.getHolder(effectRes).get(), minDuration, maxDuration, amplifier));
                        }
                    }
                }
            } catch(Exception e) {
                TravelersBackpack.LOGGER.error("Could not load Backpack Effect from Config! Check your config if entries are correct!");
            }
        }

        public void loadCooldownsFromConfig(List<? extends String> config, Map<Item, Cooldown> cooldownConfigs) {
            try {
                for(String entry : config) {
                    String[] parts = entry.replace(" ", "").split(",");
                    if(parts.length == 3) {
                        ResourceLocation backpackRes = ResourceLocation.tryParse(parts[0]);
                        Item backpack = BuiltInRegistries.ITEM.get(backpackRes);
                        int minCooldown = Integer.parseInt(parts[1]);
                        int maxCooldown = Integer.parseInt(parts[2]);

                        if(minCooldown < 0 || maxCooldown < 0) {
                            TravelersBackpack.LOGGER.error("Cooldowns: cooldowns must be positive integers!");
                        }

                        if(minCooldown > maxCooldown) {
                            TravelersBackpack.LOGGER.error("Cooldowns: minCooldown must be less than or equal to maxCooldown!");
                        }

                        cooldownConfigs.put(backpack, new Cooldown(minCooldown, maxCooldown));
                    }
                }
            } catch(Exception e) {
                TravelersBackpack.LOGGER.error("Could not load Cooldowns from Config! Check your config if entries are correct!");
            }
        }

        private boolean initialized = false;

        public void initializeLists() {
            if(!serverSpec.isLoaded()) {
                return;
            }

            if(!initialized) {
                //Container
                loadItemsFromConfig(TravelersBackpackConfig.SERVER.backpackSettings.toolSlotsAcceptableItems.get(), ToolSlotItemHandler.TOOL_SLOTS_ACCEPTABLE_ITEMS);
                loadItemsFromConfig(TravelersBackpackConfig.SERVER.backpackSettings.blacklistedItems.get(), BackpackSlotItemHandler.BLACKLISTED_ITEMS);

                //Spawns
                loadItemsFromConfig(TravelersBackpackConfig.SERVER.world.overworldBackpacks.get(), ModItems.COMPATIBLE_OVERWORLD_BACKPACK_ENTRIES);
                loadItemsFromConfig(TravelersBackpackConfig.SERVER.world.netherBackpacks.get(), ModItems.COMPATIBLE_NETHER_BACKPACK_ENTRIES);

                //Abilities
                loadItemsFromConfig(TravelersBackpackConfig.SERVER.backpackAbilities.allowedAbilities.get(), com.tiviacz.travelersbackpack.common.BackpackAbilities.ALLOWED_ABILITIES);

                //Entities
                loadEntityTypesFromConfig(TravelersBackpackConfig.SERVER.world.possibleOverworldEntityTypes.get(), Reference.ALLOWED_TYPE_ENTRIES);
                loadEntityTypesFromConfig(TravelersBackpackConfig.SERVER.world.possibleNetherEntityTypes.get(), Reference.ALLOWED_TYPE_ENTRIES);

                //Backpack Effects
                loadBackpackEffectsFromConfig(TravelersBackpackConfig.SERVER.backpackAbilities.backpackEffects.get(), com.tiviacz.travelersbackpack.common.BackpackAbilities.BACKPACK_EFFECTS);

                //Update allowed abilities if added effect
                com.tiviacz.travelersbackpack.common.BackpackAbilities.getBackpackEffects().entries().stream().forEach(entry -> {
                    if(!com.tiviacz.travelersbackpack.common.BackpackAbilities.ALLOWED_ABILITIES.contains(entry.getKey())) {
                        com.tiviacz.travelersbackpack.common.BackpackAbilities.ALLOWED_ABILITIES.add(entry.getKey());
                    }
                    if(!com.tiviacz.travelersbackpack.common.BackpackAbilities.ITEM_ABILITIES_LIST.contains(entry.getKey())) {
                        com.tiviacz.travelersbackpack.common.BackpackAbilities.ITEM_ABILITIES_LIST.add(entry.getKey());
                    }
                });

                //Cooldowns
                loadCooldownsFromConfig(TravelersBackpackConfig.SERVER.backpackAbilities.cooldowns.get(), com.tiviacz.travelersbackpack.common.BackpackAbilities.COOLDOWNS);
            }

            initialized = true;
        }
    }

    public static class Common {
        public final ModConfigSpec.BooleanValue enableLoot;
        public final ModConfigSpec.BooleanValue enableVillagerTrade;

        Common(final ModConfigSpec.Builder builder) {
            builder.comment("Common config settings")
                    .push("common");

            enableLoot = builder
                    .comment("Enables backpacks spawning in loot chests")
                    .define("enableLoot", true);

            enableVillagerTrade = builder
                    .comment("Enables trade for Villager Backpack in Librarian villager trades")
                    .define("enableVillagerTrade", true);

            builder.pop();
        }
    }

    public static class Client {
        public final ModConfigSpec.BooleanValue showBackpackIconInInventory;
        public final ModConfigSpec.BooleanValue sendBackpackCoordinatesMessage;
        public final ModConfigSpec.BooleanValue enableToolCycling;
        public final ModConfigSpec.BooleanValue disableScrollWheel;
        public final ModConfigSpec.BooleanValue obtainTips;
        public final ModConfigSpec.BooleanValue renderTools;
        public final ModConfigSpec.BooleanValue showSupporterBadge;
        public final Overlay overlay;

        Client(final ModConfigSpec.Builder builder) {
            builder.comment("Client-only settings")
                    .push("client");

            showBackpackIconInInventory = builder
                    .comment("Whether the backpack icon should be visible in player's inventory")
                    .define("showBackpackIconInInventory", true);

            sendBackpackCoordinatesMessage = builder
                    .comment("Sends a message to the player on death with backpack coordinates")
                    .define("sendBackpackCoordinatesMessage", true);

            enableToolCycling = builder
                    .comment("Enables tool cycling via keybind (Default Z) + scroll combination, while backpack is worn")
                    .define("enableToolCycling", true);

            disableScrollWheel = builder
                    .comment("Allows tool cycling using keybinding only (Default Z)")
                    .define("disableScrollWheel", false);

            obtainTips = builder
                    .comment("Enables tip, how to obtain a backpack, if there's no crafting recipe for it")
                    .define("obtainTips", true);

            renderTools = builder
                    .comment("Render tools in tool slots on the backpack, while worn")
                    .define("renderTools", true);

            showSupporterBadge = builder
                    .comment("Only for supporters, option to show/hide the Supporter Star Badge. If you want to receive the Supporter Star Badge, visit my Ko-fi page :)! - https://ko-fi.com/tiviacz1337")
                    .define("showSupporterBadge", true);

            overlay = new Overlay(
                    builder,
                    "The position of the Overlay on the screen",
                    "overlay",
                    true, 20, 30
            );

            builder.pop();
        }

        public static class Overlay {
            public final ModConfigSpec.BooleanValue enableOverlay;
            public final ModConfigSpec.IntValue offsetX;
            public final ModConfigSpec.IntValue offsetY;

            Overlay(final ModConfigSpec.Builder builder, final String comment, final String path, final boolean defaultOverlay, final int defaultX, final int defaultY) {
                builder.comment(comment)
                        .push(path);

                enableOverlay = builder
                        .comment("Enables tanks and tool slots overlay, while backpack is worn")
                        .define("enableOverlay", defaultOverlay);

                offsetX = builder
                        .comment("Offsets to left side")
                        .defineInRange("offsetX", defaultX, Integer.MIN_VALUE, Integer.MAX_VALUE);

                offsetY = builder
                        .comment("Offsets to up")
                        .defineInRange("offsetY", defaultY, Integer.MIN_VALUE, Integer.MAX_VALUE);

                builder.pop();
            }
        }
    }

    //Server
    public static final ModConfigSpec serverSpec;
    public static final Server SERVER;

    static {
        final Pair<Server, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Server::new);
        serverSpec = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    //Common
    public static final ModConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    //Client
    public static final ModConfigSpec clientSpec;
    public static final Client CLIENT;

    static {
        final Pair<Client, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }
}