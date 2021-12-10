package com;

import com.event.welcomeMsg;
import com.util.ConfigFactory;
import com.util.commandRegister;
import com.util.eventRegister;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class harmony extends JavaPlugin {
    public ConfigFactory configFactory;


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));
        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
        //注册配置工厂
        configFactory = new ConfigFactory(this);

        //注册指令注册器
        //注册事件注册器
        new eventRegister(this).RegisterEvent().RegisterCommand();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
