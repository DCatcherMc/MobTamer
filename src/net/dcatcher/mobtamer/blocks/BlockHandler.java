package net.dcatcher.mobtamer.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.dcatcher.mobtamer.utils.DCConfig;
import net.dcatcher.mobtamer.utils.DCModInfo;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static Block blockInfusedBrick;
	

	public static void register(){
		blockInfusedBrick = new BlockInfusedBrick(DCConfig.idInfusedBrick);
		GameRegistry.registerBlock(blockInfusedBrick, DCModInfo.BLOCK_INFUSED_BRICK_UNLOCALIZED);
		
		
	}
}
