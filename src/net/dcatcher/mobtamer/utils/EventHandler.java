package net.dcatcher.mobtamer.utils;

import net.dcatcher.mobtamer.entity.cow.EntityReplacedCow;
import net.dcatcher.mobtamer.entity.hostile.creeper.EntityReplacedCreeper;
import net.dcatcher.mobtamer.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.mobtamer.entity.hostile.skeleton.EntityReplacedSkeleton;
import net.dcatcher.mobtamer.entity.hostile.slime.EntityReplacedSlime;
import net.dcatcher.mobtamer.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.mobtamer.entity.hostile.zombie.EntityReplacedZombie;
import net.dcatcher.mobtamer.entity.sheep.EntityReplacedSheep;
import net.dcatcher.mobtamer.items.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventHandler {

	@ForgeSubscribe
	public void onDeath(LivingDeathEvent event){
		if(event.entityLiving instanceof EntitySheep && !event.entityLiving.isChild()){
			if(!event.entityLiving.worldObj.isRemote)
				event.entityLiving.dropItem(ItemHandler.itemMuttonRaw.itemID, 2);
		}
	}
	
	@ForgeSubscribe
	public void onInteract(EntityInteractEvent event){
		EntityLiving entity = (EntityLiving)event.target;
		EntityPlayer player = event.entityPlayer;
		World world = event.entity.worldObj;
		
		int xCoord = 0, yCoord = 0, zCoord = 0;
		float yaw = 0, pitch = 0;
		
		xCoord = (int)entity.posX;
		yCoord = (int)entity.posY;
		zCoord = (int)entity.posZ;
		yaw = entity.rotationYaw;
		pitch = entity.rotationPitch;
		
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ItemHandler.disguiser.itemID){
			if(entity instanceof EntitySheep && !entity.isChild()){
				int color = ((EntitySheep) entity).getFleeceColor();
				entity.setDead();
				EntityReplacedSheep e = new EntityReplacedSheep(world);
				if(!world.isRemote){
					e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
					e.setFleeceColor(color);
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			
			
			if(entity instanceof EntityCow && !entity.isChild() && !(entity instanceof EntityMooshroom)){
				entity.setDead();
				Entity e = new EntityReplacedCow(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
				
			if(entity instanceof EntityEnderman && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedEnderman(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			
			if(entity instanceof EntitySpider && !entity.isChild() && !(entity instanceof EntityCaveSpider)){
				entity.setDead();
				Entity e = new EntityReplacedSpider(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			
			if(entity instanceof EntityCreeper && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedCreeper(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			
			if(entity instanceof EntityZombie && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedZombie(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			
			if(entity instanceof EntitySkeleton && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedSkeleton(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}

			if(entity instanceof EntityPig && !entity.isChild()){
				((EntityPig) entity).setSaddled(true);
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
            }
		}
		
	}
}
