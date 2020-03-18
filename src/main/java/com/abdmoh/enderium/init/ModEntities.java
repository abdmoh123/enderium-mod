package com.abdmoh.enderium.init;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.entities.EnderSentry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class ModEntities {
    public static EntityType<?> ENDER_SENTRY = EntityType.Builder.create(
            EnderSentry::new, EntityClassification.CREATURE).build(
                    "enderium:ender_sentry").setRegistryName("ender_sentry");

    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ModItems.ENDER_SENTRY_EGG = registerSpawnEgg(ENDER_SENTRY, 0xec11f7, 0x8513d1, "ender_sentry_egg")
        );
    }

    public static Item registerSpawnEgg(EntityType<?> type, int colour1, int colour2, String name) {
        SpawnEggItem item = new SpawnEggItem(type, colour1, colour2, new Item.Properties().group(Enderium.setup.itemGroup));
        item.setRegistryName(name);
        return item;
    }

    public static void registerWorldSpawns() {
        registerWorldSpawn(ENDER_SENTRY,
                Biomes.SMALL_END_ISLANDS
        );
    }

    public static void registerWorldSpawn(EntityType<?> entity, Biome...biomes) {
        for (Biome biome: biomes) {
            if (biome != null) {
                biome.getSpawns(entity.getClassification()).add(
                        new Biome.SpawnListEntry(entity, 10, 1, 10)
                );
            }
        }
    }
}
