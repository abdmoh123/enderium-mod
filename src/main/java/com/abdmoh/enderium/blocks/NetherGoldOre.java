package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class NetherGoldOre extends Block {
    public NetherGoldOre() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0F, 0.2F)
                .harvestLevel(2)
        );
        setRegistryName("nether_gold_ore");
    }
}
