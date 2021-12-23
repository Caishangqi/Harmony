package com.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerDeathListeners implements Listener {



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent event) {


        //TODO 如果配置文件开启死亡掉落逻辑 默认关闭饰品掉落


        //TODO 检查逻辑 防止空的槽位没有被装备栏填充

        ItemStack item1 = event.getPlayer().getInventory().getItem(9);
        ItemStack item2 = event.getPlayer().getInventory().getItem(10);
        ItemStack item3 = event.getPlayer().getInventory().getItem(11);
        ItemStack item4 = event.getPlayer().getInventory().getItem(12);

        event.getDrops().remove(item1);
        event.getDrops().remove(item2);
        event.getDrops().remove(item3);
        event.getDrops().remove(item4);

        List<ItemStack> itemsToKeep = event.getItemsToKeep();
        itemsToKeep.add(item1);
        itemsToKeep.add(item2);
        itemsToKeep.add(item3);
        itemsToKeep.add(item4);



        System.out.println(item1.getType());


    }
}
