package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		String playerloc = player.getLocation().getWorld().getName();
		if (playerloc.equalsIgnoreCase("build")) {
			Location loc = new Location(Bukkit.getServer().getWorld("build"), 801.5, 178, -863.5);
			player.teleport(loc);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Spawn >> &aTeleporting you to spawn!"));
		}
		else if (playerloc.equalsIgnoreCase("kitpvp")) {
			Location loc = new Location(Bukkit.getServer().getWorld("kitpvp"), 1.5, 54, 50.5);
			player.teleport(loc);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Spawn >> &aTeleporting you to spawn!"));
		}
		else if (playerloc.equalsIgnoreCase("duels")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mvtp " + player.getName() + " duels");
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Spawn >> &aTeleporting you to spawn!"));
		}
		else if (playerloc.equalsIgnoreCase("skyblock") || playerloc.equalsIgnoreCase("askyblock") || playerloc.equalsIgnoreCase("askyblock_nether")) {
			Location loc = new Location(Bukkit.getWorld("skyblock"), -346.5, 243, 55.5);
			player.teleport(loc);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Spawn >> &aTeleporting you to spawn!"));
		}
		return true;
	}

}
