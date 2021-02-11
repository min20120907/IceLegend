package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandCombineSkillGUI implements CommandExecutor {
	final IceLegend ic;
	public CommandCombineSkillGUI(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if(sender.hasPermission("IceLegend.command.combineskillgui")) {
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.Command.combineskillgui"))));
			
		}
		return true;
	}

}
