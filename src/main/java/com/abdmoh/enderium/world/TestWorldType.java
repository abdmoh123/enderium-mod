package com.abdmoh.enderium.world;

import com.abdmoh.enderium.init.ModBiomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class TestWorldType extends WorldType {

    public TestWorldType() {
        super("test_type");
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator(World world) {
        OverworldGenSettings settings = new OverworldGenSettings();
        SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();

        single.setBiome(ModBiomes.soul_sand_valley);
        return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
    }
}
