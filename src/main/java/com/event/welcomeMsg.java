package com.event;

import com.util.ConfigFactory;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class welcomeMsg implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        String msg = ConfigFactory.getConfig().getString("Settings.Welmsg");
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

    }
}
