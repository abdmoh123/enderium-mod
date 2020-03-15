package com.abdmoh.enderium.setup;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.blocks.ModBlocks;
import com.abdmoh.enderium.world.OreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("enderium") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.MYSTICALCRYSTAL);
        }
    };

    public void init() {
        //sets up the ore generation
        OreGen.setupOreGen();
        Enderium.LOGGER.info("Setup method registered");
    }
}
