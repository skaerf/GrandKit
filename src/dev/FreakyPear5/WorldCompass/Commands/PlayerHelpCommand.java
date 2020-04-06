package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerHelpCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Help >> &aChoose a gamemode in Hub using the slime ball!"
				+ "\nIn KitPvP, type /kit pvp to get started!"));
		return true;
	}

}
