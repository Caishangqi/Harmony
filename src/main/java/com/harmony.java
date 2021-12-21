package com;

import com.util.ConfigFactory;
import com.util.DateLogger;
import com.util.commandRegister;
import com.util.eventRegister;
import me.wolfyscript.utilities.api.WolfyUtilities;
import me.wolfyscript.utilities.api.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class harmony extends JavaPlugin {

    public ConfigFactory configFactory; //配置工厂 自制
    private final WolfyUtilities wolfyUtilitiesApi; //WolfyUtilities API

    //插件默认的构造器
    public harmony() {
        super();
        wolfyUtilitiesApi = WolfyUtilities.get(this, false);
        Chat chat = wolfyUtilitiesApi.getChat();
        chat.setInGamePrefix("§7[§3调和§7] ");

    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f加载成功"));
        //注册默认Config,没有的话创建一个
        saveDefaultConfig();

        //注册自定义config
        this.saveResource("settings.yml", true);
        new DateLogger(this).modifyDateByDefault();
        //注册配置工厂
        configFactory = new ConfigFactory(this);

        //注册指令注册器
        //注册事件注册器
        new eventRegister(this).RegisterEvent();
        new commandRegister(this).RegisterCommand();

        //注册依赖
        this.wolfyUtilitiesApi.initialize();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
