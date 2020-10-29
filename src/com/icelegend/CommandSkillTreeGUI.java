package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSkillTreeGUI implements CommandExecutor {
	private IceLegend ic;
	public CommandSkillTreeGUI(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender.hasPermission("IceLegend.command.skilltreegui")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.Command.skilltreegui")));
		}
		return false;
	}

}
