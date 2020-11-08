package com.icelegend;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin implements Listener {
	// initialize the yaml files
	public File msg = new File(this.getDataFolder(), "Messages.yml");
	public File attr_gui = new File(this.getDataFolder(), "AttributeGUI.yml");
	public File attr_name = new File(this.getDataFolder(), "AttributeName.yml");
	public File class_yml = new File(this.getDataFolder(), "Class.yml");
	public File class_gui = new File(this.getDataFolder(), "ClassGUI.yml");
	public File components_yml = new File(this.getDataFolder(), "Components.yml");
	public File gem = new File(this.getDataFolder(), "Gem.yml");
	public File gem_com = new File(this.getDataFolder(), "GemCombineGUI.yml");
	public File item_com = new File(this.getDataFolder(), "ItemCombineGUI.yml");
	public File item_mat = new File(this.getDataFolder(), "ItemMaterial.yml");
	public File item_skin = new File(this.getDataFolder(), "ItemSkin.yml");
	public File item_skin_com = new File(this.getDataFolder(), "ItemSkinCombineGUI.yml");
	public File item_tem = new File(this.getDataFolder(), "ItemTemplate.yml");
	public File placeholder = new File(this.getDataFolder(), "Placeholder_List.yml");
	public File series_lore = new File(this.getDataFolder(), "SeriesLore.yml");
	public File help = new File(this.getDataFolder(), "Commandpage.yml");
	// initialize the yaml configurations
	public FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
	public FileConfiguration attr_gui_config = YamlConfiguration.loadConfiguration(attr_gui);
	public FileConfiguration attr_name_config = YamlConfiguration.loadConfiguration(attr_name);
	public FileConfiguration class_yml_config = YamlConfiguration.loadConfiguration(class_yml);
	public FileConfiguration class_gui_config = YamlConfiguration.loadConfiguration(class_gui);
	public FileConfiguration components_yml_config = YamlConfiguration.loadConfiguration(components_yml);
	public FileConfiguration gem_config = YamlConfiguration.loadConfiguration(gem);
	public FileConfiguration gem_com_config = YamlConfiguration.loadConfiguration(gem_com);
	public FileConfiguration item_com_config = YamlConfiguration.loadConfiguration(item_com);
	public FileConfiguration item_mat_config = YamlConfiguration.loadConfiguration(item_mat);
	public FileConfiguration item_skin_config = YamlConfiguration.loadConfiguration(item_skin);
	public FileConfiguration item_skin_com_config = YamlConfiguration.loadConfiguration(item_skin_com);
	public FileConfiguration item_tem_config = YamlConfiguration.loadConfiguration(item_tem);
	public FileConfiguration placeholder_config = YamlConfiguration.loadConfiguration(placeholder);
	public FileConfiguration series_lore_config = YamlConfiguration.loadConfiguration(series_lore);
	public FileConfiguration help_config = YamlConfiguration.loadConfiguration(help);
	//components elements
	public ArrayList<ItemStack> components = new ArrayList<ItemStack>();
	public ArrayList<ItemMeta> components_meta = new ArrayList<ItemMeta>();
	@Override
	public void onEnable() {
		// if the YAML disappear, generate one.
		if (!msg.exists())
			saveResource("Messages.yml", false);
		if (!attr_gui.exists())
			saveResource("AttributeGUI.yml", false);
		if (!attr_name.exists())
			saveResource("AttributeName.yml", false);
		if (!class_yml.exists())
			saveResource("Class.yml", false);
		if (!class_gui.exists())
			saveResource("ClassGUI.yml", false);
		if (!components_yml.exists())
			saveResource("Components.yml", false);
		if (!gem.exists())
			saveResource("Gem.yml", false);
		if (!gem_com.exists())
			saveResource("GemCombineGUI.yml", false);
		if (!item_com.exists())
			saveResource("ItemCombineGUI.yml", false);
		if (!item_mat.exists())
			saveResource("ItemMaterial.yml", false);
		if (!item_skin.exists())
			saveResource("ItemSkin.yml", false);
		if (!item_skin_com.exists())
			saveResource("ItemSkinCombineGUI.yml", false);
		if (!item_tem.exists())
			saveResource("ItemTemplate.yml", false);
		if (!placeholder.exists())
			saveResource("Placeholder_List.yml", false);
		if (!series_lore.exists())
			saveResource("SeriesLore.yml", false);
		if (!help.exists())
			saveResource("Commandpage.yml", false);

		// initialize the command classes
		SubCommandHelp help = new SubCommandHelp(this);
		SubCommandReload reload = new SubCommandReload(this);
		CommandIceLegend cil = new CommandIceLegend(this);

		// register subcommands
		cil.registerSubCommand("help", help);
		cil.registerSubCommand("reload", reload);
		this.getCommand("icelegend").setExecutor(cil);
		this.getCommand("icelegend").setTabCompleter(new TabComEvent(this));
		// normal command registrations
		this.getCommand("skilltreegui").setExecutor(new CommandSkillTreeGUI(this));
		this.getCommand("attributegui").setExecutor(new CommandAttributeGUI(this));
		this.getCommand("skilltreegui").setExecutor(new CommandCombineSkillGUI(this));
		this.getCommand("classgui").setExecutor(new CommandClassGUI(this));
		this.getCommand("selectclassgui").setExecutor(new CommandSelectClassGUI(this));
		this.getCommand("itemcombinegui").setExecutor(new CommandItemCombineGUI(this));
		this.getCommand("bindskillgui").setExecutor(new CommandBindSkillGUI(this));
		this.getCommand("itemskincombinegui").setExecutor(new CommandItemSkinCombineGUI(this));
		this.getCommand("gemcombinegui").setExecutor(new CommandGemCombineGUI(this));
		this.getCommand("skillbar").setExecutor(new CommandSkillBar(this));
		//new commands
		this.getCommand("getitem").setExecutor(new CommandGetItem(this));
		this.getCommand("getgem").setExecutor(new CommandGetGem(this));
		this.getCommand("getskin").setExecutor(new CommandGetSkin(this));
		this.getCommand("getskillpoint").setExecutor(new CommandGetSkillPoint(this));
		this.getCommand("classopen").setExecutor(new CommandClassOpen(this));
		this.getCommand("giveitem").setExecutor(new CommandGiveItem(this));
		this.getCommand("givegem").setExecutor(new CommandGiveGem(this));
		this.getCommand("givemana").setExecutor(new CommandGiveMana(this));
		this.getCommand("giveskin").setExecutor(new CommandGiveSkin(this));
		// Register the clicker event to the plugin.
		Bukkit.getPluginManager().registerEvents(new ClickerEvent(this), this);
		// Register the items...
		
		
		getLogger().info(format(msg_config.getString("Messages.loadplugin")));
	}

	

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		getLogger().info(format(msg_config.getString("Messages.disableplugin")));
	}

	// Format the string with color codes
	public String format(String str) {
		return ChatColor.translateAlternateColorCodes('&', str.replace("%prefix%", msg_config.getString("prefix")));
	}
	@Override
    public void reloadConfig() {
        //config is a FileConfiguration object
       //cfile is the File object
    	// initialize the yaml files
    	 msg = new File(this.getDataFolder(), "Messages.yml");
    	 attr_gui = new File(this.getDataFolder(), "AttributeGUI.yml");
    	 attr_name = new File(this.getDataFolder(), "AttributeName.yml");
    	 class_yml = new File(this.getDataFolder(), "Class.yml");
    	 class_gui = new File(this.getDataFolder(), "ClassGUI.yml");
    	 components_yml = new File(this.getDataFolder(), "Components.yml");
    	 gem = new File(this.getDataFolder(), "Gem.yml");
    	 gem_com = new File(this.getDataFolder(), "GemCombineGUI.yml");
    	 item_com = new File(this.getDataFolder(), "ItemCombineGUI.yml");
    	 item_mat = new File(this.getDataFolder(), "ItemMaterial.yml");
    	 item_skin = new File(this.getDataFolder(), "ItemSkin.yml");
    	 item_skin_com = new File(this.getDataFolder(), "ItemSkinCombineGUI.yml");
    	 item_tem = new File(this.getDataFolder(), "ItemTemplate.yml");
    	 placeholder = new File(this.getDataFolder(), "Placeholder_List.yml");
    	 series_lore = new File(this.getDataFolder(), "SeriesLore.yml");
    	 help = new File(this.getDataFolder(), "Commandpage.yml");
    	// initialize the yaml configurations
    	msg_config = YamlConfiguration.loadConfiguration(msg);
    	 attr_gui_config = YamlConfiguration.loadConfiguration(attr_gui);
    	 attr_name_config = YamlConfiguration.loadConfiguration(attr_name);
    	 class_yml_config = YamlConfiguration.loadConfiguration(class_yml);
    	 class_gui_config = YamlConfiguration.loadConfiguration(class_gui);
    	 components_yml_config = YamlConfiguration.loadConfiguration(components_yml);
    	 gem_config = YamlConfiguration.loadConfiguration(gem);
    	 gem_com_config = YamlConfiguration.loadConfiguration(gem_com);
    	 item_com_config = YamlConfiguration.loadConfiguration(item_com);
    	 item_mat_config = YamlConfiguration.loadConfiguration(item_mat);
    	 item_skin_config = YamlConfiguration.loadConfiguration(item_skin);
    	 item_skin_com_config = YamlConfiguration.loadConfiguration(item_skin_com);
    	 item_tem_config = YamlConfiguration.loadConfiguration(item_tem);
    	 placeholder_config = YamlConfiguration.loadConfiguration(placeholder);
    	 series_lore_config = YamlConfiguration.loadConfiguration(series_lore);
    	 help_config = YamlConfiguration.loadConfiguration(help);
   }
	List<String> formatList(List<String> a) {
		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < a.size(); i++)
			tmp.add(format(a.get(i)));
		return tmp;
	}
}
