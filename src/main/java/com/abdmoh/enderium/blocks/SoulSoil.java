package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SoulSoil extends Block {

    public SoulSoil() {
        super(Properties.create(Material.EARTH)
                .sound(SoundType.GROUND)
                .hardnessAndResistance(0.5F)
                .harvestTool(ToolType.SHOVEL)
        );
        setRegistryName("soul_soil");
    }
}
