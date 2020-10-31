package com.icelegend;

import java.text.DecimalFormat;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandCombineSkillGUI implements CommandExecutor {
	IceLegend ic;
	public CommandCombineSkillGUI(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if(sender.hasPermission("IceLegend.command.combineskillgui")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.combineskillgui")));
			
		}
		return true;
	}

}
