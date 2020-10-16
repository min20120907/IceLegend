package com.icelegend;

import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import de.themoep.inventorygui.DynamicGuiElement;
import de.themoep.inventorygui.GuiElement;
import de.themoep.inventorygui.GuiPageElement;
import de.themoep.inventorygui.GuiPageElement.PageAction;
import de.themoep.inventorygui.GuiStateElement;
import de.themoep.inventorygui.GuiStorageElement;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;

@SuppressWarnings("unused")
public class CommandIceLegend implements CommandExecutor {



	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            String[] guiSetup = {
                    "  s i z  ",
                    "  ggggg  ",
                    "  fpdnl  "
                };

			Player player = (Player) sender;
            // Here we need to give items to our player
        	InventoryGui gui = new InventoryGui(null, ((Player) sender).getInventory().getHolder(), "Test UI", guiSetup );
        	gui.addElement(new StaticGuiElement('s',
        	        new ItemStack(Material.REDSTONE),
        	        42, // Display a number as the item count
        	        click -> {
        	            if (click.getEvent().getWhoClicked().getName().equals("Redstone")) {
        	                click.getEvent().getWhoClicked().sendMessage(ChatColor.RED + "I am Redstone!");
        	                return true; // returning true will cancel the click event and stop taking the item
        	            }
        	            return false; // returning false will not cancel the initial click event to the gui
        	        },
        	        "You can add lines describing this element here!",
        	        "The first line is displayed as the displayname,",
        	        "any additional ones as the lore!",
        	        "Any text the ItemStack had will be overwritten."
        	));


        	sender.sendMessage("[冰晶傳說] 打開界面中 by "+player.getDisplayName());

        	gui.show(player);
            
        }else {
        	sender.sendMessage("[冰晶傳說] 請使用玩家身份使用此指令");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
