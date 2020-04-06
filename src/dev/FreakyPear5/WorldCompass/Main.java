package dev.FreakyPear5.WorldCompass;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import dev.FreakyPear5.WorldCompass.Commands.BroadcastCommand;
import dev.FreakyPear5.WorldCompass.Commands.DuelCommand;
import dev.FreakyPear5.WorldCompass.Commands.EventCommand;
import dev.FreakyPear5.WorldCompass.Commands.GrantCommand;
import dev.FreakyPear5.WorldCompass.Commands.PlayerHelpCommand;
import dev.FreakyPear5.WorldCompass.Commands.SayAllCommand;
import dev.FreakyPear5.WorldCompass.Commands.SocialCommand;
import dev.FreakyPear5.WorldCompass.Commands.VoteCommand;
import net.minecraft.server.v1_8_R3.EntityEnderDragon;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;

public class Main extends JavaPlugin implements Listener {
	
	// STATICS //
	public static Inventory worldsel = Bukkit.createInventory(null, 9, "World Selection Menu");
	public static Inventory staffworld = Bukkit.createInventory(null, 9, "Staff World Selection Menu");
	
	// ITEMS FOR INV //
	static {
		// KITPVP //
		ItemStack kitpvp = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta mkp = kitpvp.getItemMeta();
		mkp.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKit&4&lPvP"));
		kitpvp.setItemMeta(mkp);
		worldsel.setItem(4, kitpvp);
		staffworld.setItem(4, kitpvp);
		// SKYBLOCK //
		ItemStack skyblock = new ItemStack(Material.GRASS);
		ItemMeta msb = skyblock.getItemMeta();
		msb.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSky&2&lBlock"));
		skyblock.setItemMeta(msb);
		//worldsel.setItem(0, skyblock);
		staffworld.setItem(0, skyblock);
		// TOURNAMENT //
		ItemStack tournament = new ItemStack(Material.ANVIL);
		ItemMeta mtt = tournament.getItemMeta();
		mtt.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lTournaments"));
		tournament.setItemMeta(mtt);
		worldsel.setItem(8, tournament);
		staffworld.setItem(8, tournament);
		// DUELS //
		ItemStack duels = new ItemStack(Material.BOW);
		ItemMeta mds = duels.getItemMeta();
		mds.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lDuels"));
		duels.setItemMeta(mds);
		worldsel.setItem(0, duels);
		staffworld.setItem(1, duels);
		// SUMO MAPS //
		ItemStack sumo = new ItemStack(Material.STONE_SWORD);
		ItemMeta mso = sumo.getItemMeta();
		mso.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lSumo Maps"));
		sumo.setItemMeta(mso);
		staffworld.setItem(7, sumo);
	}
	
	
	// ENABLE / DISABLE //
	@Override
	public void onEnable() {
		// CONFIGS //
		this.saveConfig();
		// CMDS //
		this.getCommand("freakyevent").setExecutor(new EventCommand());
		this.getCommand("broadcast").setExecutor(new BroadcastCommand());
		this.getCommand("grant").setExecutor(new GrantCommand());
		this.getCommand("social").setExecutor(new SocialCommand());
		this.getCommand("playerhelp").setExecutor(new PlayerHelpCommand());
		this.getCommand("duel").setExecutor(new DuelCommand());
		this.getCommand("sayall").setExecutor(new SayAllCommand());
		this.getCommand("vote").setExecutor(new VoteCommand());
		//this.getCommand("spawn").setExecutor(new SpawnCommand());
		// EVENTS //
		getServer().getPluginManager().registerEvents(this, this);
		// BOOT MESSAGES //
		System.out.println("[GrandKitCORE] Enabling");
		System.out.println("[GrandKitCORE] Plugin built by FreakyPear5");
		System.out.println("[GrandKitCORE] Copyright 2020 TRC FreakyPear5©");
	}
	public void onDisable() {
		System.out.println("[GrandKitCORE] Disabling");
		System.out.println("[GrandKitCORE] Plugin built by FreakyPear5");
		System.out.println("[GrandKitCORE] Copyright 2020 TRC FreakyPear5©");
	}
	// EVENTS //
	@EventHandler
	public void rightClick(PlayerInteractEvent event) {
		Action action = event.getAction();
		Player player = event.getPlayer();
		if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "World Selection Menu") && player.getItemInHand().getType().equals(Material.SLIME_BALL)) {
				if (player.hasPermission("gkc.compass.staff") || player.isOp()) {
					player.openInventory(staffworld);
				}
				else {
					player.openInventory(worldsel);
				}
			}
		}
	}
	@EventHandler
	public void invClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
		if (inventory.getName().equals(worldsel.getName()) || inventory.getName().equals(staffworld.getName())) {
			if (clicked.getType() == Material.DIAMOND_SWORD) {
					event.setCancelled(true);
					Location loc = new Location(getServer().getWorld("kitpvp"), 1.5, 54, 50.5);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Compass >> &aSending you to &lKitPvP&a!"));
					player.teleport(loc);
			}
			else if (clicked.getType() == Material.GRASS) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Slimeball >> &aSending you to &lSkyBlock&a!"));
				Location sbloc = new Location(Bukkit.getWorld("skyblock"), -346.5, 243, 55.5);
				player.teleport(sbloc);
			}
			else if (clicked.getType() == Material.ANVIL) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Slimeball >> &aSending you to &lTournaments&a!"));
				Bukkit.getServer().dispatchCommand(getServer().getConsoleSender(), "warp tournament " + player.getName());
			}
			else if (clicked.getType() == Material.BOW) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Slimeball >> &aSending you to &lDuels&a!"));
				Bukkit.getServer().dispatchCommand(getServer().getConsoleSender(), "mvtp " + player.getName() + " duels");
			}
			else if (clicked.getType() == Material.STONE_SWORD) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Slimeball >> &aSending you to &lSumo Maps&a!"));
				Bukkit.getServer().dispatchCommand(getServer().getConsoleSender(), "mvtp " + player.getName() + " sumo");
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Location hubloc = new Location(getServer().getWorld("build"), 801.5, 178, -863.5);
		player.teleport(hubloc);
		if (player.getLocation().getWorld().getName().equalsIgnoreCase("build")) {
			if (player.getInventory().contains(Material.COMPASS)) {
				player.getInventory().remove(Material.COMPASS);
			}
			if (!(player.getInventory().contains(Material.SLIME_BALL))) {
				ItemStack compass = new ItemStack(Material.SLIME_BALL, 1);
				ItemMeta cmeta = compass.getItemMeta();
				cmeta.setDisplayName(ChatColor.RED + "World Selection Menu");
				compass.setItemMeta(cmeta);
				player.getInventory().setItem(4, compass);
			}
		}
		if (this.getConfig().getString("JoinTitle").equalsIgnoreCase("true")) {
			player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&b&lWelcome, " + player.getDisplayName()), ChatColor.GREEN + "Enjoy your time here on GrandKit");
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lWelcome, " + player.getDisplayName() + "!\nDon't forget to vote using /vote\nand you can join our Discord server with /info to keep up with the latest news!"));
		}
		
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		//Player player  = event.getPlayer();
		//if (this.getConfig().getString("PerWorldChat").equalsIgnoreCase("true")) {
			//String chatloc = player.getLocation().getWorld().getName();
			//String message = event.getMessage();
			//event.setCancelled(true);
			//for (Player online : Bukkit.getOnlinePlayers()) {
				//if (online.getLocation().getWorld().getName().equalsIgnoreCase(chatloc)) {
					//online.sendMessage(message);
				//}
			//}
		//}
		// MAKE ANTISWEAR //
	}
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if (event.getItemDrop().getName().equalsIgnoreCase(ChatColor.RED + "World Selection Menu")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You aren't allowed to drop the selection menu!");
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player killed = event.getEntity();
		Player killer = event.getEntity().getKiller();
		if (killer.getLocation().getWorld().getName().equalsIgnoreCase("duels")) {
			Location duelspawn = new Location(killer.getWorld(), 1.5, 3.5, 0.5);
			killer.teleport(duelspawn);
			killed.teleport(duelspawn);
			killer.getInventory().clear();
			killed.getInventory().clear();
			Bukkit.getServer().dispatchCommand(getServer().getConsoleSender(), "eco give " + killer.getName() + " 250");
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&b&lGrandKit Duels >> &a&l" + killer.getName() + "&a has won the Duel against &l" + killed.getName() + "&a!"));
			killer.teleport(duelspawn);
			killed.teleport(duelspawn);
			killer.getInventory().clear();
			killed.getInventory().clear();
			event.getDrops().clear();
		}
		else {
			if (killed.getLocation().getWorld().getName().equalsIgnoreCase("kitpvp") && killer.getLocation().getWorld().getName().equalsIgnoreCase("kitpvp")) {
				killer.setTotalExperience((int) (killer.getExp() + 8.5));
			}
		}
	}
	@SuppressWarnings("unused")
	private void bossBar(Player player) {
		Location ploc = player.getLocation();
		EntityEnderDragon dragon = new EntityEnderDragon((net.minecraft.server.v1_8_R3.World) player.getLocation().getWorld());
		dragon.setLocation(ploc.getX() - 30, ploc.getY() - 100, ploc.getZ(), 0, 0);
        dragon.setCustomName(ChatColor.translateAlternateColorCodes('&', "&CWelcome to &lGrandKit&c, " + player.getName()));
        dragon.setInvisible(true);
        Packet<?> packet = new PacketPlayOutSpawnEntityLiving(dragon);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

	}

}
