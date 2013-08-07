package net.dcatcher.mobtamer.utils;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class DCPacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		if(packet.channel.equals("DCModJam")){
		}
		
	}
	
	private void handleDCMobType(Packet20NamedEntitySpawn packet){
		
	}
	
}


