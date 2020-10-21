package com.icelegend;
import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



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
    	
        this.getCommand("ice").setExecutor(new CommandIceLegend(msg_config, this));
        getLogger().info(format(msg_config.getString("Messages.loadplugin")));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	getLogger().info(format(msg_config.getString("Messages.disableplugin")));
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
    	return ChatColor.translateAlternateColorCodes('&', str.replace(StringUtils.substringBetween(str, "%", "%"), msg_config.getString(StringUtils.substringBetween(str, "%", "%"))).replace("%",""));
    }
    
    
    
}
