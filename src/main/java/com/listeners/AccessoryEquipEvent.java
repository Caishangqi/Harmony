package com.listeners;

import com.slot.AmuletsSlot;
import com.slot.BraceletSlot;
import com.slot.CuriosSlot;
import com.slot.RingSlot;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class AccessoryEquipEvent implements Listener {


    private RingSlot ringSlot;
    private CuriosSlot curiosSlot;
    private BraceletSlot braceletSlot;
    private AmuletsSlot amuletsSlot;

    List<Integer> accessorySlot = new ArrayList<>();

    {

        accessorySlot.add(9);
        accessorySlot.add(10);
        accessorySlot.add(11);
        accessorySlot.add(12);

        ringSlot = new RingSlot();
        curiosSlot = new CuriosSlot();
        braceletSlot = new BraceletSlot();
        amuletsSlot = new AmuletsSlot();

    }

    @EventHandler(priority = EventPriority.LOW)
    public void onAccessoryEquip(InventoryClickEvent event) {

        if (event.getWhoClicked().getGameMode() == GameMode.CREATIVE) {

            if (accessorySlot.contains(event.getSlot())) {


                Player whoClicked = (Player) event.getWhoClicked();
                whoClicked.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7创造模式无法打开配饰物品栏"));

                //TODO 把创造模式和生存模式的物品暂时存起来，序列化，在不同游戏模式下切换回来。
            }

        }

        /*
         * 修复NPE屏幕外点击以及物品栏内部空物品
         * */
        if (event.getClickedInventory() == null || event.getCurrentItem().getType() == Material.AIR) {
            System.out.println("空的");
            return;
        }

        /**
         * 如果这是一个玩家背包则执行下方代码
         */
        if (event.getClickedInventory().getType().equals(InventoryType.PLAYER)) {


            //提示信息
            System.out.println("点击的是玩家背包内部物品");
            //谁点击的物品栏
            Player whoClicked = (Player) event.getWhoClicked();
            //测试在光标拖动物品
            ItemStack cursor = whoClicked.getItemOnCursor();
            System.out.println(cursor.getType());

            /**
             * 如果玩家点击背包任何格子开始检测，如果当前物品
             * 有nbt标签 "accessory" 说明这是一个饰品栏
             */

            if (new NBTItem((event.getCurrentItem())).hasKey("accessory")) {

                //获取当你把物品拖到指定槽位光标上的物品
                Material itemOnCursor = event.getWhoClicked().getItemOnCursor().getType();

                //如果这个光标上的物品符合Ring 中指定的物品类型
                if (ringSlot.getValidRing().contains(itemOnCursor)) {

                    event.setCurrentItem(new ItemStack(Material.AIR)); //删除原本槽位限制图标，把光标上的物品放入

                    //TODO 看看能不能用view做出来拖拽阻塞栏位防止凋落物进入物品栏

                } else { //如果不是Ring中指定的物品类型
                    event.setCancelled(true); //取消点击动作
                    System.out.println("这个物品不是Ring类型的物品"); //Debug信息
                }

            }



            /**
             * 你可以理解View是第二层背包栏，setCursor后第二层背包显示就是Ring格子
             * 当你点击真实背包栏时set了之前储存的装备，这个时候你把装备取出的一瞬间
             * 物品栏就会被View的Cursor填充。
             */

            System.out.println(event.getSlot()); //Debug信息

        }


    }
}
