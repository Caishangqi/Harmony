package com.event.harmony;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class RuaEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private boolean cancelledFlag = false;
    private String msg = "RUA!!!";

    {
        this.msg = msg;
    }
    public RuaEvent(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
        }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelledFlag;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelledFlag = cancelledFlag;
    }
}
