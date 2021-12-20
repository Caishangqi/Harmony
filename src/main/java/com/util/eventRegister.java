package com.util;

import com.event.welcomeMsg;
import com.harmony;

//事件注册器，用来集中注册事件
public class eventRegister extends commandRegister {

    public harmony plugin;

    public eventRegister(harmony plugin){
        this.plugin = plugin;
    }

    public void RegisterEvent(){
        System.out.println("事件模块开始注册");
        plugin.getServer().getPluginManager().registerEvents(new welcomeMsg(),plugin);
        System.out.println("事件模块注册完毕");
    }

}
