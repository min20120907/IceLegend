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
    	//initialize the command classes
        this.getCommand("icelegend").setExecutor(new CommandIceLegend(this));
        this.getCommand("skilltreegui").setExecutor(new CommandSkillTreeGUI(this));
        this.getCommand("attributegui").setExecutor(new CommandAttributeGUI(this));
        this.getCommand("skilltreegui").setExecutor(new CommandCombineSkillGUI(this));
        this.getCommand("classgui").setExecutor(new CommandClassGUI(this));
        this.getCommand("selectclassgui").setExecutor(new CommandSelectClassGUI(this));
        this.getCommand("itemcombinegui").setExecutor(new CommandItemCombineGUI(this));
        this.getCommand("bindskillgui").setExecutor(new CommandBindSkillGUI(this));
        this.getCommand("itemskincombinegui").setExecutor(new CommandCobineSkillGUI(this));
        this.getCommand("gemcombinegui").setExecutor(new CommandGemCombineGUI(this));
        this.getCommand("skillbar").setExecutor(new CommandSkillBar(this));
        
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
    	return ChatColor.translateAlternateColorCodes('&', str.replace("%prefix%",msg_config.getString("prefix")));
    }
    
    
    
}
