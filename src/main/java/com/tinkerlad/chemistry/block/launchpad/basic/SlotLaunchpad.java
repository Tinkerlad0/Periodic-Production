package com.tinkerlad.chemistry.block.launchpad.basic;

import com.tinkerlad.chemistry.item.rocketry.ItemBasicRocket;
import com.tinkerlad.chemistry.item.rocketry.ItemCustomRocket;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotLaunchpad extends Slot {

    public SlotLaunchpad(IInventory par1IInventory, int par2, int par3, int par4) {
        super(par1IInventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        Item item = par1ItemStack.getItem();

        if (item instanceof ItemBasicRocket || item instanceof ItemCustomRocket) {
            return true;
        }
        return false;
    }
}
