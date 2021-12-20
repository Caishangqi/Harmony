package com.util;

import com.harmony;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Date;

public class DateLogger {

    public harmony plugin;

    public DateLogger(harmony plugin) {
        this.plugin = plugin;
    }

    public String startDate() {
        Date date = new Date();
        return date.toString();
    }

    //修改配置文件时间 记录
    public void modifyDateByDefault() {
        File settingFile = new File(plugin.getDataFolder(), "settings.yml");
        YamlConfiguration settingFileYaml = YamlConfiguration.loadConfiguration(settingFile);
        settingFileYaml.set("generate_date", startDate());
        try {
            settingFileYaml.save(settingFile);
        } catch (Exception e) {
            new File(plugin.getDataFolder(), "settings.yml");
        }
    }
}
