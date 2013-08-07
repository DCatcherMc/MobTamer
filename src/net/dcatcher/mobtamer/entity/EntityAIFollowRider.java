package net.dcatcher.mobtamer.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIFollowRider extends EntityAIBase
{
    /** The entity using this AI that is tempted by the player. */
    private EntityCreature temptedEntity;
    private double field_75282_b;
    private double playerPosX;
    private double playerPosY;
    private double playerPosZ;
    private double playerRotationPitch;
    private double playerRotationYaw;

    /** The player that is tempting the entity that is using this AI. */
    private EntityPlayer rider;

    /**
     * A counter that is decremented each time the shouldExecute method is called. The shouldExecute method will always
     * return false if delayTemptCounter is greater than 0.
     */
    private int delayTemptCounter;
    private boolean field_75287_j;

    /**
     * This field saves the ID of the items that can be used to breed entities with this behaviour.
     */
    private int breedingFood;

    /**
     * Whether the entity using this AI will be scared by the tempter's sudden movement.
     */
    private boolean field_75286_m;

    public EntityAIFollowRider(EntityCreature par1EntityCreature, double par2, EntityPlayer player)
    {
        this.temptedEntity = par1EntityCreature;
        this.rider = player;
        this.field_75282_b = par2;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.delayTemptCounter > 0)
        {
            --this.delayTemptCounter;
            return false;
        }
        else
        {
            this.rider = this.temptedEntity.worldObj.getClosestPlayerToEntity(this.temptedEntity, 10.0D);

            if (this.rider == null)
            {
                return false;
            }

            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
            if (this.temptedEntity.getDistanceSqToEntity(this.rider) < 36.0D)
            {
                if (this.rider.getDistanceSq(this.playerPosX, this.playerPosY, this.playerPosZ) > 0.010000000000000002D)
                {
                    return false;
                }

                if (Math.abs((double)this.rider.rotationPitch - this.playerRotationPitch) > 5.0D || Math.abs((double)this.rider.rotationYaw - this.playerRotationYaw) > 5.0D)
                {
                    return false;
                }
            }
            else
            {
                this.playerPosX = this.rider.posX;
                this.playerPosY = this.rider.posY;
                this.playerPosZ = this.rider.posZ;
            }

            this.playerRotationPitch = (double)this.rider.rotationPitch;
            this.playerRotationYaw = (double)this.rider.rotationYaw;
        return this.shouldExecute();
    }


    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.playerPosX = this.rider.posX;
        this.playerPosY = this.rider.posY;
        this.playerPosZ = this.rider.posZ;
        this.field_75287_j = true;
        this.field_75286_m = this.temptedEntity.getNavigator().getAvoidsWater();
        this.temptedEntity.getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.rider = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.delayTemptCounter = 100;
        this.field_75287_j = false;
        this.temptedEntity.getNavigator().setAvoidsWater(this.field_75286_m);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.rider, 30.0F, (float)this.temptedEntity.getVerticalFaceSpeed());

        if (this.temptedEntity.getDistanceSqToEntity(this.rider) < 6.25D)
        {
            this.temptedEntity.getNavigator().clearPathEntity();
        }
        else
        {
            this.temptedEntity.getNavigator().tryMoveToEntityLiving(this.rider, this.field_75282_b);
        }
    }

    public boolean func_75277_f()
    {
        return this.field_75287_j;
    }
}
