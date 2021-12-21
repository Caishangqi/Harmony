package com.util;

import com.event.welcomeMsg;
import com.harmony;
import com.listeners.GameListeners;
import com.listeners.InventoryClickListeners;
import com.listeners.PlayerOpenInventory;

//事件注册器，用来集中注册事件
public class eventRegister extends commandRegister {

    public harmony plugin;

    public eventRegister(harmony plugin) {
        this.plugin = plugin;
    }

    public void RegisterEvent() {
        System.out.println("事件模块开始注册");
        plugin.getServer().getPluginManager().registerEvents(new welcomeMsg(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GameListeners(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerOpenInventory(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InventoryClickListeners(), plugin);
        System.out.println("事件模块注册完毕");
    }

}
