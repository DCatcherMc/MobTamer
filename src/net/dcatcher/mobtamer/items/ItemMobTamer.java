package net.dcatcher.mobtamer.items;

import net.dcatcher.mobtamer.MobTamer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobTamer extends Item {

	public ItemMobTamer(int par1) {
		super(par1);
		setUnlocalizedName("mobTamer");
		setMaxStackSize(1);
		setCreativeTab(MobTamer.tabJam);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mystic_saddle");
	}
	

}
