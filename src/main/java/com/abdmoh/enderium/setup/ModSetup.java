package com.abdmoh.enderium.setup;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.init.ModItems;
import com.abdmoh.enderium.world.gen.OreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("enderium") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.enderium_crystal);
        }
    };

    public void init() {
        //sets up the ore generation
        OreGen.setupOreGen();
        Enderium.LOGGER.info("Setup method registered");
    }
}
