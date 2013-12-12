package net.shotbow.asciistuff;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
@author MrSnare
@author Drave
 */
public class AsciiStuff extends JavaPlugin{

	public static Logger log;
	public static BufferedImage steveSkin;
	
	public void onEnable(){
		log = this.getLogger();
		log.info("AsciiStuff enabled!");
		
		try {
			steveSkin = ImageIO.read(new URL("https://s3.amazonaws.com/MinecraftSkins/char.png"));
		} catch (IOException e) {
			log.severe("Could not get steve default face");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
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
	
	public String[] getPlayerFace(String p){
		BufferedImage face = getSkin(p);
		return getPlayerFace(face);	
	}

	private BufferedImage getSkin(String name){
		BufferedImage playerSkin = null;
		try {
			if(name.equalsIgnoreCase("steve")){
				return steveSkin;
			}else{
				URL url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + name + ".png");
				playerSkin = ImageIO.read(url);
			}                        
			return playerSkin;
		} catch (IOException e) {
			return steveSkin;
		}
	}
	
	private String[] getPlayerFace(BufferedImage face){
		String[] faceLines = new String[8];
		for(int j = 0; j < 8; j++){
			String chatString = "";
			for(int i = 0; i < 8; i++){
				Color c = new Color(face.getRGB(8 + i, 8 + j));
				chatString += codeU2592(getChatColorFromColor(c));
			}
			faceLines[j] = chatString;
		}
		return faceLines;
	}

	private ChatColor getChatColorFromColor(Color c){
		Integer r = c.getRed();
		Integer g = c.getGreen();
		Integer b = c.getBlue();

		float[] hsb = new float[3];
		Color.RGBtoHSB(r, g, b, hsb);

		float h = hsb[0]; // HUE
		float s = hsb[1]; // SATURATION
		float v = hsb[2]; // BRIGHTNESS

		if(s > 0.4 && v > 0.2 && h < 0.03333333333){
			return ChatColor.RED;
		}else if(s > 0.6 && v > 0.7 && h > 0.0333333333 && h < 0.1138888888){ // s > 0.4 && v > 0.5
			return ChatColor.GOLD;
		}else if(s > 0.4 && v > 0.14 && h > 0.019 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
			return ChatColor.DARK_RED;
		}else if(s > 0.6 && v > 0.09 && h > 0.019 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
			return ChatColor.DARK_RED;
		}else if(s > 0.3 && v > 0.5 && h > 0.02 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
			return ChatColor.DARK_RED;
		}else if(s < 0.41 && v < 0.2 && h > 0.01 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
			return ChatColor.BLACK;
		}else if(s > 0.4 && v < 0.35 && v > 0.2 && h > 0.969){
			return ChatColor.DARK_RED;
		}else if(s > 0.4 && v < 0.2 && v > 0.1 && h > 0.079999999 && h < 0.1222222){
			return ChatColor.DARK_RED;
		}else if(s > 0.8 && v < 0.15 && v > 0.05 && h > 0.079999999 && h < 0.1222222){
			return ChatColor.DARK_RED;
		}else if(s > 0.4 && v > 0.5 && h > 0.1138888888 && h < 0.1916666666){
			return ChatColor.YELLOW;
		}else if(s > 0.4 && v < 0.51 && v > 0.1 && h > 0.1138888888 && h < 0.1916666666){ // new
			return ChatColor.DARK_RED;
		}else if(s > 0.4 && v > 0.2 && v < 0.81 && h > 0.1916666666 && h < 0.3805555555){
			return ChatColor.DARK_GREEN;
		}else if(s > 0.4 && v > 0.5 && h > 0.1916666666 && h < 0.3805555555){
			return ChatColor.GREEN;
		}else if(s > 0.2 && v > 0.75 && h > 0.1916666666 && h < 0.3805555555){
			return ChatColor.GREEN;
		}else if(s > 0.2 && v > 0.8 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4 adjusted 3
			return ChatColor.BLUE;
		}else if(s > 0.1 && s < 0.21 && v > 0.9 && h > 0.3805555555 && h < 0.5194444444){ // new 3
			return ChatColor.BLUE;
		}else if(s > 0.4 && v < 0.81 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // adjusted 3
			return ChatColor.AQUA;
		}else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
			return ChatColor.AQUA;
		}else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
			return ChatColor.DARK_BLUE;
		}else if(s > 0.2 && s < 0.41 && v > 0.7 && h > 0.6027777777 && h < 0.6944444444){ // adjusted 3
			return ChatColor.BLUE;
		}else if(s > 0.114 && s < 0.2 && v > 0.6 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			return ChatColor.DARK_BLUE;
		}else if(s > 0.1 && s < 0.2 && v > 0.6 && v < 0.91 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			return ChatColor.BLUE;
		}else if(s > 0.114 && s < 0.2 && v > 0.9 && h > 0.6027777777 && h < 0.6944444444){ // new 3
			return ChatColor.DARK_BLUE;
		}else if(s > 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){
			return ChatColor.DARK_BLUE;
		}else if(s > 0.4 && v > 0.3 && h > 0.6944444444 && h < 0.8305555555){
			return ChatColor.DARK_PURPLE;
		}else if(s > 0.4 && v > 0.4 && h > 0.8305555555 && h < 0.8777777777){
			return ChatColor.LIGHT_PURPLE;
		}else if(s > 0.3 && v > 0.4 && h > 0.8777777777 && h < 0.9611111111){
			return ChatColor.LIGHT_PURPLE;
		}else if(s > 0.4 && v > 0.4 && h > 0.9361111111 && h < 1.0000000001){
			return ChatColor.RED;
		}else if(s < 0.11 && v > 0.9){
			return ChatColor.WHITE;
		}else if(s < 0.11 && v < 0.91 && v > 0.7){
			return ChatColor.WHITE;
		}else if(s < 0.11 && v < 0.71 && v > 0.2){
			return ChatColor.WHITE;
		}else if(s < 0.11 && v < 0.21){
			return ChatColor.BLACK;
		}else if(s < 0.3 && v < 0.3 && v > 0.1){
			return ChatColor.GRAY;
		}else if(s < 0.3 && v < 0.11){
			return ChatColor.BLACK;
		}else if(s < 0.7 && v < 0.6){
			return ChatColor.BLACK;
		}else if(v < 0.1){ // 0.05
			return ChatColor.BLACK;
		}else if(s > 0.29 && s < 0.8 && v < 0.11){
			return ChatColor.GRAY;
		}else if(s > 0.29 && s < 0.6 && v < 0.2){
			return ChatColor.GRAY;
		//NEW COLORS
		}else if(s > 0.6 && h > 0.5666666 && h < 0.602777 && v > 0.12 && v < 0.3){
			return ChatColor.DARK_BLUE;
		}else if(h > 0.5 && h < 0.602777 && v < 0.13){
			return ChatColor.BLACK;        
		}else if(h > 0.95833333 && s > 0.7 && v > 0.19 && v < 0.4){
			return ChatColor.RED;
		}else if(h > 0.8 && h < 0.91666666 && s > 0.35 && v > 0.16 && v < 0.4){
			return ChatColor.DARK_PURPLE;
		}else if(h > 0.3055555 && h < 0.3888888 && s < 0.35 && v > 0.6 && v < 0.8){
			return ChatColor.AQUA;
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.7 && v < 0.95){
			return ChatColor.BLUE;
		}else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.5 && v < 0.71){
			return ChatColor.DARK_BLUE;
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v > 0.7){
			return ChatColor.BLUE;
		}else if(h > 0.5 && h < 0.61 && s > 0.2 && v < 0.71){
			return ChatColor.DARK_BLUE;
		}else if(s < 0.31 && v < 0.16){
			return ChatColor.BLACK;
		//NEW COLORS 2:
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			return ChatColor.BLACK;
		}else if(h > 0.53 && h < 0.7 && s > 0.5 && v < 0.3 && v > 0.15){
			return ChatColor.DARK_BLUE;
		}else if(h > 0.4 && h < 0.53 && s > 0.5 && v < 0.3 && v > 0.15){
			return ChatColor.AQUA;
		}else if(h < 0.4 && h > 0.2777777 && s > 0.5 && v < 0.3 && v > 0.15){
			return ChatColor.DARK_GREEN;
		}else if(h < 0.25 && h > 0.2 && s > 0.6 && v < 0.25 && v > 0.15){
			return ChatColor.DARK_RED;
		}else if(h > 833333 && h < 94 && s > 0.6 && v < 0.4 && v > 0.15){
			return ChatColor.DARK_PURPLE;
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v > 0.8){
			return ChatColor.BLUE;
		}else if(h > 0.541 && h < 0.64 && s < 0.4 && s > 0.2 && v > 0.3){
			return ChatColor.DARK_BLUE;
		}else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v < 0.5 && v > 0.2){
			return ChatColor.DARK_BLUE;
		}else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
			return ChatColor.GRAY;
		// NEW COLORS 3
		}else if(h > 0.85 && s > 0.2 && s < 0.41 && v > 0.9){
			return ChatColor.LIGHT_PURPLE;
		}else if(h > 0.763 && s > 0.2 && s < 0.41 && v > 0.5){
			return ChatColor.DARK_PURPLE;
		}else if(h > 0.125 && h < 0.191666666 && s > 0.25 && s < 0.4 && b > 0.89){
			return ChatColor.YELLOW;
		}else if(h > 0.125 && h < 0.191666666 && s > 0.25 && s < 0.4 && b < 0.81 && b > 0.3){
			return ChatColor.DARK_RED;
		}else if(h > 0.222222 && h < 0.2777777777 && s > 0.2 && s > 0.4 && b > 0.85){
			return ChatColor.GREEN;
		}else if(h > 0.222222 && h < 0.2777777777 && s > 0.2 && s > 0.4 && b > 0.4 && b < 0.8){
			return ChatColor.DARK_GREEN;
		}else if(s < 0.114 && b < 0.71 && b > 0.15){
			return ChatColor.GRAY;
		}else{
			return ChatColor.WHITE; // nothing matched
		}
	}
}
