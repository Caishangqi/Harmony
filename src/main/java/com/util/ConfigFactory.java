package com.util;

import com.harmony;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConfigFactory {
    public static harmony plugin;

    public ConfigFactory (harmony plugin){
        this.plugin = plugin;
    }

    public static @NotNull FileConfiguration getConfig() {
        return plugin.getConfig();
    }
}
