package net.dcatcher.mobtamer.blocks;

import net.dcatcher.mobtamer.MobTamer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDC extends Block {

	public BlockDC(int id, Material material) {
		super(id, material);
		setCreativeTab(MobTamer.tabJam);
	}

}

