package com.icelegend;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandGetItem implements CommandExecutor {
	final IceLegend ic;
	public CommandGetItem(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
		// TODO Auto-generated method stub
		Player p = (Player) sender;
		Bukkit.getPlayer(args[0]);
		p.sendMessage(Objects.requireNonNull(ic.msg_config.getString("Messages.getitem")));
		return true;
	}

}
