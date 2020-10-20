package com.icelegend;
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register our command "kit" (set an instance of your command class as executor)
    	private File default_ = new File(this.getDataFolder(), "UIList.yml");
    	FileConfiguration config = YamlConfiguration.loadConfiguration(default_);
        this.getCommand("ice").setExecutor(new CommandIceLegend());
        getLogger().info("[冰晶傳說] 插件載入中...");
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getLogger().info("[冰晶傳說] 插件停用中...");
    }
}
