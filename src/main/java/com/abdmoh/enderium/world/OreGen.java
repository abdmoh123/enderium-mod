package com.abdmoh.enderium.world;

import com.abdmoh.enderium.blocks.ModBlocks;
import com.abdmoh.enderium.config.OreGenConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    private static final ReplaceBlockConfig END_STONE = new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(),
            ModBlocks.MYSTICALCRYSTAL.getDefaultState());
    public static void setupOreGen() {
        if (OreGenConfig.generate_end.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.MYSTICALCRYSTAL.getDefaultState(), OreGenConfig.enderium_chance.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(2, 4, 0, 25)));
            }
        }
        if (OreGenConfig.generate_nether.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.ANCIENTDEBRIS.getDefaultState(), OreGenConfig.netherite_chance.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(2, 4, 0, 20)));
            }
        }
    }
}
