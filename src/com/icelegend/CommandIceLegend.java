package com.icelegend;

import java.io.File;
import java.text.SimpleDateFormat;

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
public class CommandIceLegend implements CommandExecutor {
	private IceLegend ic;

	public CommandIceLegend(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	// String prefix = msg_config.getString("prefix");
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			// subcommand relaod
			if (cmd.getName().equalsIgnoreCase("reload")) {
				if (sender.hasPermission("IceLegend.command.reload")) {
					Bukkit.getPluginManager().disablePlugin(ic);
					Bukkit.getPluginManager().enablePlugin(ic);
				} else {
					sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
				}
			}
			
			//sub command help
			if(cmd.getName().equalsIgnoreCase("help")) {
				if(sender.hasPermission("IceLegend.command.help")) {
					
				} else {
					sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
				}
			}

			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Gemsuccess")));

		} else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Gemfailed")));
		}

		// If the player (or console) uses our command correct, we can return true
		return true;
	}
}
