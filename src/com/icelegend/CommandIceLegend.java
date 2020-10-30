package com.icelegend;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			// subcommand relaod
			if (args.length > 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					if (sender.hasPermission("IceLegend.command.reload")) {
						sender.sendMessage(ic.format(ic.msg_config.getString("Messages.disableplugin")));
						Bukkit.getPluginManager().disablePlugin(ic);
						sender.sendMessage(ic.format(ic.msg_config.getString("Messages.loadplugin")));
						Bukkit.getPluginManager().enablePlugin(ic);
					} else {
						sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
					}
				}

				// sub command help
				else if (args[0].equalsIgnoreCase("help")) {
					if (sender.hasPermission("IceLegend.command.help")) {
						if (args[1].equals(null))
							sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.help")));
						else {
							List<String> msg = (List<String>) ic.help_config.getList("Page" + args[1] + ".messages");
							for (int j = 0; j < msg.size(); j++)
								sender.sendMessage(ic.format(msg.get(j)));
						}
					} else {
						sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
					}
				}
			} else {
				sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.help")));
			}

		} else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.playernotdetected")));
		}

		// If the player (or console) uses our command correct, we can return true
		return true;
	}
}
