package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class SayAllCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("gkc.sayall") || player.isOp()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; i++){
				sb.append(args[i]).append(" ");
			}
			String message = sb.toString().trim();
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.chat(message);
			}
		}
		else {
			player.sendMessage(ChatColor.RED +"You don't have permission!");
		}
		return true;
	}

}
