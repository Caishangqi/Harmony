package com.slot;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RingSlot {

    private List<Material> validRing = new ArrayList<>();

    public RingSlot() {
        validRing.add(Material.GOLD_NUGGET);
        validRing.add(Material.SLIME_BALL);
    }

    public ItemStack showRingSlot() {

        ItemStack slot = new ItemStack(Material.SNOWBALL);
        ItemMeta itemMeta = slot.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Ring Slot"));
        slot.setItemMeta(itemMeta);
        NBTItem nbtItem = new NBTItem(slot);
        nbtItem.setString("accessory", "ring");
        ItemStack ringSlot = nbtItem.getItem();

        return ringSlot;
    }

    public List<Material> getValidRing() {
        return validRing;
    }

    public void setValidRing(List<Material> validRing) {
        this.validRing = validRing;
    }
}