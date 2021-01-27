package com.icelegend;

import java.awt.Image;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
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
		if (ic.components_yml_config.getString(destItem).equals(null)) {
			p.sendMessage(ic.format("Target component is not found"));
			return true;
		}

		List<String> lore = (List<String>) ic.components_yml_config.getList((destItem+".Lore"));
		
		ItemStack item = new ItemStack(Material.matchMaterial(ic.components_yml_config.getString(destItem + ".Material")));
		p.sendMessage(item.toString());
		p.sendMessage("args1: " + args[1]);
		
		ItemMeta im = item.getItemMeta();
		im.setCustomModelData(Integer.parseInt(ic.components_yml_config.getString(destItem + ".Data")));
		Damageable dm = (Damageable) im;
		dm.setDamage(Integer.parseInt(ic.components_yml_config.getString(destItem + ".Durability")));
		List<String> attr_list = (List<String>) ic.components_yml_config.getList(destItem+".Attribute");
		for(String s : attr_list) {
			AttributeModifier mod = new AttributeModifier(UUID.randomUUID(), s,
					ic.components_yml_config.getDouble(destItem+"." + s), Operation.ADD_NUMBER, EquipmentSlot.HAND);
			im.addAttributeModifier(Attribute.GENERIC_FLYING_SPEED, mod);
		}
		// apply the color format
		ic.formatList(lore);
		// set lore on itemmeta
		im.setLore(lore);
		item.setItemMeta((ItemMeta) dm);
		p.sendMessage("--------END OF COM--------");
		p2.getInventory().addItem(item);

		p.sendMessage(ic.format(ic.msg_config.getString("Messages.giveitem")));
		return true;
	}

}
