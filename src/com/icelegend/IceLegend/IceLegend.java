package com.icelegend.IceLegend;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("ice").setExecutor(new CommandIceLegend());
        getLogger().info("[冰晶傳說] 插件載入中...");
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getLogger().info("[冰晶傳說] 插件停用中...");
    }
}
