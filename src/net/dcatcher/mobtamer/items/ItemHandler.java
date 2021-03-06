package net.dcatcher.mobtamer.items;

import net.dcatcher.mobtamer.utils.DCConfig;
import net.minecraft.item.Item;
import net.dcatcher.mobtamer.items.food.*;

public class ItemHandler {

	public static Item disguiser, wandOfRiding;
	
	public static Item itemBeefInfused, itemPorkInfused, itemMuttonRaw, itemMuttonCooked, itemMuttonInfused,
						itemBreadInfused, itemAppleInfused;

	public static Item infusionDust;
	
	public static void registerItems(){
		disguiser = new ItemMobTamer(DCConfig.idMysticSaddle -256);
		wandOfRiding = new ItemWandOfRiding(DCConfig.idWandOfRiding -256);
		
		infusionDust = new ItemInfusionDust(DCConfig.idInfusionDust -256);
		
		
		
		itemBeefInfused = new ItemBeefInfused(DCConfig.idBeefInfused - 256);
		itemPorkInfused = new ItemPorkInfused(DCConfig.idPorkInfused - 256);
		itemMuttonRaw = new ItemMuttonRaw(DCConfig.idMuttonRaw - 256);
		itemMuttonCooked = new ItemMuttonCooked(DCConfig.idMuttonCooked - 256);
		itemMuttonInfused = new ItemMuttonInfused(DCConfig.idMuttonInfused - 256);
		itemBreadInfused = new ItemBreadInfused(DCConfig.idBreadInfused - 256);
		itemAppleInfused = new ItemAppleInfused(DCConfig.idAppleInfused - 256);
		
	}

}
