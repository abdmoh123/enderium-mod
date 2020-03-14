package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class NetheriteBlock extends Block {

    public NetheriteBlock() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.METAL)
                .hardnessAndResistance(50.0f, 1200)
                .harvestLevel(3)
        );
        setRegistryName("netherite_block");
    }
}