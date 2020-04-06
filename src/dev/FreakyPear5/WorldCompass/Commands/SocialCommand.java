package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SocialCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Social >> &aThese are our social connections:\n"
				+ "&aDiscord: &lhttps://discord.gg/dvBAkf3\n"
				+ "&aTwitter: &lhttps://twitter.com/GrandkitM\n"
				+ "&aAs we get more, we will add them here!"));
		return true;
	}

}
