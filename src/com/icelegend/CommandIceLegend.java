package com.icelegend;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class CommandIceLegend extends CommandBase<IceLegend> {

	public CommandIceLegend(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	private IceLegend ic = getPlugin();

	// String prefix = msg_config.getString("prefix");

	@Override
	public boolean runCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.help")));

		} else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.playernotdetected")));
		}
		return true;
	}

}
