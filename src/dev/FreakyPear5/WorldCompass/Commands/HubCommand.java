package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		String location = player.getLocation().getWorld().getName();
		if (location.equalsIgnoreCase("kitpvp")) {
			if (player.getLocation().getY() < 45.7) {
				player.sendMessage(ChatColor.RED + "You have to be at the KitPvP Spawn point to use /hub!");
			}
			else {
				Location hubloc = new Location(Bukkit.getServer().getWorld("build"), 801.5, 178, -863.5);
				player.teleport(hubloc);
			}
		}
		else {
			Location hubloc = new Location(Bukkit.getServer().getWorld("build"), 801.5, 178, -863.5);
			player.teleport(hubloc);
		}
		return true;
	}

}
