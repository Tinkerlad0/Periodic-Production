package com.tinkerlad.chemistry.block.machine.rocketMaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityRocketMaker extends TileEntity implements IInventory {

	private ItemStack[] inv;

	public TileEntityRocketMaker() {
		inv = new ItemStack[9];
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	/**
	 * Returns the stack in slot i
	 *
	 * @param slot
	 */
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 *
	 * @param slot slot being decremented
	 * @param amt  how much to decrease by
	 *             0
	 */
	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 *
	 * @param slot
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 *
	 * @param slot
	 * @param stack
	 */
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {

		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory
	 */
	@Override
	public String getInventoryName() {
		return "Rocket Crafter";
	}

	/**
	 * Returns if the inventory is named
	 */
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 *
	 * @param var1
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 *
	 * @param var1
	 * @param var2
	 */
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}
}
