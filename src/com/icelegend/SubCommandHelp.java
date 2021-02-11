package com.icelegend;

import java.util.List;
import java.util.Objects;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SubCommandHelp extends CommandBase<IceLegend> {
	final IceLegend ic = getPlugin();
	public SubCommandHelp(IceLegend plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean runCommand(@NotNull CommandSender sender, Command rootCommand, String label, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("");
		if (sender instanceof Player) {
		Player player = (Player) sender;
		
		if (player.hasPermission("IceLegend.command.help")) {
			try {
				List<String> msg = ic.help_config.getStringList("Page" + args[0] + ".messages");
				for (String s : Objects.requireNonNull(msg)) player.sendMessage(ic.format(s));
			}catch(ArrayIndexOutOfBoundsException e) {
				List<String> msg = ic.help_config.getStringList("Page1.messages");
				for (String s : Objects.requireNonNull(msg)) player.sendMessage(ic.format(s));
			}catch(NullPointerException e) {
				player.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.argumentsfailed"))));
			}
		} else {
			player.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.nopermission"))));
		}
		}else {
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.playernotdetected"))));
		}
		return true;
	}


}
