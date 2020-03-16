package com.abdmoh.enderium;

import com.abdmoh.enderium.blocks.*;
import com.abdmoh.enderium.client.renders.ModRenderRegistry;
import com.abdmoh.enderium.config.Config;
import com.abdmoh.enderium.init.*;
import com.abdmoh.enderium.items.*;
import com.abdmoh.enderium.setup.ClientProxy;
import com.abdmoh.enderium.setup.IProxy;
import com.abdmoh.enderium.setup.ModSetup;
import com.abdmoh.enderium.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("enderium")
public class Enderium {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public static final String MODID = "enderium";

    public static final Logger LOGGER = LogManager.getLogger();

    public Enderium() {
        //registers config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);

        // Register the setup method for mod loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        //loads config files
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("enderium-server.toml").toString());
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("enderium-client.toml").toString());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //initialises the setup and proxy
        setup.init();
        proxy.init();

        LOGGER.info("setup method registered");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        //registers entities
        ModRenderRegistry.registryEntityRenders();
        LOGGER.info("clientRegistries method registered");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        //loot table stuff
        @SubscribeEvent
        public void lootLoad(LootTableLoadEvent evt) {
            if (evt.getName().toString().equals("minecraft:chests/simple_dungeon")) {
                //do stuff with evt.getTable()
                //regular dungeon loot here

            }
        }

        //registers blocks
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            //blocks registered
            event.getRegistry().registerAll(
                    new EndDiamondOre(),
                    new NetherGoldOre(),
                    new Basalt(),
                    new Complite(),
                    new MysticalCrystal(),
                    new AncientDebris(),
                    new EnderiumBlock(),
                    new NetheriteBlock(),
                    new SmithingTable()
            );
        }

        //registers items
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);

            //block items registered
            event.getRegistry().registerAll(
                    new BlockItem(ModBlocks.ENDDIAMONDORE, properties).setRegistryName("end_diamond_ore"),
                    new BlockItem(ModBlocks.NETHERGOLDORE, properties).setRegistryName("nether_gold_ore"),
                    new BlockItem(ModBlocks.BASALT, properties).setRegistryName("basalt"),
                    new BlockItem(ModBlocks.COMPLITE, properties).setRegistryName("complite"),
                    new BlockItem(ModBlocks.MYSTICALCRYSTAL, properties).setRegistryName("mystical_crystal"),
                    new BlockItem(ModBlocks.ANCIENTDEBRIS, properties).setRegistryName("ancient_debris"),
                    new BlockItem(ModBlocks.ENDERIUMBLOCK, properties).setRegistryName("enderium_block"),
                    new BlockItem(ModBlocks.NETHERITEBLOCK, properties).setRegistryName("netherite_block"),
                    new BlockItem(ModBlocks.SMITHINGTABLE, properties).setRegistryName("smithing_table")
            );

            //items registered
            event.getRegistry().registerAll(
                    //other items registered
                    ModItems.enderium_crystal = new EnderiumCrystal(),
                    ModItems.infused_diamond = new InfusedDiamond(),
                    ModItems.mystical_dust = new MysticalDust(),
                    ModItems.netherite_scrap = new NetheriteScrap(),
                    ModItems.netherite_ingot = new NetheriteIngot(),

                    //tools registered
                    //enderium tools
                    ModItems.enderium_axe = (AxeItem) new AxeItem(
                            ModToolMaterials.enderium,
                            5.0F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_axe"),

                    ModItems.enderium_hoe = (HoeItem) new HoeItem(
                            ModToolMaterials.enderium,
                            1.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_hoe"),

                    ModItems.enderium_pickaxe = (PickaxeItem) new PickaxeItem(
                            ModToolMaterials.enderium,
                            1,
                            -2.8F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_pickaxe"),

                    ModItems.enderium_shovel = (ShovelItem) new ShovelItem(
                            ModToolMaterials.enderium,
                            1.5F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_shovel"),

                    ModItems.enderium_sword = (SwordItem) new SwordItem(
                            ModToolMaterials.enderium,
                            3,
                            -2.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_sword"),

                    //netherite tools
                    ModItems.netherite_axe = (AxeItem) new AxeItem(
                            ModToolMaterials.netherite,
                            5.0F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_axe"),

                    ModItems.netherite_hoe = (HoeItem) new HoeItem(
                            ModToolMaterials.netherite,
                            1.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_hoe"),

                    ModItems.netherite_pickaxe = (PickaxeItem) new PickaxeItem(
                            ModToolMaterials.netherite,
                            1,
                            -2.8F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_pickaxe"),

                    ModItems.netherite_shovel = (ShovelItem) new ShovelItem(
                            ModToolMaterials.netherite,
                            1.5F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_shovel"),

                    ModItems.netherite_sword = (SwordItem) new SwordItem(
                            ModToolMaterials.netherite,
                            3,
                            -2.4F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_sword"),


                    //armour registered
                    //enderium armour
                    ModItems.enderium_helmet = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.enderium,
                            EquipmentSlotType.HEAD,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_helmet"),

                    ModItems.enderium_chestplate = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.enderium,
                            EquipmentSlotType.CHEST,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_chestplate"),

                    ModItems.enderium_leggings = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.enderium,
                            EquipmentSlotType.LEGS,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_leggings"),

                    ModItems.enderium_boots = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.enderium,
                            EquipmentSlotType.FEET,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_boots"),

                    //netherite armour
                    ModItems.netherite_helmet = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.netherite,
                            EquipmentSlotType.HEAD,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_helmet"),

                    ModItems.netherite_chestplate = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.netherite,
                            EquipmentSlotType.CHEST,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_chestplate"),

                    ModItems.netherite_leggings = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.netherite,
                            EquipmentSlotType.LEGS,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_leggings"),

                    ModItems.netherite_boots = (ArmorItem) new ArmorItem(
                            ModArmorMaterials.netherite,
                            EquipmentSlotType.FEET,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                            .setRegistryName("netherite_boots")
            );

            //registers entities (spawn eggs)
            ModEntities.registerSpawnEggs(event);
        }

        @SubscribeEvent
        public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().registerAll(
                    ModEntities.X_MOB
            );

            ModEntities.registerWorldSpawns();
        }
    }
}
