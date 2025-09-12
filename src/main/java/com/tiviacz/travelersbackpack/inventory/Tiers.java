package com.tiviacz.travelersbackpack.inventory;

import com.tiviacz.travelersbackpack.config.TravelersBackpackConfig;
import com.tiviacz.travelersbackpack.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class Tiers {
    public static final Tier LEATHER = new Tier("leather", (9 * 3), 2, 2, 1000);
    public static final Tier IRON = new Tier("iron", (9 * 5), 3, 3, 1000);
    public static final Tier GOLD = new Tier("gold", (9 * 7), 4, 4, 1000);
    public static final Tier DIAMOND = new Tier("diamond", (9 * 9), 5, 5, 1000);
    public static final Tier NETHERITE = new Tier("netherite", (9 * 11), 6, 6, 1000);
    public static final Tier ALLTHEMODIUM = new Tier("allthemodium", (9 * 13), 6, 6, 2000);
    public static final Tier VIBRANIUM = new Tier("vibranium", (9 * 15), 6, 6, 3000);
    public static final Tier UNOBTAINIUM = new Tier("unobtainium", (9 * 17), 7, 7, 5000);

    public static class Tier {
        public final String name;
        public int toolSlots;
        public final int storageSlots;
        public final int upgradeSlots;
        public final int tankCapacityPerRow;

        public Tier(String name, int storageSlots, int upgradeSlots, int toolSlots, int tankCapacityPerRow) {
            this.name = name;
            this.storageSlots = storageSlots;
            this.upgradeSlots = upgradeSlots;
            this.toolSlots = toolSlots;
            this.tankCapacityPerRow = tankCapacityPerRow;
        }

        public String getName() {
            return this.name;
        }

        public int getStorageSlots() {
            if(this == LEATHER) return TravelersBackpackConfig.SERVER.backpackSettings.leather.inventorySlotCount.get();
            if(this == IRON) return TravelersBackpackConfig.SERVER.backpackSettings.iron.inventorySlotCount.get();
            if(this == GOLD) return TravelersBackpackConfig.SERVER.backpackSettings.gold.inventorySlotCount.get();
            if(this == DIAMOND) return TravelersBackpackConfig.SERVER.backpackSettings.diamond.inventorySlotCount.get();
            if(this == NETHERITE) return TravelersBackpackConfig.SERVER.backpackSettings.netherite.inventorySlotCount.get();
            if(this == ALLTHEMODIUM) return TravelersBackpackConfig.SERVER.backpackSettings.allthemodium.inventorySlotCount.get();
            if(this == VIBRANIUM) return TravelersBackpackConfig.SERVER.backpackSettings.vibranium.inventorySlotCount.get();
            if(this == UNOBTAINIUM) return TravelersBackpackConfig.SERVER.backpackSettings.unobtainium.inventorySlotCount.get();
            return this.storageSlots;
        }

        public int getUpgradeSlots() {
            if(this == LEATHER) return TravelersBackpackConfig.SERVER.backpackSettings.leather.upgradeSlotCount.get();
            if(this == IRON) return TravelersBackpackConfig.SERVER.backpackSettings.iron.upgradeSlotCount.get();
            if(this == GOLD) return TravelersBackpackConfig.SERVER.backpackSettings.gold.upgradeSlotCount.get();
            if(this == DIAMOND) return TravelersBackpackConfig.SERVER.backpackSettings.diamond.upgradeSlotCount.get();
            if(this == NETHERITE) return TravelersBackpackConfig.SERVER.backpackSettings.netherite.upgradeSlotCount.get();
            if(this == ALLTHEMODIUM) return TravelersBackpackConfig.SERVER.backpackSettings.allthemodium.upgradeSlotCount.get();
            if(this == VIBRANIUM) return TravelersBackpackConfig.SERVER.backpackSettings.vibranium.upgradeSlotCount.get();
            if(this == UNOBTAINIUM) return TravelersBackpackConfig.SERVER.backpackSettings.unobtainium.upgradeSlotCount.get();
            return this.upgradeSlots;
        }

        public int getToolSlots() {
            if(this == LEATHER) return TravelersBackpackConfig.SERVER.backpackSettings.leather.toolSlotCount.get();
            if(this == IRON) return TravelersBackpackConfig.SERVER.backpackSettings.iron.toolSlotCount.get();
            if(this == GOLD) return TravelersBackpackConfig.SERVER.backpackSettings.gold.toolSlotCount.get();
            if(this == DIAMOND) return TravelersBackpackConfig.SERVER.backpackSettings.diamond.toolSlotCount.get();
            if(this == NETHERITE) return TravelersBackpackConfig.SERVER.backpackSettings.netherite.toolSlotCount.get();
            if(this == ALLTHEMODIUM) return TravelersBackpackConfig.SERVER.backpackSettings.allthemodium.toolSlotCount.get();
            if(this == VIBRANIUM) return TravelersBackpackConfig.SERVER.backpackSettings.vibranium.toolSlotCount.get();
            if(this == UNOBTAINIUM) return TravelersBackpackConfig.SERVER.backpackSettings.unobtainium.toolSlotCount.get();
            return this.toolSlots;
        }

        public int getTankCapacityPerRow() {
            if(this == LEATHER) return TravelersBackpackConfig.SERVER.backpackSettings.leather.tankCapacityPerRow.get();
            if(this == IRON) return TravelersBackpackConfig.SERVER.backpackSettings.iron.tankCapacityPerRow.get();
            if(this == GOLD) return TravelersBackpackConfig.SERVER.backpackSettings.gold.tankCapacityPerRow.get();
            if(this == DIAMOND) return TravelersBackpackConfig.SERVER.backpackSettings.diamond.tankCapacityPerRow.get();
            if(this == NETHERITE) return TravelersBackpackConfig.SERVER.backpackSettings.netherite.tankCapacityPerRow.get();
            if(this == ALLTHEMODIUM) return TravelersBackpackConfig.SERVER.backpackSettings.allthemodium.tankCapacityPerRow.get();
            if(this == VIBRANIUM) return TravelersBackpackConfig.SERVER.backpackSettings.vibranium.tankCapacityPerRow.get();
            if(this == UNOBTAINIUM) return TravelersBackpackConfig.SERVER.backpackSettings.unobtainium.tankCapacityPerRow.get();
            return this.tankCapacityPerRow;
        }

        public Tier getNextTier() {
            if(this == LEATHER) return IRON;
            if(this == IRON) return GOLD;
            if(this == GOLD) return DIAMOND;
            if(this == DIAMOND) return NETHERITE;
            if(this == NETHERITE) return ALLTHEMODIUM;
            if(this == ALLTHEMODIUM) return VIBRANIUM;
            if(this == VIBRANIUM) return UNOBTAINIUM;
            return LEATHER;
        }

        public int getOrdinal() {
            if(this == LEATHER) return 0;
            if(this == IRON) return 1;
            if(this == GOLD) return 2;
            if(this == DIAMOND) return 3;
            if(this == NETHERITE) return 4;
            if(this == ALLTHEMODIUM) return 5;
            if(this == VIBRANIUM) return 6;
            if(this == UNOBTAINIUM) return 7;
            return -1;
        }

        public Item getTierUpgradeIngredient() {
            if(this == LEATHER) return ModItems.IRON_TIER_UPGRADE.get();
            if(this == IRON) return ModItems.GOLD_TIER_UPGRADE.get();
            if(this == GOLD) return ModItems.DIAMOND_TIER_UPGRADE.get();
            if(this == DIAMOND) return ModItems.NETHERITE_TIER_UPGRADE.get();
            if(this == NETHERITE) return ModItems.ALLTHEMODIUM_TIER_UPGRADE.get();
            if(this == ALLTHEMODIUM) return ModItems.VIBRANIUM_TIER_UPGRADE.get();
            if(this == VIBRANIUM) return ModItems.UNOBTAINIUM_TIER_UPGRADE.get();
            return Items.AIR;
        }
    }

    public static Tier of(String name) {
        return switch(name) {
            case "leather" -> Tiers.LEATHER;
            case "iron" -> Tiers.IRON;
            case "gold" -> Tiers.GOLD;
            case "diamond" -> Tiers.DIAMOND;
            case "netherite" -> Tiers.NETHERITE;
            case "allthemodium" -> Tiers.ALLTHEMODIUM;
            case "vibranium" -> Tiers.VIBRANIUM;
            case "unobtainium" -> Tiers.UNOBTAINIUM;
            default -> Tiers.LEATHER;
        };
    }

    public static Tier of(int ordinal) {
        return switch(ordinal) {
            case 0 -> Tiers.LEATHER;
            case 1 -> Tiers.IRON;
            case 2 -> Tiers.GOLD;
            case 3 -> Tiers.DIAMOND;
            case 4 -> Tiers.NETHERITE;
            case 5 -> Tiers.ALLTHEMODIUM;
            case 6 -> Tiers.VIBRANIUM;
            case 7 -> Tiers.UNOBTAINIUM;
            default -> Tiers.LEATHER;
        };
    }
}