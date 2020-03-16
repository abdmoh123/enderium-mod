package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Complite extends Block {

    public Complite() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.5F, 8F)
        );
        setRegistryName("complite");
    }
}
