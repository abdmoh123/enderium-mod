package com.abdmoh.enderium.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes {
    public static Biome soul_sand_valley;

    public static void registerBiome(Biome biome, Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    public static void registerBiomes() {
        registerBiome(soul_sand_valley, Type.NETHER);
    }
}
