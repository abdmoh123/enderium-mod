package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderiumBlock extends Block {

    public EnderiumBlock() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.METAL)
                .hardnessAndResistance(50.0F, 1200)
                .harvestLevel(3)
        );
        setRegistryName("enderium_block");
    }
}
