package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings("unused")
public class CommandIceLegend extends CommandBase<IceLegend> {

	public CommandIceLegend(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	private final IceLegend ic = getPlugin();

	// String prefix = msg_config.getString("prefix");

	@Override
	public boolean runCommand(@NotNull CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("");
		if (sender instanceof Player) {
			Player player = (Player) sender;

			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.Command.help"))));

		} else {
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.playernotdetected"))));
		}
		return true;
	}

}
