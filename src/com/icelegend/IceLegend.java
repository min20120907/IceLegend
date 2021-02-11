package com.icelegend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IceLegend extends JavaPlugin implements Listener {

	// initialize the yaml files
	@NotNull
	public File msg = new File(this.getDataFolder(), "Messages.yml");
	@NotNull
	public File attr_gui = new File(this.getDataFolder(), "AttributeGUI.yml");
	@NotNull
	public File attr_name = new File(this.getDataFolder(), "AttributeName.yml");
	@NotNull
	public File class_yml = new File(this.getDataFolder(), "Class.yml");
	@NotNull
	public File class_gui = new File(this.getDataFolder(), "ClassGUI.yml");
	@NotNull
	public File components_yml = new File(this.getDataFolder(), "Components.yml");
	@NotNull
	public File gem = new File(this.getDataFolder(), "Gem.yml");
	@NotNull
	public File gem_com = new File(this.getDataFolder(), "GemCombineGUI.yml");
	@NotNull
	public File item_com = new File(this.getDataFolder(), "ItemCombineGUI.yml");
	@NotNull
	public File item_mat = new File(this.getDataFolder(), "ItemMaterial.yml");
	@NotNull
	public File item_skin = new File(this.getDataFolder(), "ItemSkin.yml");
	@NotNull
	public File item_skin_com = new File(this.getDataFolder(), "ItemSkinCombineGUI.yml");
	@NotNull
	public File item_tem = new File(this.getDataFolder(), "ItemTemplate.yml");
	@NotNull
	public File placeholder = new File(this.getDataFolder(), "Placeholder_List.yml");
	@NotNull
	public File series_lore = new File(this.getDataFolder(), "SeriesLore.yml");
	@NotNull
	public File help = new File(this.getDataFolder(), "Commandpage.yml");
	// initialize the yaml configurations
	@NotNull
	public FileConfiguration msg_config = YamlConfiguration.loadConfiguration(msg);
	@NotNull
	public FileConfiguration attr_gui_config = YamlConfiguration.loadConfiguration(attr_gui);
	@NotNull
	public FileConfiguration attr_name_config = YamlConfiguration.loadConfiguration(attr_name);
	@NotNull
	public FileConfiguration class_yml_config = YamlConfiguration.loadConfiguration(class_yml);
	@NotNull
	public FileConfiguration class_gui_config = YamlConfiguration.loadConfiguration(class_gui);
	@NotNull
	public FileConfiguration components_yml_config = YamlConfiguration.loadConfiguration(components_yml);
	@NotNull
	public FileConfiguration gem_config = YamlConfiguration.loadConfiguration(gem);
	@NotNull
	public FileConfiguration gem_com_config = YamlConfiguration.loadConfiguration(gem_com);
	@NotNull
	public FileConfiguration item_com_config = YamlConfiguration.loadConfiguration(item_com);
	@NotNull
	public FileConfiguration item_mat_config = YamlConfiguration.loadConfiguration(item_mat);
	@NotNull
	public FileConfiguration item_skin_config = YamlConfiguration.loadConfiguration(item_skin);
	@NotNull
	public FileConfiguration item_skin_com_config = YamlConfiguration.loadConfiguration(item_skin_com);
	@NotNull
	public FileConfiguration item_tem_config = YamlConfiguration.loadConfiguration(item_tem);
	@NotNull
	public FileConfiguration placeholder_config = YamlConfiguration.loadConfiguration(placeholder);
	@NotNull
	public FileConfiguration series_lore_config = YamlConfiguration.loadConfiguration(series_lore);
	@NotNull
	public FileConfiguration help_config = YamlConfiguration.loadConfiguration(help);
	// components elements
	public final ArrayList<ItemStack> components = new ArrayList<>();
	public final ArrayList<ItemMeta> components_meta = new ArrayList<>();
	public final String[] ComponentType = { "Melee", "Magic", "Shoot", "Defence" };

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
		Objects.requireNonNull(this.getCommand("icelegend")).setExecutor(cil);
		Objects.requireNonNull(this.getCommand("icelegend")).setTabCompleter(new TabComEvent(this));
		// normal command registrations
		Objects.requireNonNull(this.getCommand("skilltreegui")).setExecutor(new CommandSkillTreeGUI(this));
		Objects.requireNonNull(this.getCommand("attributegui")).setExecutor(new CommandAttributeGUI(this));
		Objects.requireNonNull(this.getCommand("skilltreegui")).setExecutor(new CommandCombineSkillGUI(this));
		Objects.requireNonNull(this.getCommand("classgui")).setExecutor(new CommandClassGUI(this));
		Objects.requireNonNull(this.getCommand("selectclassgui")).setExecutor(new CommandSelectClassGUI(this));
		Objects.requireNonNull(this.getCommand("itemcombinegui")).setExecutor(new CommandItemCombineGUI(this));
		Objects.requireNonNull(this.getCommand("bindskillgui")).setExecutor(new CommandBindSkillGUI(this));
		Objects.requireNonNull(this.getCommand("itemskincombinegui")).setExecutor(new CommandItemSkinCombineGUI(this));
		Objects.requireNonNull(this.getCommand("gemcombinegui")).setExecutor(new CommandGemCombineGUI(this));
		Objects.requireNonNull(this.getCommand("skillbar")).setExecutor(new CommandSkillBar(this));
		// new commands
		Objects.requireNonNull(this.getCommand("getitem")).setExecutor(new CommandGetItem(this));
		Objects.requireNonNull(this.getCommand("getgem")).setExecutor(new CommandGetGem(this));
		Objects.requireNonNull(this.getCommand("getskin")).setExecutor(new CommandGetSkin(this));
		Objects.requireNonNull(this.getCommand("getskillpoint")).setExecutor(new CommandGetSkillPoint(this));
		Objects.requireNonNull(this.getCommand("classopen")).setExecutor(new CommandClassOpen(this));
		Objects.requireNonNull(this.getCommand("giveitem")).setExecutor(new CommandGiveItem(this));
		Objects.requireNonNull(this.getCommand("givegem")).setExecutor(new CommandGiveGem(this));
		Objects.requireNonNull(this.getCommand("givemana")).setExecutor(new CommandGiveMana(this));
		Objects.requireNonNull(this.getCommand("giveskin")).setExecutor(new CommandGiveSkin(this));
		Objects.requireNonNull(this.getCommand("givecom")).setExecutor(new CommandGiveCom(this));
		// Register the clicker event to the plugin.
		Bukkit.getPluginManager().registerEvents(new ClickerEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(this), this);
		// Register the items...

		getLogger().info(format(Objects.requireNonNull(msg_config.getString("Messages.loadplugin"))));
	}
	
	

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		getLogger().info(format(Objects.requireNonNull(msg_config.getString("Messages.disableplugin"))));
	}

	// Format the string with color codes
	@NotNull
	public String format(@NotNull String str) {
		return ChatColor.translateAlternateColorCodes('&', str.replace("%prefix%", Objects.requireNonNull(msg_config.getString("prefix"))));
	}

	@Override
	public void reloadConfig() {
		// config is a FileConfiguration object
		// cfile is the File object
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

	// Attributes String proclaiming
	@Nullable
	public String getAttrDesc(@NotNull FileConfiguration c, @NotNull String str) {
		return attr_name_config.getString("Attribute." + c.getString(str));
	}

	@NotNull
	List<String> formatList(@NotNull List<String> a) {
		List<String> tmp = new ArrayList<>();
		for (String s : a) tmp.add(format(s));
		return tmp;
	}

}
