package com.silentdarknessmc.hub;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.silentdarknessmc.hub.Firework.Commands;
import com.silentdarknessmc.hub.heal.HealFeedCommand;
import com.silentdarknessmc.hub.heal.Signs;

public class Main extends JavaPlugin {
	public void onEnable() {
		Player player = (Player) sender;
		
		final FileConfiguration config = this.getConfig();
		saveConfig();
		
		//Heal Signs Import
		Bukkit.getServer().getPluginManager().registerEvents(new Signs(), this);
		//Get Firework Command
		this.getCommand("shoot").setExecutor(new Commands());
		//Get Heal Command
		this.getCommand("heal").setExecutor(new HealFeedCommand());
		//Get Feed Command
		this.getCommand("feed").setExecutor(new HealFeedCommand());
	}
	
	public void onDisable() {
		
	}
}