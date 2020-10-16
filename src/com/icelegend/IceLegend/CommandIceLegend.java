package com.icelegend.IceLegend;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.deanveloper.gui.GUIItem;
import com.deanveloper.gui.GUIWindow;

public class CommandIceLegend implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            //Player player = (Player) sender;
            // Here we need to give items to our player
            ItemStack redstone = new ItemStack(Material.REDSTONE);
            GUIWindow gui = new GUIWindow("Get some redstone!", 3);
            GUIItem guiItem = new GUIItem(redstone, event -> event.getWhoClicked().getInventory().addItem(redstone));
            
            gui.setItem(4, 1, guiItem);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
