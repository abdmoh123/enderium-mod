package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class EnderiumPickaxe extends Item {
    public EnderiumPickaxe() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(Enderium.setup.itemGroup));
        setRegistryName("enderium_pickaxe");
    }
}
