package com.icelegend;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandGiveCom implements CommandExecutor {
	IceLegend ic;

	public CommandGiveCom(IceLegend ic) {
		this.ic = ic;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Player p2 = Bukkit.getPlayer(args[0]);
		String destItem = args[1];
		if(ic.item_com_config.getString(destItem).equals(null)) {
			p.sendMessage(ic.format("Target component is not found"));
			return true;
		}

		List<String> lore = (List<String>) ic.item_com_config.getList(("Lore"));
		ItemStack item = new ItemStack(Material.matchMaterial(ic.item_com_config.getString(destItem + ".Material")));
		p.sendMessage(item.toString());
		p.sendMessage("args1: " + args[1]);

		ItemMeta im = item.getItemMeta();
		im.setCustomModelData(Integer.parseInt(ic.item_com_config.getString(destItem + ".Data")));
		Damageable dm = (Damageable) im;
		dm.setDamage(Integer.parseInt(ic.item_com_config.getString(destItem + ".Durability")));
		
		item.setItemMeta((ItemMeta) dm);
		p.sendMessage("--------END OF COM--------");
		p2.getInventory().addItem(item);

		p.sendMessage(ic.format(ic.msg_config.getString("Messages.giveitem")));
		return true;
	}

}
