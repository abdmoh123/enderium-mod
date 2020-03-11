package com.abdmoh.enderium;

import com.abdmoh.enderium.blocks.EnderiumBlock;
import com.abdmoh.enderium.blocks.ModBlocks;
import com.abdmoh.enderium.blocks.MysticalCrystal;
import com.abdmoh.enderium.items.EnderiumCrystal;
import com.abdmoh.enderium.items.InfusedDiamond;
import com.abdmoh.enderium.items.MysticalDust;
import com.abdmoh.enderium.lists.ArmorMatList;
import com.abdmoh.enderium.lists.ItemList;
import com.abdmoh.enderium.lists.ToolMatList;
import com.abdmoh.enderium.setup.ClientProxy;
import com.abdmoh.enderium.setup.IProxy;
import com.abdmoh.enderium.setup.ModSetup;
import com.abdmoh.enderium.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("enderium")
public class Enderium {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public static final String modid = "enderium";

    private static final Logger LOGGER = LogManager.getLogger();

    public Enderium() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        //registers blocks
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            //blocks registered
            event.getRegistry().registerAll(
                    new MysticalCrystal(),
                    new EnderiumBlock()
            );
        }

        //registers items
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);

            //block items registered
            event.getRegistry().register(new BlockItem(ModBlocks.MYSTICALCRYSTAL, properties).setRegistryName("mystical_crystal"));
            event.getRegistry().register(new BlockItem(ModBlocks.ENDERIUMBLOCK, properties).setRegistryName("enderium_block"));

            //items registered
            event.getRegistry().registerAll(
                    //other items registered
                    ItemList.enderium_crystal = new EnderiumCrystal(),
                    ItemList.infused_diamond = new InfusedDiamond(),
                    ItemList.mystical_dust = new MysticalDust(),

                    //tools registered
                    ItemList.enderium_axe = (AxeItem) new AxeItem(
                            ToolMatList.enderium,
                            5.0F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_axe"),

                    ItemList.enderium_hoe = (HoeItem) new HoeItem(
                            ToolMatList.enderium,
                            1.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_hoe"),

                    ItemList.enderium_pickaxe = (PickaxeItem) new PickaxeItem(
                            ToolMatList.enderium,
                            1,
                            -2.8F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_pickaxe"),

                    ItemList.enderium_shovel = (ShovelItem) new ShovelItem(
                            ToolMatList.enderium,
                            1.5F,
                            -3.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_shovel"),

                    ItemList.enderium_sword = (SwordItem) new SwordItem(
                            ToolMatList.enderium,
                            3,
                            -2.0F,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_sword"),

                    //armour registered
                    ItemList.enderium_helmet = (ArmorItem) new ArmorItem(
                            ArmorMatList.enderium,
                            EquipmentSlotType.HEAD,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_helmet"),

                    ItemList.enderium_chestplate = (ArmorItem) new ArmorItem(
                            ArmorMatList.enderium,
                            EquipmentSlotType.CHEST,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_chestplate"),

                    ItemList.enderium_leggings = (ArmorItem) new ArmorItem(
                            ArmorMatList.enderium,
                            EquipmentSlotType.LEGS,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_leggings"),

                    ItemList.enderium_boots = (ArmorItem) new ArmorItem(
                            ArmorMatList.enderium,
                            EquipmentSlotType.FEET,
                            new Item.Properties()
                                    .group(Enderium.setup.itemGroup))
                                    .setRegistryName("enderium_boots")
            );
        }
    }
}
