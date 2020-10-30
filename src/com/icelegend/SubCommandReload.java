package com.icelegend;

import org.bukkit.Bukkit;
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
		if (sender.hasPermission("IceLegend.command.reload")) {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.disableplugin")));
			Bukkit.getPluginManager().disablePlugin(ic);
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.loadplugin")));
			Bukkit.getPluginManager().enablePlugin(ic);
		} else {
			sender.sendMessage(ic.format(ic.msg_config.getString("Messages.nopermission")));
		}
		return false;
	}

}
