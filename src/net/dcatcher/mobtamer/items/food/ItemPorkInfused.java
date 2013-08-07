package net.dcatcher.mobtamer.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.mobtamer.MobTamer;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemPorkInfused extends ItemFood {

	public ItemPorkInfused(int par1) {
		super(par1, 10, 0.8F, true);
		setUnlocalizedName(DCModInfo.FOOD_PORK_I_NAME);
		setCreativeTab(MobTamer.tabJam);
	
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("dcmodjam:infused_pork");
	}


}
