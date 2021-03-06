package net.dcatcher.mobtamer.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.mobtamer.MobTamer;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemInfusionDust extends Item {

	public ItemInfusionDust(int par1) {
		super(par1);
		setCreativeTab(MobTamer.tabJam);
		setUnlocalizedName(DCModInfo.ITEM_INFUSION_DUST);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:infusion_dust");
	}

}
