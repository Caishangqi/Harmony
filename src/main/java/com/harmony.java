package com;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class harmony extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));
        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
