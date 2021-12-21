package com.listeners;

import com.slot.AmuletsSlot;
import com.slot.BraceletSlot;
import com.slot.CuriosSlot;
import com.slot.RingSlot;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;


public class PlayerOpenInventory implements Listener {

    @EventHandler
    public void playerOpenInventory(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        ItemStack snowBall = new ItemStack(Material.SNOWBALL);
        NBTItem nbtItem = new NBTItem(snowBall);
        nbtItem.setString("accessory", "undefined");
        ItemStack snowballnbt = nbtItem.getItem();


        //戒指

        NBTItem ring = new NBTItem(new ItemStack(Material.SNOWBALL));


        player.getInventory().setItem(9, new RingSlot().showRingSlot());
        player.getInventory().setItem(10, new AmuletsSlot().showAmuletSlot());
        player.getInventory().setItem(11, new BraceletSlot().showBraceletSlot());
        player.getInventory().setItem(12, new CuriosSlot().showCurioSlot());
    }

}
