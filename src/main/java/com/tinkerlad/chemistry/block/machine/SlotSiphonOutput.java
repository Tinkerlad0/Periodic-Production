package com.tinkerlad.chemistry.block.machine;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSiphonOutput extends Slot {

	public SlotSiphonOutput(IInventory inventory, int x, int y, int z) {
		super(inventory, x, y, z);
	}

	@Override
	public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
		super.onPickupFromSlot(entityPlayer, itemStack);
		FMLCommonHandler.instance().firePlayerCraftingEvent(entityPlayer, itemStack, inventory);
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}
}
