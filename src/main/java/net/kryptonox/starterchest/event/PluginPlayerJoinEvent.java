package net.kryptonox.starterchest.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.kryptonox.starterchest.StarterChest;
import net.kryptonox.starterchest.chest.StartingChest;

public class PluginPlayerJoinEvent implements Listener {
	
	StarterChest plugin;
	public PluginPlayerJoinEvent(StarterChest plugin) {
		this.plugin = plugin;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(p instanceof Player) {
			StartingChest.addItem(new ItemStack(Material.GOLD_INGOT));
			new StartingChest("&cStarter Chest", p);
		} else {
			return;
		}
	}

}
