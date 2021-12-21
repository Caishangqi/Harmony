package com.listeners;

import com.slot.RingSlot;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.concurrent.Delayed;

public class InventoryClickListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getClickedInventory() == null || event.getCurrentItem().getType() == Material.AIR) {
            System.out.println("空的");
            return;
        }

        if (event.getClickedInventory().getType().equals(InventoryType.PLAYER)) {


            System.out.println("点击的是玩家背包内部物品");
            Player whoClicked = (Player) event.getWhoClicked();
            ItemStack cursor = whoClicked.getItemOnCursor();
            System.out.println(cursor.getType());

            if (new NBTItem((event.getCurrentItem())).hasKey("accessory")) {

                RingSlot ringSlot = new RingSlot();
                Material itemOnCursor = event.getWhoClicked().getItemOnCursor().getType();

                if (ringSlot.getValidRing().contains(itemOnCursor)) {

//                    event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
                    event.setCancelled(false);
                    event.setCurrentItem(new ItemStack(Material.AIR));

                } else {
                    event.setCancelled(true);
                    System.out.println("这个物品不是Ring类型的物品");
                }


            }

            if (event.getSlot() == 9 && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().getType() != Material.SNOWBALL) {

                ItemStack currentItem = event.getCurrentItem();
                System.out.println("当前点击的物品是: " + event.getCurrentItem().getType());
                System.out.println("当前光标的物品是: " + event.getCursor().getType());
                InventoryView view = event.getView();
                view.setCursor(new RingSlot().showRingSlot());
                event.getClickedInventory().setItem(9, currentItem);

            }

            System.out.println(event.getSlot());

        }


    }
}
