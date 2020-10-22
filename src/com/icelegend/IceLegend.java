package com.icelegend;
import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



public class IceLegend extends JavaPlugin{
	//initialize the yaml files
	private File msg = new File(this.getDataFolder(), "Messages.yml");
	private File attr_gui = new File(this.getDataFolder(), "AttributeGUI.yml");
	private File attr_name = new File(this.getDataFolder(), "AttributeName.yml");
	private File class_yml = new File(this.getDataFolder(),"Class.yml");
	private File class_gui = new File(this.getDataFolder(), "ClassGUI.yml");
	private File components_yml = new File(this.getDataFolder(), "Components.yml");
	private File gem = new File(this.getDataFolder(),"Gem.yml");
	private File gem_com = new File(this.getDataFolder(), "GemCombineGUI.yml");
	private File item_com = new File(this.getDataFolder(), "ItemCombineGUI.yml");
	private File item_mat = new File(this.getDataFolder(), "ItemMaterial.yml");
	private File item_skin = new File(this.getDataFolder(), "ItemSkin.yml");
	private File item_skin_com = new File(this.getDataFolder(), "ItemSkinCombineGUI.yml");
	private File item_tem = new File(this.getDataFolder(), "ItemTemplate.yml");
	private File placeholder = new File(this.getDataFolder(), "Placeholder_List.yml");
	private File series_lore = new File(this.getDataFolder(), "");
	
	private FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
	
    @Override
    public void onEnable() {
        //if the message.yml disappear, generate one.
    	if(!msg.exists()) saveResource("Messages.yml", false);
    	
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
