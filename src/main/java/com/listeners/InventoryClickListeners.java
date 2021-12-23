package com.listeners;

import com.slot.AmuletsSlot;
import com.slot.BraceletSlot;
import com.slot.CuriosSlot;
import com.slot.RingSlot;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class InventoryClickListeners implements Listener {


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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

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

                } else { //如果不是Ring中指定的物品类型
                    event.setCancelled(true); //取消点击动作
                    System.out.println("这个物品不是Ring类型的物品"); //Debug信息
                }

            }

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

            /**
             * 你可以理解View是第二层背包栏，setCursor后第二层背包显示就是Ring格子
             * 当你点击真实背包栏时set了之前储存的装备，这个时候你把装备取出的一瞬间
             * 物品栏就会被View的Cursor填充。
             */

            System.out.println(event.getSlot()); //Debug信息

        }


    }
}
