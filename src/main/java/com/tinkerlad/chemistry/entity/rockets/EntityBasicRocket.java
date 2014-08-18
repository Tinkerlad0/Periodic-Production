package com.tinkerlad.chemistry.entity.rockets;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityBasicRocket extends Entity {

	double gravity = 0.49; //m/s
	int maxHeight = 220;
	private int destX, destY, destZ;
	private boolean launched = false;
	private int flightTotalTime = 480;
	private double motionX, motionY, motionZ;

	public EntityBasicRocket(World world) {
		super(world);
		setSize(1F, 2F);
		motionY = motionX = motionZ = 0;
	}

	public void launch(int destX, int destY, int destZ) {

		int dX = (int) (destX - posX);
		int dY = (int) (destY - posY);
		int dZ = (int) (destZ - posZ);

		motionY = gravity * (flightTotalTime / 2);
		motionX = dX / flightTotalTime;
		motionZ = dZ / flightTotalTime;

		float yaw = (float) Math.toDegrees(Math.atan(dZ / dX));
		float pitch = (float) Math.toDegrees(Math.atan((240 - posY) / (Math.sqrt(Math.pow(dX, 2) + Math.pow(dZ, 2)))));

		this.setRotation(yaw, pitch);

		launched = true;
	}

	@Override
	protected void entityInit() {

	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		if (ticksExisted == 20) {
			launch(0, 0, 0);
		}

		motionY -= gravity;

		if (isCollidedVertically) { motionY = 0; }

		if (ticksExisted >= 600) {
			this.setDead();
		}

		this.posX += motionX;
		this.posY += motionY;
		this.posZ += motionZ;
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

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 *
	 * @param tagCompound
	 */
	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {

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
