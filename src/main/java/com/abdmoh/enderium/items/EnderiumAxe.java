package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class EnderiumAxe extends Item {
    public EnderiumAxe() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(Enderium.setup.itemGroup));
        setRegistryName("enderium_axe");
    }
}
