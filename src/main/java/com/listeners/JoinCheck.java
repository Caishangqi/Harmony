package com.listeners;

import com.slot.AmuletsSlot;
import com.slot.BraceletSlot;
import com.slot.CuriosSlot;
import com.slot.RingSlot;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 监听加入事件，让新玩家获取装备栏
 * 同时每次玩家加入服务器检测异常装备栏
 */
public class JoinCheck implements Listener {

    private ItemStack ringItem;
    private ItemStack curiosItem;
    private ItemStack braceletItem;
    private ItemStack amuletItem;

    HashMap<String, ItemStack> accessorySlot = new HashMap<String, ItemStack>();


    @EventHandler(priority = EventPriority.LOW)
    public void onJoinCheck(PlayerJoinEvent event) {

        Player joinPlayer = event.getPlayer();
        PlayerInventory playerInventory = joinPlayer.getInventory();

        ringItem = playerInventory.getItem(9);
        curiosItem = playerInventory.getItem(10);
        braceletItem = playerInventory.getItem(11);
        amuletItem = playerInventory.getItem(12);

        accessorySlot.put("ring", ringItem);
        accessorySlot.put("curios", curiosItem);
        accessorySlot.put("bracelet", braceletItem);
        accessorySlot.put("amuletItem", amuletItem);

        Iterator<Map.Entry<String, ItemStack>> iterator = accessorySlot.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ItemStack> entry = iterator.next();
            if (entry.getValue() == null) {

                //TODO 如果是空的，根据KEY来指定不同的Slot
                if (entry.getKey().equals("ring")) {
                    ringItem = new RingSlot().showRingSlot();
                }

                if (entry.getKey().equals("curios")) {
                    curiosItem = new CuriosSlot().showCurioSlot();
                }

                if (entry.getKey().equals("bracelet")) {
                    braceletItem = new BraceletSlot().showBraceletSlot();
                }

                if (entry.getKey().equals("amuletItem")) {
                    amuletItem = new AmuletsSlot().showAmuletSlot();
                }

            }


        }

        playerInventory.setItem(9, ringItem);
        playerInventory.setItem(10, curiosItem);
        playerInventory.setItem(11, braceletItem);
        playerInventory.setItem(12, amuletItem);


    }


}
