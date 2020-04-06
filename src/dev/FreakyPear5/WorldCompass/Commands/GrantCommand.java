package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GrantCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0) {
			player.sendMessage((ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Groups >> &aUsage: &l/grant <player> <group>")));
		}
		else if (args.length == 2) {
			if (player.hasPermission("gkc.grant") && player.hasPermission("groupmanager.manuadd") || player.isOp()) {
			String name = args[0];
			String group = args[1];
			player.performCommand("manuadd " + name + " " + group);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Groups >> &aAdded &l" + name + "&a to group &l" + group));
			}
		}
		else {
			player.sendMessage(ChatColor.RED + "You don't have permission!");
		}
		return true;
	}
	
}
