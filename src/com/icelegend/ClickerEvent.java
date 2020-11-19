package com.icelegend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class ClickerEvent implements Listener {
	IceLegend ic;

	public ClickerEvent(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	private static HashSet<Integer> c_slots = new HashSet<Integer>();

	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		Inventory inv = event.getInventory();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		boolean opened = inv.equals(open);

		// Custom Model Data:
		// 0 -> takable
		if (event.getView().getTitle().equalsIgnoreCase(ic.format(ic.item_com_config.getString("Title")))
				&& inv.equals(open)) {
			opened = true;
			if (event.isShiftClick() || event.isRightClick() || event.isLeftClick()) {
				// player.sendMessage(String.valueOf(item.getItemMeta().getCustomModelData()));
				try {
					player.sendMessage(c_slots.toString());
					player.sendMessage(item.toString());
					player.sendMessage(String.valueOf(c_slots.contains(event.getSlot())));
					if (item.hasItemMeta()) {
						if (ic.components.contains(item) || ic.components_meta.contains(item.getItemMeta())) {

						} else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a右鍵點擊進行合成")) {

						} else if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§a請放置零件於此處")) {
							inv.setItem(event.getSlot(), event.getCursor());
							event.setCurrentItem(null);
							c_slots.add(event.getSlot());
						} else {
							event.setCancelled(true);
						}
					} else if (item.getType().equals(Material.RED_STAINED_GLASS_PANE) && event.isLeftClick()) {
						player.closeInventory();
					} else if (c_slots.contains(event.getSlot())) {

					} else {
						event.setCancelled(true);
					}
				} catch (NullPointerException e) {
					if (!c_slots.contains(event.getSlot())) {
						event.setCancelled(true);
					}

					player.sendMessage("NULL");
				}

			}
		}
	}

	public int getItemLocation(Inventory inv, ItemStack item) {
		for (int i = 0; i < inv.getSize(); i++)
			if (inv.getItem(i).equals(item))
				return i;

		return -1;
	}

}
