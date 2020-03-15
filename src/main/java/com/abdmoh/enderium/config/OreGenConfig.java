package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    public static ForgeConfigSpec.IntValue enderium_chance;
    public static ForgeConfigSpec.IntValue enderium_count;
    public static ForgeConfigSpec.IntValue enderium_bottom;
    public static ForgeConfigSpec.IntValue enderium_top;

    public static ForgeConfigSpec.IntValue netherite_chance;
    public static ForgeConfigSpec.IntValue netherite_count;
    public static ForgeConfigSpec.IntValue netherite_bottom;
    public static ForgeConfigSpec.IntValue netherite_top;

    public static ForgeConfigSpec.BooleanValue generate_end;
    public static ForgeConfigSpec.BooleanValue generate_nether;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("OreGen Config");

        //enderium generation config
        enderium_count = server
                .comment("Maximum number of mystical crystals in a vein")
                .defineInRange("oregen.enderium_count", 4, 1, 100);

        enderium_chance = server
                .comment("Maximum number of mystical crystal veins that can spawn in one chunk")
                .defineInRange("oregen.enderium_chance", 2, 1, 100);

        enderium_bottom = server
                .comment("Lowest y-value mystical crystals can spawn at")
                .defineInRange("oregen.enderium_bottom", 4, 0, 256);

        enderium_top = server
                .comment("Highest y-value mystical crystals can spawn at")
                .defineInRange("oregen.enderium_top", 25, 0, 256);

        //netherite generation config
        netherite_count = server
                .comment("Maximum number of ancient debris  in a vein")
                .defineInRange("oregen.netherite_chance", 4, 1, 100);

        netherite_chance = server
                .comment("Maximum number of ancient debris veins that can spawn in one chunk")
                .defineInRange("oregen.enderium_chance", 2, 1, 100);

        netherite_bottom = server
                .comment("Lowest y-value ancient debris can spawn at")
                .defineInRange("oregen.enderium_bottom", 4, 0, 256);

        netherite_top = server
                .comment("Highest y-value ancient debris can spawn at")
                .defineInRange("oregen.enderium_top", 20, 0, 256);

        //general generation config
        generate_end = server
                .comment("Decide if you want end generation")
                .define("oregen.generate_end", true);

        generate_nether = server
                .comment("Decide if you want nether generation")
                .define("oregen.generate_nether", true);
    }
}
