package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class MysticalCrystal extends Block {

    public MysticalCrystal() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.GLASS)
                .hardnessAndResistance(30.0F, 1200)
                .lightValue(8)
                .harvestLevel(3)
        );
        setRegistryName("mystical_crystal");
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
