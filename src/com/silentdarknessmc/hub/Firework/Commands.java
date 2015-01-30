package com.silentdarknessmc.hub.Firework;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

import com.silentdarknessmc.hub.Main;

public class Commands implements CommandExecutor, Listener {
	Main plugin;
	 
	public void ConfigListener(Main instance) {
	plugin = instance;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			if(cmd.getLabel().equalsIgnoreCase("shoot"))
			{
				Player player = (Player) sender;
				
				if(player.hasPermission("firework.shoot"))
				{
					Firework firework = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
					
					FireworkMeta meta = firework.getFireworkMeta();
					
					FireworkEffect effect = FireworkEffect.builder()
							.flicker(true)
							.withColor(Color.RED)
							.withFade(Color.GREEN)
							.with(Type.CREEPER)
							.trail(true)
							.build();
					
					meta.addEffect(effect);
					meta.setPower(2);
					
					firework.setFireworkMeta(meta);
					
					sender.sendMessage(plugin.getConfig().getString("FireworkShootMessage"));
					sender.sendMessage("This Plugin Is By SDMC!");
					sender.sendMessage("Server IP: play.silentdarknessmc.com");
				}
				
				if(!player.hasPermission("firework.shoot"))
				{
					player.sendMessage(ChatColor.RED + "You Don\'t Have Permission To Use This Command!");
				}
			}
		}
		
		return false;
	}
}