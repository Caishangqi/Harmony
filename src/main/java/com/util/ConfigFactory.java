package com.util;

import com.harmony;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.ResourceBundle;

//// 读取配置文件
//// this.getDataFolder()方法返回插件配置文件夹的File对象
//File biuConfigFile = new File(this.getDataFolder(), "biu.yml");
//// 也可以在插件配置文件夹创建一个新的文件夹以存放配置文件
//// File biuConfigFile = new File(this.getDataFolder(), "test/biu.yml");
//        FileConfiguration biuConfig = YamlConfiguration.loadConfiguration(biuConfigFile);
//        biuConfig.get.......
//        biuConfig.set.......
//// set完了记得保存!
//        biuConfig.save(biuConfigFile);

public class ConfigFactory {

    private static harmony plugin;

    public ConfigFactory(harmony plugin) {
        this.plugin = plugin;
    }


    public static FileConfiguration getConfig() {
        return plugin.getConfig();
    }
}
