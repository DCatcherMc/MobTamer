package net.dcatcher.mobtamer.utils;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class DCConfig {

	public static int idMysticSaddle;
	public static int idBeefInfused, idPorkInfused, idMuttonRaw, idMuttonCooked, idMuttonInfused, idBreadInfused, idAppleInfused;
	public static int idWandOfRiding;
	public static boolean saddleRecipe;
	public static int idInfusionDust;
	
	public static void registerConfig(File directory){
		File configFile = new File(directory + "/TamableMobs.cfg");

        if(!configFile.exists()) {
            try {
               configFile.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cannot make TamableMobs configuration. OH NOES!");
                ex.printStackTrace();
            }
        }
		Configuration c = new Configuration(configFile);
		
		
		//Load config:
		c.load();
		
		saddleRecipe = c.get("Addon Recipes", "VanillaSaddleRecipe", true).getBoolean(true);

		idMysticSaddle = c.getItem("MysticSaddle", 5000).getInt();
		idWandOfRiding = c.getItem("WandOfRiding", 5001).getInt();
		idInfusionDust = c.getItem("InfusionDust", 5002).getInt();
		
		//Foods:
		idBeefInfused = c.getItem("InfusedBeef", 5005).getInt();
		idPorkInfused = c.getItem("InfusedPork", 5006).getInt();
		idMuttonRaw = c.getItem("MuttonRaw", 5007).getInt();
		idMuttonCooked = c.getItem("MuttonCooked", 5008).getInt();
		idMuttonInfused = c.getItem("InfusedMutton", 5009).getInt();
		idBreadInfused = c.getItem("InfusedBread", 5010).getInt();
		idAppleInfused = c.getItem("InfusedApple", 5011).getInt();

		//Save config:
		c.save();
	}
	
}
