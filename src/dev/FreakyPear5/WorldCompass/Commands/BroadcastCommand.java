package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("gkc.broadcast")) {
			if (args[0].equalsIgnoreCase("staff")) {
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; i++){
					sb.append(args[i]).append(" ");
				}
				String staffArgs = sb.toString().trim();
				for (Player online : Bukkit.getOnlinePlayers()) {
					if (online.hasPermission("gkc.broadcast.staff") || online.isOp()) {
						online.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Staff Broadcast >> &a" + staffArgs));
					}
				}
			}
			else if (!(args[0].equalsIgnoreCase("staff"))) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++){
					sb.append(args[i]).append(" ");
				}
				String globalArgs = sb.toString().trim();
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Broadcast >> &a" + globalArgs));
				}
			}
			else if (args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit BCs >> &aUsage: /bc [staff] <broadcast>"));
			}
		}
		else {
			player.sendMessage(ChatColor.RED + "You don't have permission!");
		}
		return true;
	}

}
