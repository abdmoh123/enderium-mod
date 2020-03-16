package com.abdmoh.enderium.world;

import com.abdmoh.enderium.init.ModBlocks;
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
        //generates mystical crystals
        if (OreGenConfig.generate_enderium.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.MYSTICALCRYSTAL.getDefaultState(), OreGenConfig.enderium_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.enderium_chance.get(), OreGenConfig.enderium_bottom.get(), 0, OreGenConfig.enderium_top.get())));
            }
        }
        //generates ancient debris
        if (OreGenConfig.generate_netherite.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.ANCIENTDEBRIS.getDefaultState(), OreGenConfig.netherite_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.netherite_chance.get(), OreGenConfig.netherite_bottom.get(), 0, OreGenConfig.netherite_top.get())));
            }
        }
        //generates end diamond ore
        if (OreGenConfig.generate_end_diamond.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.ENDDIAMONDORE.getDefaultState(), OreGenConfig.end_diamond_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.end_diamond_chance.get(), OreGenConfig.end_diamond_bottom.get(), 0, OreGenConfig.end_diamond_top.get())));
            }
        }
        //generates nether gold ore
        if (OreGenConfig.generate_end_diamond.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.NETHERGOLDORE.getDefaultState(), OreGenConfig.nether_gold_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.nether_gold_chance.get(), OreGenConfig.nether_gold_bottom.get(), 0, OreGenConfig.nether_gold_top.get())));
            }
        }
    }
}
