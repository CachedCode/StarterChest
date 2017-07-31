package net.kryptonox.starterchest.chest;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.kryptonox.starterchest.StarterChest;

public class StartingChest {

	String name;
	Player player;
	private static List<ItemStack> items = new ArrayList<ItemStack>(); 
	
	StarterChest plugin;
	public StartingChest(StarterChest plugin) {
		this.plugin = plugin;
	}
	
	public StartingChest(String name, Player player) {
		this.name = name;
		this.player = player;
		
		create(name, player);
	}
	
	private void create(String name, Player player) {
		Location playerLocation = player.getLocation();
		Block b = playerLocation.getBlock();
		
		b.setType(Material.CHEST);
			Chest c = (Chest) b.getState();
			Inventory i = c.getInventory();
			
			c.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
			
			if(!items.isEmpty()) {
				for(int x = 0; x < items.size(); x++) {
					ItemStack item = items.get(x);
					i.setItem(x, item);
				}
			} else {
				i.setItem(0, new ItemStack(Material.AIR));
				return;
			}
	}
	
	public static void addItem(ItemStack itemStack) {
		// You could make custom Items but won't go that far.
		try {
		items.add(itemStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeItem(ItemStack itemStack) {
		try {
			if(items.contains(itemStack)) {
				items.remove(itemStack);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
