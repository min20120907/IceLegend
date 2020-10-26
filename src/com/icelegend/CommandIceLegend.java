package com.icelegend;

import java.io.File;
import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;



@SuppressWarnings("unused")
public class CommandIceLegend implements CommandExecutor {
	private IceLegend ic;
	
	public CommandIceLegend(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	//String prefix = msg_config.getString("prefix");
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
			Player player = (Player) sender;
			
			/*Inventory gui = Bukkit.createInventory(null, 9,ChatColor.AQUA + "冰晶系統 "+ ChatColor.DARK_GRAY + ">> "+ config.getString("title") );
			

	        //This is where you create the item
	        ItemStack survival = new ItemStack (Material.DIRT);
	        ItemMeta survivalMeta = survival.getItemMeta();
	       
	       
	        //This is where you set the display name of the item
	        survival.setItemMeta(survivalMeta);
	       
	        //This is where you decide what slot the item goes into
	        gui.setItem(0, survival);
	        gui.setItem(1, survival);
	        gui.setItem(2, survival);
	        gui.setItem(3, survival);
	        gui.setItem(4, survival);
	        gui.setItem(5, survival);
	        gui.setItem(6, survival);
	        gui.setItem(6, survival);
	        gui.setItem(7, survival);
	        gui.setItem(8, survival);
	       
	        //This opens the inventory
	        player.openInventory(gui);*/
			
			//subcommand relaod
			if (cmd.getName().equalsIgnoreCase("reload")) {
				if(sender.hasPermission("IceLegend.command.reload")) {
					Plugin plugin = Bukkit.getPluginManager().getPlugin("IceLegend");
					Bukkit.getPluginManager().disablePlugin(plugin);
					Bukkit.getPluginManager().enablePlugin(plugin);
				}else {
					
				}
					
			}
			
        	sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Gemsuccess")));
 
            
        }else {
        	sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Gemfailed")));
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
