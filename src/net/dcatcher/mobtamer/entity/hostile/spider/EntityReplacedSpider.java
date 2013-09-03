package net.dcatcher.mobtamer.entity.hostile.spider;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityReplacedSpider extends EntityTameable implements IAnimals
{

	public EntityReplacedSpider(World par1World)
    {
        super(par1World);
        this.setSize(1.4F, 0.9F);
        this.tasks.addTask(1, new EntityAIControlledByPlayer(this, 0.7F));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));

    }
	
	 public boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 @Override
	public boolean interact(EntityPlayer player) {
		player.mountEntity(this);
		return true;
	}
	 
	protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
    }
	
	protected String getLivingSound()
    {
        return "mob.spider.say";
    }
	
	protected String getHurtSound()
    {
        return "mob.spider.hurt";
    }
	
	 protected void playStepSound(int par1, int par2, int par3, int par4)
	    {
	        this.playSound("mob.spider.step", 0.15F, 1.0F);
	    }
	 
	 
	 protected float getSoundVolume()
	    {
	        return 0.4F;
	    }
	 
	 @Override
	    public boolean canBeSteered() {
	    	return true;
	    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

	public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }
	
	public boolean isBesideClimbableBlock()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }
	
	public void setBesideClimbableBlock(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }
	
	protected void entityInit()
    {
        super.entityInit();
    }


   
}
