package com.event;

import com.event.harmony.RuaEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class playerChatEvent implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event){
        if (event.getMessage().equals("rua"))
        {
            RuaEvent ruaEvent = new RuaEvent(event.getPlayer());
            Bukkit.getServer().getPluginManager().callEvent(ruaEvent);
        }
    }
}
