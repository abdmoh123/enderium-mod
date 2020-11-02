package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MobSpawnConfig {
    public static ForgeConfigSpec.BooleanValue ender_sentry_spawn;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("MobSpawning Config");

        ender_sentry_spawn = server
                .comment("Choose whether the ender sentry spawns in the game or not [default = true]")
                .define("mobspawn.ender_sentry_spawn", true);
    }
}
