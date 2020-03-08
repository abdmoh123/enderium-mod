package com.abdmoh.enderium.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class EnderiumProperties {
    public static IItemTier EnderiumTier = new IItemTier() {

        @Override
        public int getMaxUses() {
            return 3122;
        }

        @Override
        public float getEfficiency() {
            return 12.0F;
        }

        @Override
        public float getAttackDamage() {
            return 4.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 19;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }
    };
}
