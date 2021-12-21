package com.slot;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CuriosSlot {


    public ItemStack showCurioSlot() {

        ItemStack slot = new ItemStack(Material.SNOWBALL);
        ItemMeta itemMeta = slot.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&7Curios Slot"));
        slot.setItemMeta(itemMeta);
        NBTItem nbtItem = new NBTItem(slot);
        nbtItem.setString("accessory", "curios");
        ItemStack ringSlot = nbtItem.getItem();

        return ringSlot;
    }


}