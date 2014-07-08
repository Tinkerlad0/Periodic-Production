package com.tinkerlad.chemistry.block.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachine extends TileEntity {

	protected byte state;
	protected String customName;

	public TileEntityMachine() {
		state = 0;
		customName = "";
	}

	public short getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);


		if (nbtTagCompound.hasKey("state")) {
			this.state = nbtTagCompound.getByte("state");
		}

		if (nbtTagCompound.hasKey("customName")) {
			this.customName = nbtTagCompound.getString("customName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte("state", state);

		if (this.hasCustomName()) {
			nbtTagCompound.setString("customName", customName);
		}
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}
}
