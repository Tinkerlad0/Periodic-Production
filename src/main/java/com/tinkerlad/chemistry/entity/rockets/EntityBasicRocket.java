package com.tinkerlad.chemistry.entity.rockets;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBasicRocket extends Entity {

    double gravity = 0.49; //m/s
    double r2 = Math.sqrt(2D);
    int maxHeight = 220;
    int burnTime;
    private int burnPower;
    private double pitch, yaw;
    private boolean launched = false;
    private int flightTotalTime = 480;
    private double motionX, motionY, motionZ;
    private boolean stuck;

    public EntityBasicRocket(World world) {
        super(world);
        setSize(1F, 2F);
        motionY = motionX = motionZ = 0;
    }

    public EntityBasicRocket(World world, int burnTime, double pitch, double yaw, int burnPower) {
        super(world);
        this.burnTime = burnTime;
        this.pitch = pitch;
        this.yaw = yaw;
        this.burnPower = burnPower;
        writeEntityToNBT(new NBTTagCompound());
    }

    @Override
    protected void entityInit() {

    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        if (burnTime > 0) {
            motionX += (burnPower * Math.cos(pitch) * Math.cos(yaw));
            motionY += (burnPower * Math.sin(pitch));
            motionZ += (burnPower * Math.cos(pitch) * Math.sin(yaw));
        } else {
            motionX *= 0.98;
            motionY -= gravity;
            motionZ *= 0.98;
        }

        Double xPos = posX;
        Double yPos = posY;
        Double zPos = posZ;

        float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f) * 180.0D / Math.PI);

        if (worldObj.getBlock(xPos.intValue(), yPos.intValue(), zPos.intValue()) == Blocks.air) {
            stuck = true;
        } else {
            posX += motionX;
            posY += motionY;
            posZ += motionZ;
            this.setPosition(this.posX, this.posY, this.posZ);
        }

    }

    /**
     * returns the bounding box for this entity
     */
    @Override
    public AxisAlignedBB getBoundingBox() {
        return boundingBox;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     *
     * @param tagCompound
     */
    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {

        this.burnTime = tagCompound.getInteger("burnTime");
        this.burnPower = tagCompound.getInteger("burnPower");
        this.pitch = tagCompound.getDouble("pitch");
        this.yaw = tagCompound.getDouble("yaw");
        this.motionX = tagCompound.getDouble("motionX");
        this.motionY = tagCompound.getDouble("motionY");
        this.motionZ = tagCompound.getDouble("motionZ");
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     *
     * @param tagCompound
     */
    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {

        tagCompound.setInteger("burnTime", burnTime);
        tagCompound.setInteger("burnPower", burnPower);
        tagCompound.setDouble("pitch", pitch);
        tagCompound.setDouble("yaw", yaw);
        tagCompound.setDouble("motionX", motionX);
        tagCompound.setDouble("motionY", motionY);
        tagCompound.setDouble("motionZ", motionZ);
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     *
     * @param par1Entity
     */
    @Override
    public AxisAlignedBB getCollisionBox(Entity par1Entity) {
        return boundingBox;
    }
}