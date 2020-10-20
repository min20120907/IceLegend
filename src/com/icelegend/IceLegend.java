package com.icelegend;
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin{
	private File msg = new File(this.getDataFolder(), "Message.yml");
	FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
    @Override
    public void onEnable() {
        // Register our command "kit" (set an instance of your command class as executor)
    	
        this.getCommand("ice").setExecutor(new CommandIceLegend());
        getLogger().info(msg_config.getString("load_plugin"));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getLogger().info("[冰晶傳說] 插件停用中...");
    }
}
