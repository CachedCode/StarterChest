package net.kryptonox.starterchest;

import org.bukkit.plugin.java.JavaPlugin;

import net.kryptonox.starterchest.event.PluginPlayerJoinEvent;

public class StarterChest extends JavaPlugin {
	
	public void onEnable() {
		// Initiate All Classes Here
		new PluginPlayerJoinEvent(this);
	}

}
