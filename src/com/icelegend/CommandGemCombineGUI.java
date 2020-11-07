package com.icelegend;

import java.text.DecimalFormat;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandGemCombineGUI implements CommandExecutor {
	IceLegend ic;
	public CommandGemCombineGUI(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub

		if(sender.hasPermission("IceLegend.command.gemcombinegui")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.gemcombinegui")));
			// START OF GUI
			DecimalFormat formatter = new DecimalFormat("00");
			 sender.sendMessage("[Debug] locate01.Name: "+ic.gem_com_config.getString("locate01.Name"));

			Inventory gui = Bukkit.createInventory(null, Integer.parseInt(ic.gem_com_config.getString("count")),
					ic.gem_com_config.getString("Title"));
			
			// proclaim the sender as a player
			Player player = (Player) sender;
			//player.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.itemcombinegui")));
			// This opens the inventory
			int i = 1;
			while (ic.gem_com_config.getString("locate" + formatter.format(i)) != null) {
				// Proclaim the attribute variables
				List<Integer> locate = (List<Integer>) ic.gem_com_config
						.getList(("locate" + formatter.format(i) + ".Locate"));
				// do the loop to put all the items in the different locations
				//sender.sendMessage("first item: "+String.valueOf(locate.get(0)));
				for (int j = 0; j < locate.size(); j++) {
					// sender.sendMessage("[Debug] Material "+formatter.format(2)+":
					// "+ic.gem_com_config.getString("locate" + formatter.format(2) +
					// ".Material")+"\nj: "+j);
					// sender.sendMessage("[Debug] Locate Size "+formatter.format(i)+":
					// "+locate.size());
					String name = ic.gem_com_config.getString("locate" + formatter.format(i) + ".Name");
					String use = ic.gem_com_config.getString("locate" + formatter.format(i) + ".Use");
					ItemStack mat = new ItemStack(Material
							.matchMaterial(ic.gem_com_config.getString("locate" + formatter.format(i) + ".Material")));
					List<String> lore = (List<String>) ic.gem_com_config
							.getList(("locate" + formatter.format(i) + ".Lore"));
					// sender.sendMessage("[Debug] Locate "+formatter.format(j)+": "+locate.get(j));
					ItemMeta meta = mat.getItemMeta();
					// apply the color format
					ic.formatList(lore);
					// set lore on item mat
					meta.setLore(lore);
					// set display name
					meta.setDisplayName(name);
					// set meta to the item mat
					mat.setItemMeta(meta);
					// give item to gui
					gui.setItem(locate.get(j), mat);
				}

				i++;
			}
			// open gui to the user
			player.openInventory(gui);

			// END OF THE GUI
		}
		return true;
	}

}
