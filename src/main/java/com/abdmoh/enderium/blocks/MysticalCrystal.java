package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MysticalCrystal extends Block {

    public MysticalCrystal() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.GLASS)
                .hardnessAndResistance(2.0f)
                .lightValue(8)
        );
        setRegistryName("mystical_crystal");
    }
}
