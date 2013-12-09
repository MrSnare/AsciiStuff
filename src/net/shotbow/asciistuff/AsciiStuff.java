package net.shotbow.asciistuff;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
@author MrSnare
 */
public class AsciiStuff extends JavaPlugin{

	private Logger log;
	
	public void onEnable(){
		log = this.getLogger();
		log.info("AsciiStuff enabled!");
	}
	
	public void onDisable(){
		log.info("AsciiStuff disabled!");
	}
	
	public String codeU2592(ChatColor colour){
		return colour + "\u2592";
	}
	
	public String skinLine(ChatColor colour, ChatColor colour1,ChatColor colour2,ChatColor colour3,
			ChatColor colour4,ChatColor colour5,ChatColor colour6,ChatColor colour7){
		return codeU2592(colour) + codeU2592(colour1) + codeU2592(colour2) + codeU2592(colour3) + 
			codeU2592(colour4) + codeU2592(colour5) + codeU2592(colour6) + codeU2592(colour7);
	}
	
	public String skinLine(String colour, String colour1,String colour2,String colour3,
			String colour4,String colour5,String colour6,String colour7){
		return codeU2592(ChatColor.valueOf(colour)) + codeU2592(ChatColor.valueOf(colour1)) + codeU2592(ChatColor.valueOf(colour2)) + codeU2592(ChatColor.valueOf(colour3)) + 
			codeU2592(ChatColor.valueOf(colour4)) + codeU2592(ChatColor.valueOf(colour5)) + codeU2592(ChatColor.valueOf(colour6)) + codeU2592(ChatColor.valueOf(colour7));
	}
}
