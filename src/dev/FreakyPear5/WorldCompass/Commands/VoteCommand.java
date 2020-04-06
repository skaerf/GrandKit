package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Votes >> &aYou can vote using these links:"
				+ "\nhttps://minecraft-mp.com/server/244531/vote"
				+ "\nhttps://www.minecraft-servers-list.org/details/Fogzyy"
				+ "\nhttps://minecraft-server-list.com/server/452307"
				+ "\nhttps://topg.org/Minecraft/server-593858"
				+ "\nhttps://minecraftservers.org/server/573620"));
		return true;
	}

}
