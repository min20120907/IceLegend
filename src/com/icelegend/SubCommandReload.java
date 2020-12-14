package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SubCommandReload extends CommandBase<IceLegend> {
	IceLegend ic = getPlugin();
	public SubCommandReload(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if (sender.hasPermission("IceLegend.command.reload")) {
			ic.reloadConfig();
			ic.onEnable();
			
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.reload")));
		} else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
		}
		return true;
	}

}
