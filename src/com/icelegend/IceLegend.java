package com.icelegend;
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class IceLegend extends JavaPlugin{
	//Messages.yml
	private File msg = new File(this.getDataFolder(), "Messages.yml");
	private FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
	
    @Override
    public void onEnable() {
        //if the message.yml disappear, generate one.
    	if(!msg.exists()) {
    		saveResource("Messages.yml", false);
    	}
    	
        this.getCommand("ice").setExecutor(new CommandIceLegend());
        getLogger().info(format(msg_config.getString("loadplugin")));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getLogger().info(format(msg_config.getString("disableplugin")));
    }
    //return the configurations
    public FileConfiguration getMessagesConfig() {
    	return msg_config;
    }
    //return the file stream
    public File getMessagesFile() {
    	return msg;
    }
    // Format the string with color codes
    public String format(String str) {
    	return ChatColor.translateAlternateColorCodes('&', str);
    }
    
}
