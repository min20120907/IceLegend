package com.icelegend;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandGiveItem implements CommandExecutor {
	IceLegend ic;

	public CommandGiveItem(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Player p2 = Bukkit.getPlayer(args[0]);
		String destItem = args[1];
		int count = 1;
		ItemStack i = new ItemStack(Material.AIR);
		DecimalFormat formatter = new DecimalFormat("00");
		for (String com : ic.ComponentType) {
			while (ic.item_mat_config.getString("Type." + com + "." + formatter.format(count) + ".material") != null) {
				ItemStack item = new ItemStack(Material.matchMaterial(
						ic.item_mat_config.getString("Type." + com + formatter.format(count) + ".material")));
				
				if (destItem.equalsIgnoreCase(ic.item_com_config.getString("Type."+com))) {
					ItemMeta im = item.getItemMeta();
					im.setUnbreakable(Boolean.parseBoolean(ic.item_mat_config.getString(
							ic.item_mat_config.getString("Type." + com + formatter.format(count) + ".Unbreakable"))));
					im.setCustomModelData(Integer.parseInt(ic.item_mat_config.getString("Type." + com + formatter.format(count) + ".Data")));
					Damageable dm = (Damageable) im;
					dm.setDamage(Integer.parseInt(
							ic.item_mat_config.getString("Type." + com + formatter.format(count) + ".Durability")));
					
					item.setItemMeta((ItemMeta) dm);
					i = item;
					break;
				}
				count++;
			}
		}
		if (!i.equals(new ItemStack(Material.AIR)))
			p2.getInventory().addItem(i);
		else
			p.sendMessage("NO ITEM");
		p.sendMessage(ic.format(ic.msg_config.getString("Messages.giveitem")));
		return true;
	}

}
