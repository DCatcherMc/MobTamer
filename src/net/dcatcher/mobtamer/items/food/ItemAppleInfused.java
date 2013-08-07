package net.dcatcher.mobtamer.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.mobtamer.MobTamer;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemAppleInfused extends ItemFood {

	public ItemAppleInfused(int par1) {
		super(par1, 6, 0.4F, false);
		setUnlocalizedName(DCModInfo.FOOD_APPLE_I_NAME);
		setCreativeTab(MobTamer.tabJam);
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:infused_apple");
	}
}
