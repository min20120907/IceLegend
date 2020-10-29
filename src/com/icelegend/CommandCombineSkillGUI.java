package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCombineSkillGUI implements CommandExecutor {
	IceLegend ic;
	public CommandCombineSkillGUI(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender.hasPermission("IceLegend.command.combineskillgui")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.combineskillgui")));
		}
		return false;
	}

}
