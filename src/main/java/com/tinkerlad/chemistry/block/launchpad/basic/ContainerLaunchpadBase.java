package com.tinkerlad.chemistry.block.launchpad.basic;

import com.tinkerlad.chemistry.Chemistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerLaunchpadBase extends Container {

	public IInventory craftMatrix;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerLaunchpadBase(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
		craftMatrix = new InventoryCrafting(this, 5, 5);
		worldObj = world;
		posX = i;
		posY = j;
		posZ = k;

		this.addSlotToContainer(new SlotLaunchpad(craftMatrix, 0, 80, 31));


		for (int i1 = 0; i1 < 3; i1++) {
			for (int l1 = 0; l1 < 9; l1++) {
				this.addSlotToContainer(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18,
						                                106 + i1 * 18));
			}
		}

		for (int j1 = 0; j1 < 9; j1++) {
			this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18, 164));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(par2);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (par2 == 0) {
				if (!mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}
			} else if (par2 >= 10 && par2 < 37) {
				if (!mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (par2 >= 37 && par2 < 46) {
				if (!mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize != itemstack.stackSize) {
				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			} else {
				return null;
			}
		}
		return itemstack;
	}

	public void onContainerClosed(EntityPlayer entityplayer) {
		super.onContainerClosed(entityplayer);
		if (worldObj.isRemote) {
			return;
		}
		for (int i = 0; i < 25; i++) {
			ItemStack itemstack = craftMatrix.getStackInSlot(i);
			if (itemstack != null) {
				entityplayer.entityDropItem(itemstack, (float) (Chemistry.RANDOM.nextFloat() * Math.PI));
			}
		}
	}

	public void onCraftMatrixChanged(IInventory iinventory) {

	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq((double) posX + 0.5D, (double) posY + 0.5D, (double) posZ + 0.5D) <= 64D;
	}
}
