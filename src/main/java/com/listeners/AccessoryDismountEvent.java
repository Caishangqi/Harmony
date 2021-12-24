package com.listeners;

import com.slot.AmuletsSlot;
import com.slot.BraceletSlot;
import com.slot.CuriosSlot;
import com.slot.RingSlot;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDismountEvent implements Listener {

    private RingSlot ringSlot;
    private CuriosSlot curiosSlot;
    private BraceletSlot braceletSlot;
    private AmuletsSlot amuletsSlot;

    List<Integer> accessorySlot = new ArrayList<>();

    List<ItemStack> slotItems = new ArrayList<>();

    {

        accessorySlot.add(9);
        accessorySlot.add(10);
        accessorySlot.add(11);
        accessorySlot.add(12);

        ringSlot = new RingSlot();
        curiosSlot = new CuriosSlot();
        braceletSlot = new BraceletSlot();
        amuletsSlot = new AmuletsSlot();

        slotItems.add(ringSlot.showRingSlot());
        slotItems.add(curiosSlot.showCurioSlot());
        slotItems.add(braceletSlot.showBraceletSlot());
        slotItems.add(amuletsSlot.showAmuletSlot());

    }

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
            if (accessorySlot.contains(event.getSlot())) {

                //如果是空鼠标指针的装备卸载
                if (event.getClick() == ClickType.RIGHT && event.getCursor().getType() == Material.AIR) {


                    ItemStack currentItem = event.getCurrentItem();
                    InventoryView view = event.getView(); //新建一个View
                    view.setCursor(currentItem); //让View的光标物品是Ring格子
                    event.getClickedInventory().setItem(event.getSlot(), slotItems.get(1)); //真实物品栏中设置当前点击格子为储存的装备


                }

                //TODO slotItems.contains()可以写成是否为空 节省内存
                //如果鼠标指针上有物品

                if (ringSlot.getValidRing().contains(event.getCursor()) && event.getClick() == ClickType.RIGHT && !slotItems.contains(event.getCurrentItem())) {

                    event.setCancelled(false);
                }

            }


        }
    }

}
