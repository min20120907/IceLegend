package com.icelegend;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
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

	       if(event.getAction() == InventoryAction.PICKUP_ALL
	    		   || event.getAction() == InventoryAction.DROP_ALL_CURSOR
	    		   || event.getAction() == InventoryAction.DROP_ALL_SLOT
	    		   || event.getAction() == InventoryAction.DROP_ONE_CURSOR
	    		   || event.getAction() == InventoryAction.DROP_ONE_SLOT
	    		   || event.getAction() == InventoryAction.CLONE_STACK
	    		   || event.getAction() == InventoryAction.COLLECT_TO_CURSOR
	    		   || event.getAction() == InventoryAction.HOTBAR_SWAP
	    		   || event.getAction() == InventoryAction.HOTBAR_MOVE_AND_READD
	    		   || event.getAction() == InventoryAction.PICKUP_HALF
	    		   || event.getAction() == InventoryAction.PICKUP_ONE
	    		   || event.getAction() == InventoryAction.PICKUP_SOME
	    		   )
	       {
	    	   event.setCancelled(true); // Assuming you want to lock all items.
	       }

	   }

}
