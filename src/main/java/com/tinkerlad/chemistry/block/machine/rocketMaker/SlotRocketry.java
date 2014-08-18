package com.tinkerlad.chemistry.block.machine.rocketMaker;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class SlotRocketry extends Slot {

	public List<Item> validItems;

	public SlotRocketry(IInventory par1IInventory, int par2, int par3, int par4, List<Item> items) {
		super(par1IInventory, par2, par3, par4);
		validItems = items;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	 *
	 * @param stack
	 */
	@Override
	public boolean isItemValid(ItemStack stack) {
		for (Item baseItem : validItems) {
			return stack.getItem().getClass() == baseItem.getClass();
		}
		return false;
	}
}
