package net.dcatcher.mobtamer.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.mobtamer.MobTamer;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemWandOfGrowth extends Item{

	public ItemWandOfGrowth(int par1) {
		super(par1);
		setUnlocalizedName(DCModInfo.WAND_OF_GROWTH_NAME);
		setCreativeTab(MobTamer.tabJam);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
	}

}
