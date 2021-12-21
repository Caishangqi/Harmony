package com.listeners;

import com.event.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameListeners implements Listener {

    @EventHandler
    public void onGameEnd(GameEndEvent event) {

        Bukkit.getServer().broadcastMessage("Ended!");
        Bukkit.getServer().broadcastMessage("Winner: " + event.getWinner().getName());
        Bukkit.getServer().broadcastMessage("Loser: " + event.getLoser().getName());

    }
}
