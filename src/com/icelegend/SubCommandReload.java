package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SubCommandReload extends CommandBase<IceLegend> {
	final IceLegend ic = getPlugin();
	public SubCommandReload(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean runCommand(@NotNull CommandSender sender, Command rootCommand, String label, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if (sender.hasPermission("IceLegend.command.reload")) {
			ic.reloadConfig();
			ic.onEnable();
			
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.reload"))));
		} else {
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.nopermission"))));
		}
		return true;
	}

}
