package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandItemSkinCombineGUI implements CommandExecutor {
	IceLegend ic;
	public CommandItemSkinCombineGUI(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender.hasPermission("IceLegend.command.itemskincombinegui")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.itemskincombinegui")));
		}
		
		return true;
	}

}
