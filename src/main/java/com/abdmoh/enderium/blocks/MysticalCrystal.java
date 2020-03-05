package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

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
