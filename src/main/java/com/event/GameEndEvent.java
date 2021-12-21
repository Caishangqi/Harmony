package com.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GameEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private Player winner;
    private Player loser;
    private int final_score;

    public GameEndEvent(Player winner, Player loser, int final_score) {
        this.winner = winner;
        this.loser = loser;
        this.final_score = final_score;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public int getFinal_score() {
        return final_score;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
