package com.abdmoh.enderium.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum EnderiumToolMaterials implements IItemTier {

    //enderium tools created
    enderium(5.0F,
            12.0F,
            3122,
            4,
            19,
            ModItems.enderium_crystal
    ),
    //netherite tools created
    netherite(4.0F,
            10.0F,
            2031,
            4,
            19,
            ModItems.netherite_ingot
    );

    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    private EnderiumToolMaterials(
            float attackDamage,
            float efficiency,
            int durability,
            int harvestLevel,
            int enchantability,
            Item repairMaterial) {

        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
