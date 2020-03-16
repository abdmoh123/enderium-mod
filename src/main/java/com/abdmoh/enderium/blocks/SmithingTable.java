package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SmithingTable extends Block {
    public SmithingTable() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.5F)
        );
        setRegistryName("smithing_table");
    }
}
