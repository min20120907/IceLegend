package com.icelegend;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SubCommandHelp extends CommandBase<IceLegend> {
	IceLegend ic = getPlugin();
	public SubCommandHelp(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if (sender instanceof Player) {
		Player player = (Player) sender;
		
		if (player.hasPermission("IceLegend.command.help")) {
			try {
				List<String> msg = (List<String>) ic.help_config.getList("Page" + args[0] + ".messages");
				for (int j = 0; j < msg.size(); j++)
					player.sendMessage(ic.format(msg.get(j)));
			}catch(ArrayIndexOutOfBoundsException e) {
				List<String> msg = (List<String>) ic.help_config.getList("Page1.messages");
				for (int j = 0; j < msg.size(); j++)
					player.sendMessage(ic.format(msg.get(j)));
			}catch(NullPointerException e) {
				player.sendMessage(ic.format(ic.msg_config.getString("Messages.argumentsfailed")));
			}
		} else {
			player.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
		}
		}else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.playernotdetected")));
		}
		return true;
	}


}
