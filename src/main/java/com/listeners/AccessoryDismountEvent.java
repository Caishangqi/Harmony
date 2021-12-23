package com.listeners;

import com.slot.RingSlot;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class AccessoryDismountEvent implements Listener {


    @EventHandler(priority = EventPriority.LOW)
    public void onAccessoryDismount(InventoryClickEvent event) throws InterruptedException {

        /*
         * 修复NPE屏幕外点击以及物品栏内部空物品
         * */
        if (event.getClickedInventory() == null || event.getCurrentItem().getType() == Material.AIR) {
            System.out.println("空的");
            return;
        }

        if (event.getClickedInventory().getType().equals(InventoryType.PLAYER)) {


            /**
             * 装备取出逻辑，如果点击的是RingSlot 默认配了 9 坐标格子
             * 并且点击的不是空格并且不是雪球 (默认格子)
             */


            if (event.getSlot() == 9 && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().getType() != Material.SNOWBALL) {

                //把当前装备上的物品存入变量
                ItemStack currentItem = event.getCurrentItem();
                System.out.println("当前点击的物品是: " + event.getCurrentItem().getType()); //Debug信息
                System.out.println("当前光标的物品是: " + event.getCursor().getType()); //Debug信息
                InventoryView view = event.getView(); //新建一个View
                view.setCursor(new RingSlot().showRingSlot()); //让View的光标物品是Ring格子
                event.getClickedInventory().setItem(9, currentItem); //真实物品栏中设置当前点击格子为储存的装备

            }

        }
    }

}
