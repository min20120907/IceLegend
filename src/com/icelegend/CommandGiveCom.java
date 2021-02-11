package com.icelegend;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import org.jetbrains.annotations.NotNull;

public class CommandGiveCom implements CommandExecutor {
	final IceLegend ic;

	public CommandGiveCom(IceLegend ic) {
		this.ic = ic;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Player p2 = Bukkit.getPlayer(args[0]);
		String destItem = args[1];
		if (ic.components_yml_config.getString(destItem) == null) {
			p.sendMessage(ic.format("Target component is not found"));
			return true;
		}

		List<String> lore = ic.components_yml_config.getStringList(destItem + ".Lore");

		ItemStack item = new ItemStack(Objects.requireNonNull(Material.matchMaterial(Objects.requireNonNull(ic.components_yml_config.getString(destItem + ".Material")))));
		p.sendMessage(item.toString());
		p.sendMessage("args1: " + args[1]);

		ItemMeta im = item.getItemMeta();
		assert im != null;
		im.setCustomModelData(Integer.parseInt(Objects.requireNonNull(ic.components_yml_config.getString(destItem + ".Data"))));
		Damageable dm = (Damageable) im;
		dm.setDamage(Integer.parseInt(Objects.requireNonNull(ic.components_yml_config.getString(destItem + ".Durability"))));
		List<Map<?, ?>> attr_list = ic.components_yml_config.getMapList(destItem + ".Attribute");
		for (Map<?, ?> m : attr_list) {

			AttributeModifier mod = new AttributeModifier(UUID.randomUUID(), (String) m.keySet().toArray()[0],
					Double.parseDouble(String.valueOf(m.get(m.keySet().toArray()[0]))), Operation.ADD_NUMBER, EquipmentSlot.HAND);
			im.addAttributeModifier(Attribute.GENERIC_FLYING_SPEED, mod);
		}
		// apply the color format
		ic.formatList(lore);
		// set lore on itemmeta
		im.setLore(lore);
		item.setItemMeta((ItemMeta) dm);
		p.sendMessage("--------END OF COM--------");
		assert p2 != null;
		p2.getInventory().addItem(item);

		p.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.giveitem"))));
		return true;
	}
}
