package com.icelegend;

import java.util.HashSet;
import java.util.Objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class ClickerEvent implements Listener {
	final IceLegend ic;

	public ClickerEvent(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	private static final HashSet<Integer> c_slots = new HashSet<>();

	@EventHandler
	public void InvenClick(@NotNull InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		Inventory inv = event.getInventory();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		boolean opened = inv.equals(open);

		// Custom Model Data:
		// 0 -> takable
		if (event.getView().getTitle().equalsIgnoreCase(ic.format(Objects.requireNonNull(ic.item_com_config.getString("Title"))))
				&& inv.equals(open)) {
			opened = true;
			if (event.isShiftClick() || event.isRightClick() || event.isLeftClick()) {
				// player.sendMessage(String.valueOf(item.getItemMeta().getCustomModelData()));
				try {
					player.sendMessage(c_slots.toString());
					assert item != null;
					player.sendMessage(item.toString());
					player.sendMessage(String.valueOf(c_slots.contains(event.getSlot())));
					if (item.hasItemMeta()) {
						if (ic.components.contains(item) || ic.components_meta.contains(item.getItemMeta())) {

						} else if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equalsIgnoreCase("§a右鍵點擊進行合成")) {

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

	public int getItemLocation(@NotNull Inventory inv, ItemStack item) {
		for (int i = 0; i < inv.getSize(); i++) {
			ItemStack iterating = inv.getItem(i);
			if (iterating == null) continue;
			if (iterating.equals(item)) return i;
		}

		return -1;
	}

}
