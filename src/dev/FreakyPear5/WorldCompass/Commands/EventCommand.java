package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("gkc.event")) {
			if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c----&o&lGrandKit Events System----\n"
						+ "&b/event parkour [mvp,vip,+vip,++mvp,+++mvp] &f- &cBroadcasts about a /warp parkour event with a winnable kit in chat.\n"
						+ "&b/event sumo &f- &cHosts a Sumo event - COMING SOON!\n"
						+ "&bIf you have any more ideas for different events that I could add, please tell me (Freaky) as I do not. :P"));
			}
			else if (args[0].equalsIgnoreCase("parkour") || args[0].equalsIgnoreCase("pk")) {
					if (args.length == 1) {
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Events >> &aHosting a Parkour event at &l/warp parkour&a! Teleport now to participate!"));
					}
					else if (args.length == 2) {
						if (args[1].equalsIgnoreCase("mvp") || args[1].equalsIgnoreCase("+mvp") || args[1].equalsIgnoreCase("++mvp") || args[1].equalsIgnoreCase("+++mvp") || args[1].equalsIgnoreCase("vip") || args[1].equalsIgnoreCase("+vip")) {
							String kit = args[1];
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Events >> &aHosting a Parkour event at &l/warp parkour&a! Teleport now to have a chance to win the&l " + kit + "&a kit!"));
							}
						}
					}
				}
		}
		else {
			player.sendMessage(ChatColor.RED + "You don't have permission!");
		}
		return true;
	}
	
	

}
