package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EndDiamondOre extends Block {
    public EndDiamondOre() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0F, 4.5F)
                .harvestLevel(2)
        );
        setRegistryName("end_diamond_ore");
    }
}
