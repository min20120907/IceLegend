package com.icelegend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class TabComEvent implements TabCompleter {
	IceLegend ic;

	public TabComEvent(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if (cmd.getName().equalsIgnoreCase("icelegend")) {
			if (args.length == 1) {

				List<String> subcmds = new ArrayList<>();
				subcmds.add("help");
				subcmds.add("reload");
				return subcmds;
			}
		}
		return null;
	}

}
