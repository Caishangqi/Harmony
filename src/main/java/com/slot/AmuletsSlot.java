package com.slot;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AmuletsSlot {


    public ItemStack showAmuletSlot() {

        ItemStack slot = new ItemStack(Material.SNOWBALL);
        ItemMeta itemMeta = slot.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&7Amulets Slot"));
        slot.setItemMeta(itemMeta);
        NBTItem nbtItem = new NBTItem(slot);
        nbtItem.setString("accessory", "amulets");
        ItemStack ringSlot = nbtItem.getItem();

        return ringSlot;
    }


}