package com.util;

import com.harmony;

//用来测试命令注册
public class commandRegister {
    public harmony plugin;

    public commandRegister() {
        System.out.println("初始化构造器");
    }

    public commandRegister(harmony plugin) {
        this.plugin = plugin;
    }

    public void RegisterCommand() {
        System.out.println("指令模块开始注册");
//        plugin.getCommand("vault").setExecutor(new VaultCommand());
        System.out.println("指令模块注册完毕");
    }
}
