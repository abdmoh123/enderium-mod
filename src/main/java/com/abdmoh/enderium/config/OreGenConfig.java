package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    public static ForgeConfigSpec.IntValue enderium_chance;
    public static ForgeConfigSpec.IntValue netherite_chance;
    public static ForgeConfigSpec.BooleanValue generate_end;
    public static ForgeConfigSpec.BooleanValue generate_nether;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("OreGen Config");

        enderium_chance = server
                .comment("Maximum number of mystical crystal veins that can spawn in one chunk")
                .defineInRange("oregen.enderium_chance", 100, 1, 100000);

        netherite_chance = server
                .comment("Maximum number of ancient debris veins that can spawn in one chunk")
                .defineInRange("oregen.netherite_chance", 100, 1, 100000);

        generate_end = server
                .comment("Decide if you want mystical crystals to spawn")
                .define("oregen.generate_end", true);

        generate_nether = server
                .comment("Decide if you want ancient debris to spawn")
                .define("oregen.generate_nether", true);
    }
}
