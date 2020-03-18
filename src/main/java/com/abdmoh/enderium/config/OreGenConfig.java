package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    //mystical crystal configs
    public static ForgeConfigSpec.IntValue enderium_chance;
    public static ForgeConfigSpec.IntValue enderium_count;
    public static ForgeConfigSpec.IntValue enderium_bottom;
    public static ForgeConfigSpec.IntValue enderium_top;
    public static ForgeConfigSpec.BooleanValue generate_enderium;

    //ancient debris configs
    public static ForgeConfigSpec.IntValue netherite_chance;
    public static ForgeConfigSpec.IntValue netherite_count;
    public static ForgeConfigSpec.IntValue netherite_bottom;
    public static ForgeConfigSpec.IntValue netherite_top;
    public static ForgeConfigSpec.BooleanValue generate_netherite;

    //end diamond ore configs
    public static ForgeConfigSpec.IntValue end_diamond_chance;
    public static ForgeConfigSpec.IntValue end_diamond_count;
    public static ForgeConfigSpec.IntValue end_diamond_bottom;
    public static ForgeConfigSpec.IntValue end_diamond_top;
    public static ForgeConfigSpec.BooleanValue generate_end_diamond;

    //nether gold ore configs
    public static ForgeConfigSpec.IntValue nether_gold_chance;
    public static ForgeConfigSpec.IntValue nether_gold_count;
    public static ForgeConfigSpec.IntValue nether_gold_bottom;
    public static ForgeConfigSpec.IntValue nether_gold_top;
    public static ForgeConfigSpec.BooleanValue generate_nether_gold;

    //basalt configs
    public static ForgeConfigSpec.IntValue basalt_chance;
    public static ForgeConfigSpec.IntValue basalt_count;
    public static ForgeConfigSpec.IntValue basalt_bottom;
    public static ForgeConfigSpec.IntValue basalt_top;
    public static ForgeConfigSpec.BooleanValue generate_basalt;

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

        generate_enderium = server
                .comment("Decide if you want mystical crystals to generate")
                .define("oregen.generate_enderium", true);

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

        generate_netherite = server
                .comment("Decide if you want ancient debris to generate")
                .define("oregen.generate_netherite", true);

        //ender diamond gen config
        end_diamond_count = server
                .comment("Maximum number of end diamond ore in a vein")
                .defineInRange("oregen.end_diamond_count", 9, 1, 100);

        end_diamond_chance = server
                .comment("Maximum number of end diamond ore veins that can spawn in one chunk")
                .defineInRange("oregen.end_diamond_chance", 5, 1, 100);

        end_diamond_bottom = server
                .comment("Lowest y-value end diamond ore can spawn at")
                .defineInRange("oregen.end_diamond_bottom", 10, 0, 256);

        end_diamond_top = server
                .comment("Highest y-value end diamond ore can spawn at")
                .defineInRange("oregen.end_diamond_top", 117, 0, 256);

        generate_end_diamond = server
                .comment("Decide if you want end diamond ore to generate")
                .define("oregen.generate_end_diamond", true);

        //nether gold gen config
        nether_gold_count = server
                .comment("Maximum number of nether gold ore in a vein")
                .defineInRange("oregen.nether_gold_count", 10, 1, 100);

        nether_gold_chance = server
                .comment("Maximum number of nether gold ore veins that can spawn in one chunk")
                .defineInRange("oregen.nether_gold_chance", 10, 1, 100);

        nether_gold_bottom = server
                .comment("Lowest y-value nether gold ore can spawn at")
                .defineInRange("oregen.nether_gold_bottom", 10, 0, 256);

        nether_gold_top = server
                .comment("Highest y-value nether gold ore can spawn at")
                .defineInRange("oregen.nether_gold_top", 117, 0, 256);

        generate_nether_gold = server
                .comment("Decide if you want nether gold ore to generate")
                .define("oregen.generate_nether_gold", true);

        //basalt gen config
        basalt_count = server
                .comment("Maximum number of basalt in a vein")
                .defineInRange("oregen.basalt_count", 32, 1, 100);

        basalt_chance = server
                .comment("Maximum number of basalt veins that can spawn in one chunk")
                .defineInRange("oregen.basalt_chance", 10, 1, 100);

        basalt_bottom = server
                .comment("Lowest y-value basalt can spawn at")
                .defineInRange("oregen.basalt_bottom", 4, 0, 256);

        basalt_top = server
                .comment("Highest y-value basalt can spawn at")
                .defineInRange("oregen.basalt_top", 50, 0, 256);

        generate_basalt = server
                .comment("Decide if you want basalt to generate")
                .define("oregen.generate_basalt", true);
    }
}
