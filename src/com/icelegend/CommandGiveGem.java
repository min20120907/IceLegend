package com.icelegend;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandGiveGem implements CommandExecutor {
	final IceLegend ic;
	public CommandGiveGem(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Player p2 = Bukkit.getPlayer(args[0]);
		String destItem = args[1];
		int count = 1;
		ItemStack i = new ItemStack(Material.AIR);
		p.sendMessage("Comlist:");

		for (String com : ic.ComponentType) {

			while (ic.item_mat_config.getString("Gem." + com + "." + count + ".Material") != null) {

				ItemStack item = new ItemStack(Objects.requireNonNull(Material
						.matchMaterial(Objects.requireNonNull(ic.item_mat_config.getString("Gem." + com + "." + count + ".Material")))));
				p.sendMessage(item.toString());
				p.sendMessage(com);
				p.sendMessage("args1: "+args[1]);
				if (Integer.parseInt(destItem)==count) {

					ItemMeta im = item.getItemMeta();
					assert im != null;
					im.setDisplayName(ic.gem_config.getString("Gem." + com + "." + count + ".Name"));
					// im.setUnbreakable(Boolean.parseBoolean(ic.item_mat_config
					//		.getString(ic.item_mat_config.getString("Type." + com + "." + count + ".Unbreakable"))));
					im.setCustomModelData(
							Integer.parseInt(Objects.requireNonNull(ic.gem_config.getString("Gem." + com + "." + count + ".Data"))));
					im.setLore(ic.formatList(ic.gem_config.getStringList("Gem." + com + "." + count + ".Lore")));
					Damageable dm = (Damageable) im;
					dm.setDamage(Integer
							.parseInt(Objects.requireNonNull(ic.gem_config.getString("Gem." + com + "." + count + ".Durability"))));
					item.setItemMeta((ItemMeta) dm);
					i = item;
					break;
				}
				count++;
			}
		}
		p.sendMessage("--------END OF COM--------");
		if (!i.equals(new ItemStack(Material.AIR))) {
			assert p2 != null;
			p2.getInventory().addItem(i);
		}
		else
			p.sendMessage("NO ITEM");
		p.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.giveitem"))));
		return true;
	}
}
