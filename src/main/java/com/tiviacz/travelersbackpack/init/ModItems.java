package com.tiviacz.travelersbackpack.init;

import com.tiviacz.travelersbackpack.TravelersBackpack;
import com.tiviacz.travelersbackpack.entity.BackpackItemEntity;
import com.tiviacz.travelersbackpack.items.BackpackTankItem;
import com.tiviacz.travelersbackpack.items.HoseItem;
import com.tiviacz.travelersbackpack.items.SleepingBagItem;
import com.tiviacz.travelersbackpack.items.TravelersBackpackItem;
import com.tiviacz.travelersbackpack.items.upgrades.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TravelersBackpack.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, TravelersBackpack.MODID);

    //Standard
    public static final DeferredItem<TravelersBackpackItem> STANDARD_TRAVELERS_BACKPACK = ITEMS.register("standard", () -> new TravelersBackpackItem(ModBlocks.STANDARD_TRAVELERS_BACKPACK.get(), "standard"));

    //Blocks
    public static final DeferredItem<TravelersBackpackItem> NETHERITE_TRAVELERS_BACKPACK = ITEMS.register("netherite", () -> new TravelersBackpackItem(ModBlocks.NETHERITE_TRAVELERS_BACKPACK.get(), "netherite"));
    public static final DeferredItem<TravelersBackpackItem> DIAMOND_TRAVELERS_BACKPACK = ITEMS.register("diamond", () -> new TravelersBackpackItem(ModBlocks.DIAMOND_TRAVELERS_BACKPACK.get(), "diamond"));
    public static final DeferredItem<TravelersBackpackItem> GOLD_TRAVELERS_BACKPACK = ITEMS.register("gold", () -> new TravelersBackpackItem(ModBlocks.GOLD_TRAVELERS_BACKPACK.get(), "gold"));
    public static final DeferredItem<TravelersBackpackItem> EMERALD_TRAVELERS_BACKPACK = ITEMS.register("emerald", () -> new TravelersBackpackItem(ModBlocks.EMERALD_TRAVELERS_BACKPACK.get(), "emerald"));
    public static final DeferredItem<TravelersBackpackItem> IRON_TRAVELERS_BACKPACK = ITEMS.register("iron", () -> new TravelersBackpackItem(ModBlocks.IRON_TRAVELERS_BACKPACK.get(), "iron"));
    public static final DeferredItem<TravelersBackpackItem> LAPIS_TRAVELERS_BACKPACK = ITEMS.register("lapis", () -> new TravelersBackpackItem(ModBlocks.LAPIS_TRAVELERS_BACKPACK.get(), "lapis"));
    public static final DeferredItem<TravelersBackpackItem> REDSTONE_TRAVELERS_BACKPACK = ITEMS.register("redstone", () -> new TravelersBackpackItem(ModBlocks.REDSTONE_TRAVELERS_BACKPACK.get(), "redstone"));
    public static final DeferredItem<TravelersBackpackItem> COAL_TRAVELERS_BACKPACK = ITEMS.register("coal", () -> new TravelersBackpackItem(ModBlocks.COAL_TRAVELERS_BACKPACK.get(), "coal"));

    public static final DeferredItem<TravelersBackpackItem> QUARTZ_TRAVELERS_BACKPACK = ITEMS.register("quartz", () -> new TravelersBackpackItem(ModBlocks.QUARTZ_TRAVELERS_BACKPACK.get(), "quartz"));
    public static final DeferredItem<TravelersBackpackItem> BOOKSHELF_TRAVELERS_BACKPACK = ITEMS.register("bookshelf", () -> new TravelersBackpackItem(ModBlocks.BOOKSHELF_TRAVELERS_BACKPACK.get(), "bookshelf"));
    public static final DeferredItem<TravelersBackpackItem> END_TRAVELERS_BACKPACK = ITEMS.register("end", () -> new TravelersBackpackItem(ModBlocks.END_TRAVELERS_BACKPACK.get(), "end"));
    public static final DeferredItem<TravelersBackpackItem> NETHER_TRAVELERS_BACKPACK = ITEMS.register("nether", () -> new TravelersBackpackItem(ModBlocks.NETHER_TRAVELERS_BACKPACK.get(), "nether"));
    public static final DeferredItem<TravelersBackpackItem> SANDSTONE_TRAVELERS_BACKPACK = ITEMS.register("sandstone", () -> new TravelersBackpackItem(ModBlocks.SANDSTONE_TRAVELERS_BACKPACK.get(), "sandstone"));
    public static final DeferredItem<TravelersBackpackItem> SNOW_TRAVELERS_BACKPACK = ITEMS.register("snow", () -> new TravelersBackpackItem(ModBlocks.SNOW_TRAVELERS_BACKPACK.get(), "snow"));
    public static final DeferredItem<TravelersBackpackItem> SPONGE_TRAVELERS_BACKPACK = ITEMS.register("sponge", () -> new TravelersBackpackItem(ModBlocks.SPONGE_TRAVELERS_BACKPACK.get(), "sponge"));

    //Food
    public static final DeferredItem<TravelersBackpackItem> CAKE_TRAVELERS_BACKPACK = ITEMS.register("cake", () -> new TravelersBackpackItem(ModBlocks.CAKE_TRAVELERS_BACKPACK.get(), "cake"));

    //Plants
    public static final DeferredItem<TravelersBackpackItem> CACTUS_TRAVELERS_BACKPACK = ITEMS.register("cactus", () -> new TravelersBackpackItem(ModBlocks.CACTUS_TRAVELERS_BACKPACK.get(), "cactus"));
    public static final DeferredItem<TravelersBackpackItem> HAY_TRAVELERS_BACKPACK = ITEMS.register("hay", () -> new TravelersBackpackItem(ModBlocks.HAY_TRAVELERS_BACKPACK.get(), "hay"));
    public static final DeferredItem<TravelersBackpackItem> MELON_TRAVELERS_BACKPACK = ITEMS.register("melon", () -> new TravelersBackpackItem(ModBlocks.MELON_TRAVELERS_BACKPACK.get(), "melon"));
    public static final DeferredItem<TravelersBackpackItem> PUMPKIN_TRAVELERS_BACKPACK = ITEMS.register("pumpkin", () -> new TravelersBackpackItem(ModBlocks.PUMPKIN_TRAVELERS_BACKPACK.get(), "pumpkin"));

    //Mobs
    public static final DeferredItem<TravelersBackpackItem> CREEPER_TRAVELERS_BACKPACK = ITEMS.register("creeper", () -> new TravelersBackpackItem(ModBlocks.CREEPER_TRAVELERS_BACKPACK.get(), "creeper"));
    public static final DeferredItem<TravelersBackpackItem> DRAGON_TRAVELERS_BACKPACK = ITEMS.register("dragon", () -> new TravelersBackpackItem(ModBlocks.DRAGON_TRAVELERS_BACKPACK.get(), "dragon"));
    public static final DeferredItem<TravelersBackpackItem> ENDERMAN_TRAVELERS_BACKPACK = ITEMS.register("enderman", () -> new TravelersBackpackItem(ModBlocks.ENDERMAN_TRAVELERS_BACKPACK.get(), "enderman"));
    public static final DeferredItem<TravelersBackpackItem> BLAZE_TRAVELERS_BACKPACK = ITEMS.register("blaze", () -> new TravelersBackpackItem(ModBlocks.BLAZE_TRAVELERS_BACKPACK.get(), "blaze"));
    public static final DeferredItem<TravelersBackpackItem> GHAST_TRAVELERS_BACKPACK = ITEMS.register("ghast", () -> new TravelersBackpackItem(ModBlocks.GHAST_TRAVELERS_BACKPACK.get(), "ghast"));
    public static final DeferredItem<TravelersBackpackItem> MAGMA_CUBE_TRAVELERS_BACKPACK = ITEMS.register("magma_cube", () -> new TravelersBackpackItem(ModBlocks.MAGMA_CUBE_TRAVELERS_BACKPACK.get(), "magma_cube"));
    public static final DeferredItem<TravelersBackpackItem> SKELETON_TRAVELERS_BACKPACK = ITEMS.register("skeleton", () -> new TravelersBackpackItem(ModBlocks.SKELETON_TRAVELERS_BACKPACK.get(), "skeleton"));
    public static final DeferredItem<TravelersBackpackItem> SPIDER_TRAVELERS_BACKPACK = ITEMS.register("spider", () -> new TravelersBackpackItem(ModBlocks.SPIDER_TRAVELERS_BACKPACK.get(), "spider"));
    public static final DeferredItem<TravelersBackpackItem> WITHER_TRAVELERS_BACKPACK = ITEMS.register("wither", () -> new TravelersBackpackItem(ModBlocks.WITHER_TRAVELERS_BACKPACK.get(), "wither"));
    public static final DeferredItem<TravelersBackpackItem> WARDEN_TRAVELERS_BACKPACK = ITEMS.register("warden", () -> new TravelersBackpackItem(ModBlocks.WARDEN_TRAVELERS_BACKPACK.get(), "warden"));

    //Friendly Mobs
    public static final DeferredItem<TravelersBackpackItem> BAT_TRAVELERS_BACKPACK = ITEMS.register("bat", () -> new TravelersBackpackItem(ModBlocks.BAT_TRAVELERS_BACKPACK.get(), "bat"));
    public static final DeferredItem<TravelersBackpackItem> BEE_TRAVELERS_BACKPACK = ITEMS.register("bee", () -> new TravelersBackpackItem(ModBlocks.BEE_TRAVELERS_BACKPACK.get(), "bee"));
    public static final DeferredItem<TravelersBackpackItem> WOLF_TRAVELERS_BACKPACK = ITEMS.register("wolf", () -> new TravelersBackpackItem(ModBlocks.WOLF_TRAVELERS_BACKPACK.get(), "wolf"));
    public static final DeferredItem<TravelersBackpackItem> FOX_TRAVELERS_BACKPACK = ITEMS.register("fox", () -> new TravelersBackpackItem(ModBlocks.FOX_TRAVELERS_BACKPACK.get(), "fox"));
    public static final DeferredItem<TravelersBackpackItem> OCELOT_TRAVELERS_BACKPACK = ITEMS.register("ocelot", () -> new TravelersBackpackItem(ModBlocks.OCELOT_TRAVELERS_BACKPACK.get(), "ocelot"));
    public static final DeferredItem<TravelersBackpackItem> HORSE_TRAVELERS_BACKPACK = ITEMS.register("horse", () -> new TravelersBackpackItem(ModBlocks.HORSE_TRAVELERS_BACKPACK.get(), "horse"));
    public static final DeferredItem<TravelersBackpackItem> COW_TRAVELERS_BACKPACK = ITEMS.register("cow", () -> new TravelersBackpackItem(ModBlocks.COW_TRAVELERS_BACKPACK.get(), "cow"));
    public static final DeferredItem<TravelersBackpackItem> PIG_TRAVELERS_BACKPACK = ITEMS.register("pig", () -> new TravelersBackpackItem(ModBlocks.PIG_TRAVELERS_BACKPACK.get(), "pig"));
    public static final DeferredItem<TravelersBackpackItem> SHEEP_TRAVELERS_BACKPACK = ITEMS.register("sheep", () -> new TravelersBackpackItem(ModBlocks.SHEEP_TRAVELERS_BACKPACK.get(), "sheep"));
    public static final DeferredItem<TravelersBackpackItem> CHICKEN_TRAVELERS_BACKPACK = ITEMS.register("chicken", () -> new TravelersBackpackItem(ModBlocks.CHICKEN_TRAVELERS_BACKPACK.get(), "chicken"));
    public static final DeferredItem<TravelersBackpackItem> SQUID_TRAVELERS_BACKPACK = ITEMS.register("squid", () -> new TravelersBackpackItem(ModBlocks.SQUID_TRAVELERS_BACKPACK.get(), "squid"));
    public static final DeferredItem<TravelersBackpackItem> VILLAGER_TRAVELERS_BACKPACK = ITEMS.register("villager", () -> new TravelersBackpackItem(ModBlocks.VILLAGER_TRAVELERS_BACKPACK.get(), "villager"));
    public static final DeferredItem<TravelersBackpackItem> IRON_GOLEM_TRAVELERS_BACKPACK = ITEMS.register("iron_golem", () -> new TravelersBackpackItem(ModBlocks.IRON_GOLEM_TRAVELERS_BACKPACK.get(), "iron_golem"));

    //Other Items
    public static final DeferredItem<SleepingBagItem> WHITE_SLEEPING_BAG = ITEMS.register("white_sleeping_bag", () -> new SleepingBagItem(ModBlocks.WHITE_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> ORANGE_SLEEPING_BAG = ITEMS.register("orange_sleeping_bag", () -> new SleepingBagItem(ModBlocks.ORANGE_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> MAGENTA_SLEEPING_BAG = ITEMS.register("magenta_sleeping_bag", () -> new SleepingBagItem(ModBlocks.MAGENTA_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> LIGHT_BLUE_SLEEPING_BAG = ITEMS.register("light_blue_sleeping_bag", () -> new SleepingBagItem(ModBlocks.LIGHT_BLUE_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> YELLOW_SLEEPING_BAG = ITEMS.register("yellow_sleeping_bag", () -> new SleepingBagItem(ModBlocks.YELLOW_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> LIME_SLEEPING_BAG = ITEMS.register("lime_sleeping_bag", () -> new SleepingBagItem(ModBlocks.LIME_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> PINK_SLEEPING_BAG = ITEMS.register("pink_sleeping_bag", () -> new SleepingBagItem(ModBlocks.PINK_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> GRAY_SLEEPING_BAG = ITEMS.register("gray_sleeping_bag", () -> new SleepingBagItem(ModBlocks.GRAY_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> LIGHT_GRAY_SLEEPING_BAG = ITEMS.register("light_gray_sleeping_bag", () -> new SleepingBagItem(ModBlocks.LIGHT_GRAY_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> CYAN_SLEEPING_BAG = ITEMS.register("cyan_sleeping_bag", () -> new SleepingBagItem(ModBlocks.CYAN_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> PURPLE_SLEEPING_BAG = ITEMS.register("purple_sleeping_bag", () -> new SleepingBagItem(ModBlocks.PURPLE_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> BLUE_SLEEPING_BAG = ITEMS.register("blue_sleeping_bag", () -> new SleepingBagItem(ModBlocks.BLUE_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> BROWN_SLEEPING_BAG = ITEMS.register("brown_sleeping_bag", () -> new SleepingBagItem(ModBlocks.BROWN_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> GREEN_SLEEPING_BAG = ITEMS.register("green_sleeping_bag", () -> new SleepingBagItem(ModBlocks.GREEN_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> RED_SLEEPING_BAG = ITEMS.register("red_sleeping_bag", () -> new SleepingBagItem(ModBlocks.RED_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<SleepingBagItem> BLACK_SLEEPING_BAG = ITEMS.register("black_sleeping_bag", () -> new SleepingBagItem(ModBlocks.BLACK_SLEEPING_BAG.get(), new Item.Properties()));
    public static final DeferredItem<Item> BACKPACK_TANK = ITEMS.register("backpack_tank", () -> new BackpackTankItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<HoseItem> HOSE = ITEMS.register("hose", () -> new HoseItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HOSE_NOZZLE = ITEMS.register("hose_nozzle", () -> new Item(new Item.Properties()));
    public static final DeferredItem<TierUpgrade> BLANK_UPGRADE = ITEMS.register("blank_upgrade", () -> new TierUpgrade(new Item.Properties(), TierUpgrade.Upgrade.BLANK_UPGRADE));
    public static final DeferredItem<TierUpgrade> IRON_TIER_UPGRADE = ITEMS.register("iron_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(16), TierUpgrade.Upgrade.IRON_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> GOLD_TIER_UPGRADE = ITEMS.register("gold_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(16), TierUpgrade.Upgrade.GOLD_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> DIAMOND_TIER_UPGRADE = ITEMS.register("diamond_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(16), TierUpgrade.Upgrade.DIAMOND_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> NETHERITE_TIER_UPGRADE = ITEMS.register("netherite_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(16), TierUpgrade.Upgrade.NETHERITE_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> ALLTHEMODIUM_TIER_UPGRADE = ITEMS.register("allthemodium_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(8), TierUpgrade.Upgrade.ALLTHEMODIUM_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> VIBRANIUM_TIER_UPGRADE = ITEMS.register("vibranium_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(4), TierUpgrade.Upgrade.VIBRANIUM_TIER_UPGRADE));
    public static final DeferredItem<TierUpgrade> UNOBTAINIUM_TIER_UPGRADE = ITEMS.register("unobtainium_tier_upgrade", () -> new TierUpgrade(new Item.Properties().stacksTo(2), TierUpgrade.Upgrade.UNOBTAINIUM_TIER_UPGRADE));
    public static final DeferredItem<TanksUpgradeItem> TANKS_UPGRADE = ITEMS.register("tanks_upgrade", () -> new TanksUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<CraftingUpgradeItem> CRAFTING_UPGRADE = ITEMS.register("crafting_upgrade", () -> new CraftingUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<FurnaceUpgradeItem> FURNACE_UPGRADE = ITEMS.register("furnace_upgrade", () -> new FurnaceUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<SmokerUpgradeItem> SMOKER_UPGRADE = ITEMS.register("smoker_upgrade", () -> new SmokerUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<BlastFurnaceUpgradeItem> BLAST_FURNACE_UPGRADE = ITEMS.register("blast_furnace_upgrade", () -> new BlastFurnaceUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<PickupUpgradeItem> PICKUP_UPGRADE = ITEMS.register("pickup_upgrade", () -> new PickupUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<MagnetUpgradeItem> MAGNET_UPGRADE = ITEMS.register("magnet_upgrade", () -> new MagnetUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<JukeboxUpgradeItem> JUKEBOX_UPGRADE = ITEMS.register("jukebox_upgrade", () -> new JukeboxUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<VoidUpgradeItem> VOID_UPGRADE = ITEMS.register("void_upgrade", () -> new VoidUpgradeItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<FeedingUpgradeItem> FEEDING_UPGRADE = ITEMS.register("feeding_upgrade", () -> new FeedingUpgradeItem(new Item.Properties().stacksTo(16)));

    public static final Supplier<EntityType<BackpackItemEntity>> BACKPACK_ITEM_ENTITY = ENTITY_TYPES.register(
            "backpack", () -> EntityType.Builder.of(BackpackItemEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(6).updateInterval(20).build("")
    );

    public static final List<Item> COMPATIBLE_OVERWORLD_BACKPACK_ENTRIES = new ArrayList<>();
    public static final List<Item> COMPATIBLE_NETHER_BACKPACK_ENTRIES = new ArrayList<>();

}