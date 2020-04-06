package dev.FreakyPear5.WorldCompass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DuelCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation" )
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aUsage: &l/duel <player> <map>"));
		}
		else {
			Player request = Bukkit.getPlayerExact(args[0]);
			if (!(request == null)) {
				if (!(request.getLocation().getWorld().getName().equalsIgnoreCase("duels"))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aThat player isn't in the Duels world! Ask them to teleport, then try again."));
				}
				else if (!(player.getLocation().getWorld().getName().equalsIgnoreCase("duels"))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aYou aren't in the Duels world! Teleport, then try again."));
				}
				else {
						// ARENAS //
						if (args.length == 1) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aPlease specify a map! &l/duel <player> <map>"));
						}
						else if (args[1].equalsIgnoreCase("default")) {
							Location defaultplayer = new Location(player.getWorld(), -86.5, 4, 88.5);
							Location defaultrequest = new Location(request.getWorld(), -86.5, 4, 29.5);
							player.teleport(defaultplayer);
							request.teleport(defaultrequest);
							player.getInventory().clear();
							request.getInventory().clear();
							player.setGameMode(GameMode.SURVIVAL);
							request.setGameMode(GameMode.SURVIVAL);
							// PLAYER DEFAULT KIT //
							ItemStack[] armor = new ItemStack[4];
							armor[3] = new ItemStack(Material.IRON_HELMET);
							armor[2] = new ItemStack(Material.IRON_CHESTPLATE);
							armor[1] = new ItemStack(Material.IRON_LEGGINGS);
							armor[0] = new ItemStack(Material.IRON_BOOTS);
							ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 4);
							ItemStack ironsword = new ItemStack(Material.IRON_SWORD, 1);
							ItemStack bow = new ItemStack(Material.BOW, 1);
							ItemStack arrows = new ItemStack(Material.ARROW, 32);
							player.getInventory().setItem(1, bow);
							player.getInventory().setItem(8, arrows);
							player.getInventory().setItem(0, ironsword);
							player.getInventory().setItem(2, gapples);
							player.getInventory().setArmorContents(armor);
							// REQUEST DEFAULT KIT //
							request.getInventory().setItem(1, bow);
							request.getInventory().setItem(8, arrows);
							request.getInventory().setItem(0, ironsword);
							request.getInventory().setItem(2, gapples);
							request.getInventory().setArmorContents(armor);
							player.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
							request.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
						}
						else if (args[1].equalsIgnoreCase("vip")) {
							if (!(player.hasPermission("gkc.arena.vip")) || !(player.isOp())) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aYou don't have permission to use the &lVIP &aarena!"));
							}
							else if (player.hasPermission("gkc.arena.vip") || player.isOp()){
								Location defaultplayer = new Location(player.getWorld(), -61.5, 4, -28.5);
								Location defaultrequest = new Location(request.getWorld(), -61.5, 4, -90.5);
								player.teleport(defaultplayer);
								request.teleport(defaultrequest);
								player.getInventory().clear();
								request.getInventory().clear();
								player.setGameMode(GameMode.SURVIVAL);
								request.setGameMode(GameMode.SURVIVAL);
								// PLAYER DEFAULT KIT //
								ItemStack[] armor = new ItemStack[4];
								armor[3] = new ItemStack(Material.IRON_HELMET);
								armor[3].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								armor[2] = new ItemStack(Material.IRON_CHESTPLATE);
								armor[2].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								armor[1] = new ItemStack(Material.IRON_LEGGINGS);
								armor[1].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								armor[0] = new ItemStack(Material.IRON_BOOTS);
								armor[0].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 8);
								ItemStack ironsword = new ItemStack(Material.IRON_SWORD, 1);
								ironsword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
								ItemStack bow = new ItemStack(Material.BOW, 1);
								bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
								ItemStack arrows = new ItemStack(Material.ARROW, 32);
								player.getInventory().setItem(1, bow);
								player.getInventory().setItem(8, arrows);
								player.getInventory().setItem(0, ironsword);
								player.getInventory().setItem(2, gapples);
								player.getInventory().setArmorContents(armor);
								// REQUEST DEFAULT KIT //
								request.getInventory().setItem(1, bow);
								request.getInventory().setItem(8, arrows);
								request.getInventory().setItem(0, ironsword);
								request.getInventory().setItem(2, gapples);
								request.getInventory().setArmorContents(armor);
								player.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
								request.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
							}
						}
						else if (args[1].equalsIgnoreCase("sumo")) {
							if (player.hasPermission("gkc.sumo") || player.isOp()) {
								if (args.length == 2) {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aUsage: &l/duel <player> sumo <map>"));
								}
								else {
									
								}
							}
							else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aYou don't have permission to use the &lSumo &aarenas! You can unlock access from a &lGrandKit &acrate."));
							}
						}
						else if (args[1].equalsIgnoreCase("nether")) {
							if (!(player.hasPermission("gkc.arena.nether"))) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aYou don't have permission to use the &lNether &aarena! You can unlock access from a &lFreaky &acrate."));
							}
							else if (player.hasPermission("gkc.arena.nether") || player.isOp()){
								Location defaultplayer = new Location(player.getWorld(), -239.5, 5, -42.5);
								Location defaultrequest = new Location(request.getWorld(), -239.5, 5, -103.5);
								player.teleport(defaultplayer);
								request.teleport(defaultrequest);
								player.getInventory().clear();
								request.getInventory().clear();
								player.setGameMode(GameMode.SURVIVAL);
								request.setGameMode(GameMode.SURVIVAL);
								// PLAYER DEFAULT KIT //
								ItemStack[] armor = new ItemStack[4];
								armor[3] = new ItemStack(Material.DIAMOND_HELMET);
								armor[3].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
								armor[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
								armor[2].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
								armor[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
								armor[1].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
								armor[0] = new ItemStack(Material.DIAMOND_BOOTS);
								armor[0].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
								ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 24);
								ItemStack notches = new ItemStack(Material.GOLDEN_APPLE, 2, (short)1);
								ItemStack ironsword = new ItemStack(Material.DIAMOND_SWORD, 1);
								ItemStack potion = new ItemStack(Material.POTION, 1);
								potion.setDurability((short) 16393);
								ironsword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
								ItemStack bow = new ItemStack(Material.BOW, 1);
								bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
								ItemStack arrows = new ItemStack(Material.ARROW, 64);
								player.getInventory().setItem(1, bow);
								player.getInventory().setItem(8, arrows);
								player.getInventory().setItem(0, ironsword);
								player.getInventory().setItem(2, gapples);
								player.getInventory().setItem(3, notches);
								player.getInventory().setItem(4, potion);
								player.getInventory().setArmorContents(armor);
								// REQUEST DEFAULT KIT //
								request.getInventory().setItem(1, bow);
								request.getInventory().setItem(8, arrows);
								request.getInventory().setItem(0, ironsword);
								request.getInventory().setItem(2, gapples);
								request.getInventory().setItem(3, notches);
								request.getInventory().setItem(4, potion);
								request.getInventory().setArmorContents(armor);
								player.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
								request.sendTitle(ChatColor.GREEN + "GO!", ChatColor.RED + "Good luck, " + player.getName() + "!");
							}
						}
			
			}
				return true;
			}
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &aThat player isn't online!"));
			}
	}
		return true;
	}

}
