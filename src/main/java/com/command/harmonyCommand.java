package com.command;

import com.util.ConfigFactory;
import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.chat.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class harmonyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {

            String Version = ConfigFactory.getConfig().getString("Version");
            String Author = "Caizii";
            String Description = "为什么不把许多共同的插件整合在一起呢？";
            Player p = (Player) sender;
            p.sendMessage("当前版本：" + Version);
            p.sendMessage("创建者：" + Author);
            p.sendMessage("描述：" + Description);


        }
        return true;
    }
}
