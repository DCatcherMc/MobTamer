package net.dcatcher.mobtamer.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.mobtamer.MobTamer;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemMuttonRaw extends ItemFood{

	public ItemMuttonRaw(int par1) {
		super(par1, 4, 0.5f, true);
		setCreativeTab(MobTamer.tabJam);
		setUnlocalizedName(DCModInfo.FOOD_MUTTONRAW_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mutton_raw");
	}


}
