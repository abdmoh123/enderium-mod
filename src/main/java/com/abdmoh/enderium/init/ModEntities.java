package com.abdmoh.enderium.init;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.entities.XEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class ModEntities {
    public static EntityType<?> X_MOB = EntityType.Builder.create(
            XEntity::new, EntityClassification.CREATURE).build(
                    "enderium:x_mob").setRegistryName("x_mob");

    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ModItems.x_egg = registerSpawnEgg(X_MOB, 0xec11f7, 0x8513d1, "x_egg")
        );
    }

    public static Item registerSpawnEgg(EntityType<?> type, int colour1, int colour2, String name) {
        SpawnEggItem item = new SpawnEggItem(type, colour1, colour2, new Item.Properties().group(Enderium.setup.itemGroup));
        item.setRegistryName(name);
        return item;
    }

    public static void registerWorldSpawns() {
        registerWorldSpawn(X_MOB,
                Biomes.PLAINS,
                Biomes.TAIGA,
                Biomes.GIANT_SPRUCE_TAIGA,
                Biomes.TAIGA_MOUNTAINS,
                Biomes.TAIGA_HILLS,
                Biomes.GIANT_TREE_TAIGA,
                Biomes.GIANT_SPRUCE_TAIGA_HILLS,
                Biomes.GIANT_TREE_TAIGA_HILLS
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
