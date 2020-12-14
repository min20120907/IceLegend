package com.icelegend;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClassOpen implements CommandExecutor {
	IceLegend ic;
	public CommandClassOpen(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Bukkit.getPlayer(args[0]);
		p.sendMessage(ic.msg_config.getString("Messages.openlockclasstoplayer"));
		
		return true;
	}
}
