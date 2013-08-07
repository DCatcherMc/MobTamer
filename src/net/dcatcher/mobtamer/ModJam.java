package net.dcatcher.mobtamer;

import net.dcatcher.mobtamer.blocks.BlockHandler;
import net.dcatcher.mobtamer.entity.EntityHandler;
import net.dcatcher.mobtamer.items.ItemHandler;
import net.dcatcher.mobtamer.proxy.CommonProxy;
import net.dcatcher.mobtamer.utils.DCConfig;
import net.dcatcher.mobtamer.utils.DCCreativeTab;
import net.dcatcher.mobtamer.utils.DCPacketHandler;
import net.dcatcher.mobtamer.utils.LanguageHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid="MobTamer", name="MobTamer", version="0.0.9")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"DCModJam"}, packetHandler	= DCPacketHandler.class)
public class ModJam {
	

	
	@Instance
	public static ModJam instance = new ModJam();

	
	@SidedProxy(clientSide="net.dcatcher.mobtamer.proxy.ClientProxy", serverSide="net.dcatcher.mobtamer.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabJam = new DCCreativeTab(CreativeTabs.getNextID(), "DCatcherTab");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		DCConfig.registerConfig(e.getModConfigurationDirectory());
		MinecraftForge.EVENT_BUS.register(new net.dcatcher.mobtamer.utils.EventHandler());

	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		BlockHandler.register(); 			//Registers ALL the blocks!
		ItemHandler.registerItems();		//registers items
		proxy.registerRendering();			//Registers the rendering stuffs
		LanguageHandler.registerLangs();	//Registers my language stuffs
		EntityHandler.register();			//Registers the entities :)
		DCRecipes.registerRecipes();		//Registers recipes
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
	
	
}
