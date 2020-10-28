package com.icelegend;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ClickerEvent implements Listener{

	@EventHandler
	   public void InvenClick(InventoryClickEvent event) {
	       Player player = (Player) event.getWhoClicked();

	       Inventory inv = event.getInventory();
	       // Inventory open = event.getClickedInventory();
	       ItemStack item = event.getCurrentItem();

	       /*
	        * I don't think this can be null
	        *
	        * if(open == null) { return; }
	        *
	        *
	        */
	       

	       if (item == null)
	           return; // null check

	       if (event.isCancelled())
	           event.setCancelled(true); // Assuming you want to lock all items.
	       /*
	        * You can't get the itemmeta without knowing if it has one or not. So you check
	        * if it does.
	        */
	       if (!item.hasItemMeta())
	           return; // ItemMeta check
	       ItemMeta meta = item.getItemMeta(); // this is now safe to use.

	       if (!meta.hasDisplayName())
	           return; // displayname checlk
	       String name = meta.getDisplayName(); // now safe to use.

	       if (ChatColor.stripColor(name).equalsIgnoreCase("Health"))
	           player.setHealth(20);

	   }

}
